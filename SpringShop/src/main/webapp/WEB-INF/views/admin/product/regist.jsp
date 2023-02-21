<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | 상품등록</title>
<%@ include file="../inc/header_link.jsp"%>
<style type="text/css">
.box-style{
	width:90px;
	height:95px;
	border:1px solid #ccc;
	display:inline-block;
	margin: 5px;
}
</style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Preloader -->
		<%@ include file="../inc/preloader.jsp"%>

		<!-- Navbar -->
		<%@ include file="../inc/navbar.jsp"%>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../inc/sidebar_left.jsp"%>


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">-----</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Dashboard v1</li>
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
				<div id="container-fluid">
					<div class="row">
						<div class="col">
							<div class="form-group row">
								<div class="col">
									<select class="form-control" id="category"></select>
								</div>
							</div>
							<form id="form1">
								<div class="form-group row">
									<input type="text" class="form-control" placeholder="상품명" id="id" name="name">
								</div>

								<div class="form-group row">
									<input type="text" class="form-control" placeholder="브랜드" id="brand" name="brand">
								</div>

								<div class="form-group row">
									<input type="number" class="form-control" id="discount" name="price">
								</div>

								<div class="form-group row">
									<div class="col">
										<input type="file" name="file" multiple>
									</div>
								</div>

								<div class="form-group row">
									<div class="col">
										<template v-for="i in count">
											<imagebox/>
										</template>
									</div>
								</div>

								<div class="form-group row">
									<div class="col">
										<textarea type="number" class="form-control" name="detail" id="detail"></textarea>
									</div>
								</div>
								
								<div class="form-group">
									<button type="button" class="btn btn-primary" id="bt_regist">등록</button>
									<button type="button" class="btn btn-primary" id="bt_list">목록</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<%@ include file="../inc/footer.jsp"%>

		<!-- Control Sidebar -->
		<%@ include file="../inc/sidebar_right.jsp"%>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<%@ include file="../inc/footer_link.jsp"%>

	<script type="text/javascript">
		let app1;
		
		const imagebox={
			template:`
				<div class="box-style">
					<div>X</div>
					<img src=""/>
				</div>
			`,
			data(){
				return{
					
				};
			},
		};
		
		app1= new Vue({
			el:"#app1",
			components:{
				imagebox				
			},
			data:{
				count:5,
				imageList:[]		//files(read only) 배열의 정보를 담아놓을 배열
			}
		});
		
		function preview(files){
			//정보를 분석하여 json으로 바꾼다..
			let json=[];
			json["key"]=0;		//삭제시 사용..
			json["key"]=0;		//삭제시 사용..
			json["key"]=0;		//삭제시 사용..
			json["key"]=0;		//삭제시 사용..
			json["key"]=0;		//삭제시 사용..
			json["key"]=0;		//삭제시 사용..
			
		}
	
		//서머노트 적용하기
		$(function() {
			$("#detail").summernote({
				height : 200
			});
			
			//파일에 이벤트 연결
			$("input[name='file']").change(function(){
				//alert();
				console.log(this.files);
				preview(this.files);
			});
		});
	</script>
</body>
</html>









