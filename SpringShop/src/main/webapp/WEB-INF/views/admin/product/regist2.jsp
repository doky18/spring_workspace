<%@ page contentType="text/html;charset=UTF-8"%>
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
	width : 75px;
	height : 70px;
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
									<select class="form-control" name="category_idx"></select>
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
										<imagebox :key="json.key" :obj="json"/>
									</template>
								</div>
							</div>
							<div class="form-group row">
								<div class="col">
									<textarea class="form-control" id="detail" name="detail"></textarea>
								</div>
							</div>
														
							<div class="form-group row">
								<div class="col-sm-1">
									<button type="button" class="btn btn-block btn-danger btn-lg">등록</button>							
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-block btn-danger btn-lg">목록</button>									
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
		let key = 0;
		
		
		let key=0; // 유저가 프로그램을 사용하는 동안 그 값을 계속 증가시킴, 유일성 확보
		const imagebox={
			template:`
				<div class="box-style">
					<div v-on:click="del(json)">X</div>
					<img :src="json.binary"/>	
				</div>
			`,
		/*이 컴포넌트를 태그로 호출하는 자가 넘긴 속성을 받으려면 props로 받아야 한다 */
		props: ["obj"]
		, data() {
		return {
			json:this.obj
		};
	},
		methods:{
			del(){
				alert("삭제할래?");
				console.log("선택한 이미지에 대한 json은", json);
				
				//선택한 이미지에 대한 json이 배열에 있는지
				//없으면 -1, 있으면 0 이상의 수(즉, 발견된 index 번째)
				app1.imageList.indexOf(json);
				console.log("index is", index);
				
				//Vue는 데이터만 지워도, UI가 반응을 보인다..(즉 자동으로 동기화) bind 되어있다
				app1.imageList.splice(index, 1);
			}	
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
		//중복된 이미지 체크
		function checkDuplicate(filename){
			let count=0;
			
			for(let i=0;i<appq.imageList.length;i++){
				let json = app1.imageList[i];
				if(json.name==filename){//중복발견..
					count++;
					break;
				}
			}
			
			return count;
		}
		
		// 이미지 미리보기 구현하기
		function preview(files) {
			console.log("files는 ", files);
			//이미지 화면에 출력
			for(let i=0; i<files.length;i++){
				let file = files[i];
				
				if(checkDuplicate(file.name)<1){		//중복된 이미지가 없을때만...
					let reader = new FileReader();		//스트림 생성
					reader.onload=(e)=>{
						
						key ++;			//사용자가 이미지를 선택할 때 마다 1씩 증가하여 중복을 불허한다
						
						let json=[];		//imageList배열에 복합적인 정보를 담아놓기 위해
						json['key']=key;		//추후 이미지 삭제시 기준값으로 사용예정
						json['name']=file.name;		//중복이미지가 추가되지 않도록..
						json['binary']=e.target.result;		//src에 대입할 바이너리 정보
						json['file']=file;		//전송할 때 파라미터에 심을 파일
						
						app1.imageList.push(json);		//파일읽기
					};
					reader.readAsDataURL(file);			//파일읽기
				}
			}
			
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
			
		});
	
	</script>
</body>
</html>