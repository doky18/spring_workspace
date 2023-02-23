<%@page import="com.jspshop.domain.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.jspshop.repository.CategoryDAO"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%!CategoryDAO categoryDAO = new CategoryDAO();%>
<%
//카테고리 가져옥
List<Category> categoryList = categoryDAO.selectAll();
%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<%@ include file="/inc/header.jsp"%>
</head>

<body>
	<!-- Page Preloder -->
	<%@ include file="/inc/preloder.jsp"%>

	<!-- Offcanvas Menu Begin -->

	<%@ include file="/inc/main_navi.jsp"%>
	<!-- Offcanvas Menu End -->

	<!-- Header Section Begin -->
	<%@ include file="/inc/header_section.jsp"%>
	<!-- Header Section End -->

	<!-- Instagram Begin -->
	<%@ include file="/inc/insta.jsp"%>
	<!-- Instagram End -->

	<!-- Footer Section Begin -->
	<%@ include file="/inc/footer.jsp"%>
	<!-- Footer Section End -->

	<!-- Search Begin -->
	<%@ include file="/inc/search.jsp"%>
	<!-- Search End -->
	<%@ include file="/inc/footer_link.jsp"%>
	<!-- Js Plugins -->

</body>

</html>