<%@ page contentType="text/html;charset=UTF-8"%>
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
    <div class="page-header">
    	<!-- header-->
		<jsp:include page="./user/inc/page/header.jsp"></jsp:include>
		<!-- header end -->
    	<jsp:include page="./user/inc/page/header_main.jsp"></jsp:include>
    </div>
    <!-- hero-content end-->
	

	
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