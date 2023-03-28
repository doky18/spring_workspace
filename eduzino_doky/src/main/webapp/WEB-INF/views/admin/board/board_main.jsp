<%@page import="com.edu.zino.domain.Adminboard"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
		List adminboardList=(List)request.getAttribute("adminboardList");
%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Plus Admin</title>
<!-- plugins:css -->
<jsp:include page="../inc/header_link.jsp"></jsp:include>
</head>
<body>
	<div class="container-scroller">
		<!-- partial:partials/_sidebar.html -->
		<jsp:include page="../inc/sidebar.jsp"></jsp:include>
		<!-- sidebar.html end  -->

		<!-- partial  -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<div id="settings-trigger">
				<i class="mdi mdi-settings"></i>
			</div>
			<div id="theme-settings" class="settings-panel">
				<i class="settings-close mdi mdi-close"></i>
				<p class="settings-heading">SIDEBAR SKINS</p>
				<div class="sidebar-bg-options selected" id="sidebar-default-theme">
					<div class="img-ss rounded-circle bg-light border mr-3"></div>
					Default
				</div>
				<div class="sidebar-bg-options" id="sidebar-dark-theme">
					<div class="img-ss rounded-circle bg-dark border mr-3"></div>
					Dark
				</div>
				<p class="settings-heading mt-2">HEADER SKINS</p>
				<div class="color-tiles mx-0 px-4">
					<div class="tiles default primary"></div>
					<div class="tiles success"></div>
					<div class="tiles warning"></div>
					<div class="tiles danger"></div>
					<div class="tiles info"></div>
					<div class="tiles dark"></div>
					<div class="tiles light"></div>
				</div>
			</div>
			<!-- partial -->
			<!-- partial:partials/_navbar.html -->
			<jsp:include page="../inc/navbar.jsp"></jsp:include>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper pb-0">
					<div class="page-header flex-wrap">
						<div class="header-reght"></div>
						<button type="button" class="btn btn-outline-success"
							id="bt_regist">글쓰기 등록</button>
					</div>

					<!-- table row starts here -->
				
					<div class="container">
						<div class="row md-3">
							<div class="col mt-3">
							
								<form id="form1" >
									<div class="form-group">
									<h1>공지사항 관리</h1>
									
									</div>
									
									<div class="from-group">
										<select name=" ">
											<option value="0">선택을 하세요...</option>
											<option value="1">모두</option>
											<option value="2">강사</option>
											<option value="3">유저</option>
										</select>
									
									</div>
									<div class="form-group">		
									<table class="table table-bordered table-sm">
										<thead>
											<tr>
												<th>No</th>
												<th>제목</th>
												<th>필독여부</th>
												<th>누구에게</th>
												<th>작성일</th>
												<th>관리</th>
											</tr>
										</thead>
										<tbody>
										<% for(int i=0; i<adminboardList.size();i++) {%>
										<% Adminboard adminboard=(Adminboard)adminboardList.get(i); %>
											<tr>
												<td><%=i %></td>
												<td><a href="/admin/board/detail?adminboard_idx=<%=adminboard.getAdminboard_idx()%>"><%=adminboard.getAdminboard_title() %></a></td>
												<td><%=adminboard.getAdminboard_sort()%></td>
												<td><%=adminboard.getTarget().getUserType()%></td>
												<td><%=adminboard.getAdminboard_regdate() %></td>
												<td>
													<button type="button" class="btn btn-outline-secondary" id="bt_look"><a href="/admin/board/detail?adminboard_idx=<%=adminboard.getAdminboard_idx() %>">보기</a></button>
													<button type="button" class="btn btn-outline-info" id="bt_edit"><a href="/admin/board/editform?adminboard_idx=<%=adminboard.getAdminboard_idx()%>">수정</a></button>
													<button type="button" class="btn btn-outline-danger" id="bt_del"><a href="/admin/board/delform?adminboard_idx=<%=adminboard.getAdminboard_idx()%>">삭제</a></button>
												</td>
											</tr>
												<%} %>

										</tbody>
									</table>
									</div>

								</form>
							</div>
						</div>


					</div>

					<!-- content-wrapper ends -->
					<!-- partial:partials/_footer.html -->
					<jsp:include page="../inc/footer.jsp"></jsp:include>
					<!-- partial:partials/_footer.html end -->
					<!-- partial -->
				</div>
				<!-- main-panel ends -->
			</div>
			<!-- partial end  -->
			<!-- page-body-wrapper ends -->
		</div>
		<!-- container-scroller -->
		<!-- plugins:js -->
		<jsp:include page="../inc/footer_link.jsp"></jsp:include>
		<!-- plugins:js end -->
		<!-- End custom js for this page -->
	</div>
	<script type="text/javascript">
	
		function regist(){
			$("#form1").attr({
				action: "/admin/board/registform",
				method: "GET"
			});
			$("#form1").submit();
		}
		$(function() {
			$("#bt_regist").click(function() {
				regist();
			});
			$("#bt_edit").click(function(){
				location.href="/admin/board/editform";
			});
		});
		
	</script>
</body>

</html>