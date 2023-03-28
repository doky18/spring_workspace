<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- bootstrap 1 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- jquery 2 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<!-- vue 2 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2.7.14/dist/vue.js"></script>
<script type="text/javascript">

	function regist(){
		$("#form1").attr({
			action:"/member/join.jsp",
			method:"post"
		});	
		$("#form1").submit();
	}
	
	function gotoAuthForm(sns){
		$.ajax({
			url:"/rest/member/authform/"+sns,
			type:"get",
			success:function(result, status, xhr){
				console.log("인증주소는 ", result.msg);
				location.href=result.msg;
			}
		});
	}
	
	$(function(){
		$("#bt_google").click(function(){
		gotoAuthForm("google");
		});
	});
	
	$(function(){
		$("#bt_naver").click(function(){
		gotoAuthForm("naver");
		});
		
	$(function(){
		$("#bt_kakao").click(function(){
		gotoAuthForm("kakao");
		});
	});
	});
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<div class="container p-3 my-3 bg-dark text-white">
					<button type="button" class="btn btn-secondary" id="bt_google">구글</button>
					<button type="button" class="btn btn-success" id="bt_naver">네이버</button>
					<button type="button" class="btn btn-warning" id="bt_kakao">카카오</button>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>