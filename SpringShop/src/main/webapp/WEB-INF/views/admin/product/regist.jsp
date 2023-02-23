<%@page import="java.util.List"%>
<%@page import="com.edu.springshop.domain.Category"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Category> categoryList =(List)request.getAttribute("categoryList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>
<%@ include file="../inc/header_link.jsp"%>
<style type="text/css">
.box-style{
	width:90px;
	height:95px;
	border:1px solid #ccc;
	display:inline-block;
	margin:5px;
}
.box-style img{
	width : 85px;
	height : 90px;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Preloader -->
		<%@ include file="../inc/preloader.jsp" %>
		
		<!-- Navbar -->
		<%@ include file="../inc/navbar.jsp" %>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../inc/sidebar_left.jsp" %>
		
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">상품등록</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">상품관리> 상품등록</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<section class="content" id="app1">
				<div class="container-fluid">
				
					<!-- Main row -->
					<div class="row">
						<div class="col">
							
							<div class="form-group row">
								<div class="col">
									<select class="form-control" name="category_idx">
										<option value="0"> 카테고리 선택</option>
										<%for(Category category : categoryList){ %>
										 <option value="<%=category.getCategory_idx() %>"><%=category.getCategory_name() %></option>
                                      <%} %>
									</select>
								</div>
							</div>							
							
							<div class="form-group row">
								<div class="col">
									<input type="email" class="form-control" name="product_name" placeholder="상품명">
								</div>
							</div>							
							<div class="form-group row">
								<div class="col">
									<input type="email" class="form-control" name="brand" placeholder="브랜드명">
								</div>
							</div>							
							<div class="form-group row">
								<div class="col">
									<input type="number" class="form-control" name="price">
								</div>
							</div>					
							<div class="form-group row">
								<div class="col">
									<input type="number" class="form-control" name="discount">
								</div>
							</div>
								
							<div class="form-group row">
								<div class="col">
									<input type="file" class="form-control" name="file" multiple>
								</div>
							</div>
							
							<div class="form-group row" id="previewArea">
								<div class="col">
									<template v-for="json in imageList">
										<imagebox :key="json.key" :src="json.binary" :idx="json.key"/>
									</template>
								</div>
							</div>
							<div class="form-group row">
								<div class="col">
									<textarea class="form-control" id="detail" name="detail"></textarea>
								</div>
							</div>
														
							<div class="form-group row">
								<div class="col">
									<button type="button" class="btn btn-danger" id="bt_regist">등록</button>							
									<button type="button" class="btn btn-danger" id="bt_list">목록</button>									
								</div>
							</div>
							</div>					
						</div>
					</div>
					<!-- /.row (main row) -->
				</div>
				<!-- /.container-fluid -->
			
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		
		<%@ include file="../inc/footer.jsp" %>		

		<!-- Control Sidebar -->
		<%@ include file="../inc/sidebar_right.jsp" %>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<%@ include file="../inc/footer_link.jsp" %>
	<script type="text/javascript">
		let app1;
		let key=0; // 유저가 프로그램을 사용하는 동안 그 값을 계속 증가시킴, 유일성 확보
		const imagebox={
			template:`
				<div class="box-style">
					<div>X</div>
					<img :src="p_src">	
				</div>
			`,
		/*이 컴포넌트를 태그로 호출하는 자가 넘긴 속성을 받으려면 props로 받아야 한다 */
		props: ['src', 'idx']
		, data() {
		return {
			p_src:this.src,
			p_idx:this.idx
		};
	}
		};
	function init() {
		app1=new Vue({
			el:"#app1",
			components:{
				imagebox
			},
			data:{
				count:5,
				imageList:[]  //files(read only) 배열의 정보를  담아놓을 배열
			}
		});
	}
		// 사용자가 선택한 이미지가 이미 app1.imageList에 들어있는지 여부 판단하기
		function checkDuplicate(filename) {
			let count=0;
			for(let i=0; i<app1.imageList.length; i++) {
				let json = app1.imageList[i];
				if (json.name==filename) { // 동일한 이름이 발견된다면
					count++;
					break;
				}
			}
			return count;
		}
		/*-------------------------------
		미리보기 
		----------------------------------*/
		function preview(files) {
			console.log("files는 ", files);
			
			// 배열 안에 들어있는 파일 정보를 하나씩 읽어들여 화면에 출력
			for(let i=0; i<files.length; i++) {
				// 배열에 들어있는 파일 하나씩 꺼내기
				let file = files[i]; // 대상파일에 넣어주려고 꺼냄
				
				if(checkDuplicate(file.name) < 1) { // 1보다 작으면 발견된게 없으니까 추가
					let reader = new FileReader(); // 파일 입력스트림 생성
					reader.onload=(e)=>{
						console.log("이미지 읽기 완료", e);
						console.log("file정보는 ", file);
						console.log("정보는 ", e.target.result); // 바이너리 정보 

						let json=[]; //  empty			
						json['key']=key; // 고유 값 넣기, 추후 이미지 삭제시 고유 값을 사용하려고
						json['name']=file.name; // 중복 이미지 체크시 사용예정
						json['binary']=e.target.result; // img.src에 대입할 예정
						json['file']=file; // 파일 자제에 대한 모든 정보
						
						key++;
						
						console.log("key 값은 ", key);
						
						console.log("i 값은 ", i);
						
						app1.imageList.push(json);
					}
					reader.readAsDataURL(file);
				}
			}
		}
		
		/*-------------------------------
		등록
		----------------------------------*/
		function regist(){
			//파일 업로드를 커스텀
			let formData = new FormData();
			//Product에서 private Category category; 로 줬기 때문에 category.category_idx를 넘겨줘야 받을 수 있음
			formData.append("category.category_idx", $("select[name='category_idx']").val());		
			formData.append("product_name", $("input[name='product_name']").val());
			formData.append("brand", $("input[name='brand']").val());
			formData.append("price", $("input[name='price']").val());
			formData.append("discount", $("input[name='discount']").val());
            formData.append("detail", $("textarea[name='detail']").val());
			
			//선택한 이미지 수만큼 formData에 추가
			for(let i=0; i<app1.imageList.length; i++){
				let json=app1.imageList[i];
				formData.append("photo", json.file );
			}
			
			$.ajax({
				url:"/admin/rest/product",
				type:"post",
				data:formData,
				processData:false,		/*query string 사용여부*/
				contentType:false,		/*application/x-www-form~~ 사용여부*/
				success: function(result, status, xhr){
					alert(result.msg);
					console.log(result);
				}
			})
		}
		
		//서머노트 적용하기 
		$(function(){
			init();	
		
			$("#detail").summernote({
				height:200
			});
			
			//파일에 이벤트 연결 
			$("input[name='file']").change(function(){
				console.log(this.files);
				preview(this.files);
			});
			
			//등록이벤트 연결
			$("#bt_regist").click(function(){
				regist();
			});
			
			$("#bt_list").click(function(){
				location.href="/admin/product/list";
			});
		});
	
	</script>
</body>
</html>