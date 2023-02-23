<%@page import="com.jspshop.domain.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.jspshop.repository.CategoryDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<%@ include file="/inc/header.jsp" %>
</head>

<body>
    <!-- Page Preloder -->
	<%@ include file="/inc/preloader.jsp" %>

    <!-- Offcanvas Menu Begin -->
    <!-- 
    	jsp자체에서 지원하는 태그 
     	왜 써야 하나? 사실 jsp는 디자인 영역이므로, 개발자만 사용하는 것이
     	아니라 퍼블리셔, 웹디자이너와 공유를 한다..이때  java 에 대한 
     	非전문가들은 java 코드를 이해할 수 없기 때문에, 그들이 좀더 쉽게
     	다가갈 수 있도록 태그를 지원해준다 ( 협업 때문에 )
     -->
	<%@ include file="/inc/main_navi.jsp"%>    
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <%@ include file="/inc/header_section.jsp"%>
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
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Enter name" name="name">
				        </div>
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Enter email" name="email">
				        </div>
				        <button type="button" class="btn btn-primary" id="bt_regist">가입</button>
				        
				    </form>
    			
    			</div>
    		</div>
    	</div>
    </section>
    
    
    
    
    
	<!-- Instagram Begin -->
	<%@ include file="/inc/insta.jsp" %>
	<!-- Instagram End -->
	
	<!-- Footer Section Begin -->
	<%@ include file="/inc/footer.jsp" %>
	<!-- Footer Section End -->
	
	<!-- Search Begin -->
	<%@ include file="/inc/search.jsp" %>
	<!-- Search End -->

<!-- Js Plugins -->
<%@ include file="/inc/footer_link.jsp" %>
<script type="text/javascript">
function regist(){
	$("#form1").attr({
		action:"/member/join.jsp",
		method:"post"
	});	
	$("#form1").submit();
}

$(function(){
	$("#bt_regist").click(function(){
		regist();	
	});
});
</script>
</body>

</html>





