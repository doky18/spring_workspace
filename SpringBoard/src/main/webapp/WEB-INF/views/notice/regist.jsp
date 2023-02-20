<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringBD1</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
function regist(){
										//querystring화 시킴
	let formData = $("#form1").serialize(); //title=dd&writer=aaa
	//console.log(formData);
	//비동기로 등록요청
	$.ajax({
		url:"/rest/notices",
		type:"post",
		data: formData,
		success:function(result, status, xhr){
			location.href="/notice/list";
		}
	});
}

 $(function(){
	 $("#bt_regist").click(function(){
		regist();
	 });
 });


</script>
<body>
	<div class="container" id="app1">
		<div class="row">
			<div class="col mt-3">
				<form id="form1">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter title" name="title">
					</div>				
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter writer" name="writer">
					</div>				
					<div class="form-group">
						<textarea class="form-control" name="content"></textarea>
					</div>
									
					<div class="form-group">
						<input type="file" class="form-control" name="file">					
					</div>				
					
					<div class="form-group">
						<button type="button" class="btn btn-primary" id="bt_regist">등록</button>
						<button type="button" class="btn btn-primary" id="bt_list">목록</button>
					</div>				
				</form>				

			</div>
		</div>
	</div>
</body>
</html>