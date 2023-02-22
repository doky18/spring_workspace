<%@page import="com.edu.springshop.domain.Category"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	
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
	width:75px;
	height:70px;
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
					
						<div class="col-7">
						    <div class="card">
						        <!-- /.card-header -->
					        	
					        	
						        <div class="card-body table-responsive p-0">
						            <table class="table table-hover text-nowrap">
						                <tbody>
											<tr>
												<td colspan="2">
									        		<div class="form-group row">
									        			<div class="col-sm-9">
										                    <input type="text" name="category_name" class="form-control" placeholder="Search">
									        			</div>
									        			<div class="col-sm-3">
										                    <button type="button" class="btn btn-danger" id="bt_regist">등록</button>
									        			</div>
									        		</div>
												</td>
											</tr>
											
											<template v-for="category in categoryList">						                
						                    	<row :key="category.category_idx" :obj="category"/>
						                    </template>
						                </tbody>
						            </table>
						        </div>
						        
						        
						        <!-- /.card-body -->
						    </div>
						    <!-- /.card -->
						</div>					
					
					
						<div class="col-5">
						    <div class="card">
						    
						        <div class="card-body">
					        		<div class="form-group row">
					        			<div class="col-6">
						                    <input type="text" name="table_search" class="form-control" >
					        			</div>
					        			<div class="col-3">
						                    <button type="button" class="btn btn-danger" >수정</button>
					        			</div>
					        			<div class="col-3">
						                    <button type="button" class="btn btn-danger" >삭제</button>
					        			</div>
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
		
		//2. row template 등록하기
		//3. body 영역에 등록하기
		//4. props, data 만지기
		//5. template에 변수 지정
		const row={
			template:`
				<tr>
					<td>{{category.category_idx}}</td>
					<td>{{category.category_name}}</td>
				</tr>
			`,
			props:["obj"],
			data(){
				return{
					category:this.obj
				};
			}
		};
		
		//1.vue app1 등록하기--> row 등록
		app1=new Vue({
			el:"#app1",
			components:{
				row
			},
			data:{
				count:5,
				categoryList:[]  //files(read only) 배열의 정보를  담아놓을 배열
			}
		});
		
		/*------------------------------------------
		중복된 이미지체크
		------------------------------------------*/
		function checkDuplicate(filename){
			let count=0;
			
			for(let i=0;i<app1.imageList.length;i++){
				let json=app1.imageList[i];
				if(json.name==filename){ //중복발견..
					count++;
					break;
				}
			}
			return count;
		}
		
		/*------------------------------------------
		미리보기
		------------------------------------------*/
		function preview(files){
			
			//이미지 화면에 출력
			for(let i=0;i<files.length;i++){
				let file = files[i];
				
				if(checkDuplicate(file.name) <1){ //중복된 이미지가 없을때만...
					let reader = new FileReader();//스트림 생성
					reader.onload=(e)=>{
						
						key++; //사용자가 이미지를 선택할때마다 1씩 증가하여 중복을 불허한다
						
						let json=[]; // imageList배열에 복합적인 정보를 담아놓기 위해 
						json['key']=key;//추후 이미지 삭제시 기준값으로 사용예정 
						json['name']=file.name; //중복이미지가 추가되지 않도록... 
						json['binary']=e.target.result; //src에 대입할 바이너리 정보 
						json['file']=file; //전송할때 파라미터에 심을 파일
						
						app1.imageList.push(json);
					};
					reader.readAsDataURL(file);//파일읽기
				}
			}
		}
		
		/*------------------------------------------
		등록
		------------------------------------------*/
		function regist(){
			$.ajax({
				url:"/admin/rest/category",
				type:"post",
				data:{
					category_name:$("input[name='category_name']").val()
				},
				//서버로부터 전송된 HTTP 응답 헤더 정보가 성공일 때 반응
				success:function(result, status, xhr){
					alert(result.msg);			//{code:, msg}
					console.log(result);
				},
				//서버로부터 전송된 HTTP 응답 헤더 정보가 실패일 때 반응
				error:function(xhr, staus, err){
					alert("에러에요"+err);
				}
			});
			
		}
		
		function getCategoryList() {
			//서버에서 비동기로 가져다가, app1의 categoryList에 대입
			$.ajax({
				url:"/admin/rest/category",
				type:"get",
				success:function(result, status, xhr){
					app1.categoryList = result;s
				}
				
			});
		}
		
		//서머노트 적용하기 
		$(function(){
			//비동기로 카테고리 목록 가져오기
			getCategoryList();
			
			//등록 이벤트 연결 
			$("#bt_regist").click(function(){
				regist();
			});
			
		});
	
	</script>
</body>
</html>








