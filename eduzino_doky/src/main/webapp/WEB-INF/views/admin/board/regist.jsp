<%@ page contentType="text/html;charset=UTF-8"%>
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

					</div>

					<!-- table row starts here -->
					<div class="container" role="main">

						<h2>게시판 글 등록</h2>

						<form id="form1">

							<div class="mb-3">

								<label>제목</label> <input type="text" class="form-control"
									name="adminboard_title" placeholder="제목을 입력해 주세요">

							</div>

							<div class="mb-3">

								<p>필독 여부</p>
								<lable> <input type="radio" name="adminboard_sort" value="0">공지</lable>
								<lable> <input type="radio" name="adminboard_sort" value="1">필독</lable>

							</div>
							
								<div class="mb-3">

								<p>누구에게</p>
								<lable> <input type="radio" name="target.target_idx" value="1">모두</lable>
								<lable> <input type="radio" name="target.target_idx" value="2">강사</lable>
								<lable> <input type="radio" name="target.target_idx"  value="3">유저</lable>

							</div>

							<div class="mb-3">

								<labe>내용</label> <textarea class="form-control" rows="5"
									name="adminboard_content" placeholder="내용을 입력해 주세요"></textarea>
							</div>

						</form>

						<div>

							<button type="button" class="btn btn-sm btn-primary" id="bt_regist">등록</button>

							<button type="button" class="btn btn-sm btn-primary" id="bt_list">목록</button>

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
	
		//동기방식으로
		function regist(){
			$("#form1").attr({
				action: "/admin/board/regist",
				method: "POST"
			})	;
			
			$("#form1").submit();
		};
		
		$(function(){
			//등록
			$("#bt_regist").click(function(){
				regist();
			});
			
			//목록
			$("#bt_list").click(function(){
				location.href="/admin/board/list";
			});
		})	;
	
	</script>
</body>

</html>