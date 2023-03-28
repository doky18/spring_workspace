<%@ page contentType="text/html;charset=UTF-8"%>
</style>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Hello World</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- header_link -->
	<jsp:include page="./user/inc/header_link.jsp"></jsp:include>
	<!-- header_link end -->
</head>
<body>
	<!-- hero-content -->
    <div class="hero-content">
    	<!-- header-->
		<jsp:include page="./user/inc/index/header.jsp"></jsp:include>
		<!-- header end -->
		
		<jsp:include page="./user/inc/index/hero_body.jsp"></jsp:include>
    </div>
    <!-- hero-content end-->
	
	<!-- icon_box -->
    <jsp:include page="./user/inc/index/icon_box.jsp"></jsp:include>
   	<!-- icon_box end -->
   	
	<!-- featured_courses -->   	
    <jsp:include page="./user/inc/index/featured_courses.jsp"></jsp:include>   
	<!-- featured_courses end -->  
	
    <!-- about-section -->
    <jsp:include page="./user/inc/index/about.jsp"></jsp:include>
    <!-- about-section end -->
    
    <!-- comment section -->
	<jsp:include page="./user/inc/index/comment.jsp"></jsp:include>
   <!-- comment section end -->
   
   <!-- courses -->
	<jsp:include page="./user/inc/index/courses.jsp"></jsp:include>
    <!-- courses end -->
    
    <!-- news_events -->
	<jsp:include page="./user/inc/index/news_events.jsp"></jsp:include>
	<!-- news_events end-->
	
<!-- clients_logo -->
    <jsp:include page="./user/inc/clients_logo.jsp"></jsp:include>
    <!-- clients_logo end -->
    
	<!-- footer -->
	<jsp:include page="./user/inc/footer.jsp"></jsp:include>
	<!-- footer -->
	<!-- footer_link -->
	<jsp:include page="./user/inc/footer_link.jsp"></jsp:include>
	<!-- footer_link end-->

</body>
</html>