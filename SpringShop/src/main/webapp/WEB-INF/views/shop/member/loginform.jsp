<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<%@ include file="../inc/header.jsp" %>
</head>

<body>
    <!-- Page Preloder -->
	<%@ include file="../inc/preloader.jsp" %>

    <!-- Offcanvas Menu Begin -->
    <!-- 
    	jsp자체에서 지원하는 태그 
     	왜 써야 하나? 사실 jsp는 디자인 영역이므로, 개발자만 사용하는 것이
     	아니라 퍼블리셔, 웹디자이너와 공유를 한다..이때  java 에 대한 
     	非전문가들은 java 코드를 이해할 수 없기 때문에, 그들이 좀더 쉽게
     	다가갈 수 있도록 태그를 지원해준다 ( 협업 때문에 )
     -->
	<%@ include file="../inc/main_navi.jsp"%>    
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <%@ include file="../inc/header_section.jsp"%>
    <!-- Header Section End -->
    <section>
    	<div class="container">
    		<div class="row m-5">
    			<div class="col">
				    <form id="form1">
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Enter id" name="id">
				        </div>
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Enter pass" name="pass">
				        </div>
				       
				        <button type="button" class="btn btn-success" id="bt_google">Google로 로그인</button>
				        
				        <button type="button" class="btn btn-success" id="bt_naver">Naver로 로그인</button>
				        <button type="button" class="btn btn-success" id="bt_kakao">KaKao로 로그인</button>
				        
				        <button type="button" class="btn btn-success" id="bt_login">Login</button>
				        <button type="button" class="btn btn-success" id="bt_regist">신규가입</button>
				        
				    </form>
    			
    			</div>
    		</div>
    	</div>
    </section>
    
    
    
    
    
	<!-- Instagram Begin -->
	<%@ include file="../inc/insta.jsp" %>
	<!-- Instagram End -->
	
	<!-- Footer Section Begin -->
	<%@ include file="../inc/footer.jsp" %>
	<!-- Footer Section End -->
	
	<!-- Search Begin -->
	<%@ include file="../inc/search.jsp" %>
	<!-- Search End -->

<!-- Js Plugins -->
<%@ include file="../inc/footer_link.jsp" %>
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
		//SNS 사업자가 미리 만들어놓은 인증화면 주소를 요청해야 한다.
		//따라서 주소 및 파라미터명이 이미 정해져 있다..
		//(어디에서 조사해야 하나? 구글 개발자 사이트에 공시되어 있다..)
	gotoAuthForm("google");
	});
});

$(function(){
	$("#bt_kakao").click(function(){
	gotoAuthForm("kakao");
	});
});

$(function(){
	$("#bt_naver").click(function(){
	gotoAuthForm("naver");
	});
});

</script>
</body>

</html>



