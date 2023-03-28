<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Plus Admin</title>
<!-- plugins:css -->
<jsp:include page="../inc/header_link.jsp"></jsp:include>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="/resources/teacher/subject/regist_style.css" />
</head>
  <body>
    <div class="container-scroller container" style="max-width: 1403px; overflow: initial;">
		<!-- partial:partials/_sidebar.html -->
		<jsp:include page="../inc/subject/sidebar.jsp"></jsp:include>
      <!-- sidebar.html end  -->
      
      <!-- partial  -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_navbar.html -->
        <jsp:include page="../inc/subject/navbar.jsp"></jsp:include>
        <!-- partial -->
        <div class="main-panel app--content--3vcMt" style="padding: 0px;">
           	<div class="sub-header--flex-align-center--1_RER sub-header--container--1pQeg">
           		<div class="sub-header--flex-align-center--1_RER sub-header--content--1H7YJ">
           			<h2 data-purpose="page-title" class="ud-heading-serif-xl">${studyPlanVO.getName()}</h2>
           		</div>
           	</div>
           	<div class="main-content--content--1Myl4">
           		<div class="goals--formgroup-box" id="app_goal">
           			<p class="goals-form--subtitle--3R5d-">
	       				<span>다음 설명은 강의 미리보기에서 공개되며 강의 성과에 직접적으로 영향을 미칩니다. 이러한 설명은 수강생이 강의가 자신에게 맞는지 여부를 판단할 수 있도록 돕습니다.</span>
	      			</p>
	      			<div>
	      				<div class="zino-subject-section-form-group">
	      					<div class="zino-subject-movie-form-head">
	      						<span class="zino-subject-movie-form-head-label">      						
		      						세션1:
	      						</span>
	      						<div class="zino-subject-movie-form-head-input">
		      						<i class="bi bi-file-earmark"></i>
		      						<span class="zino-subject-movie-form-head-value">소개</span>
	      						</div>
	      					</div>
	      					<div class="zino-subject-movie-form-body">
		      					<div class="zino-subject-movie-editor">
	      							<div class="zino-subject-movie-flex zino-subject-movie-title">
	      								<div class="zino-subject-movie-left-component">
	      									<span class="zino-subject-movie-form-body-label">강의1:</span>
			      							<div class="zino-subject-movie-form-head-input">
					      						<i class="bi bi-file-earmark"></i>
					      						<span class="zino-subject-movie-form-head-value">제목</span>
				      						</div>
				      						<div class="zino-subject-movie-editor-icon-box">
				      							<button class="zino-subject-movie-edit-icon">
						      						<i class="bi bi-pencil-fill"></i>
				      							</button>
				      							<button class="zino-subject-movie-edit-icon">
						      						<i class="bi bi-eraser-fill"></i>
				      							</button>
				      						</div>
			      						</div>
		      							<div class="zino-subject-movie-add-btn-box">
			      							<button class="zino-subject-movie-add-btn">강의선택</button>
			      						</div>
		      						</div>
		      						<div class="zino-subject-movie-select-form-group">
		      							<div class="zino-subject-movie-select-labal">
		      								<span class="zino-subject-movie-select-lable-text">영상목록</span>
		      							</div>
		      							영상 선택폼올곳
		      						</div>
		      					</div>
	      					</div>
	      				</div>
	      			</div>
           		</div>
				<div class="ud-form-btn-group">
					<button class="btn btn-primary mb-2 mb-md-0 mr-2 btn--form-grop-save float-right">저장하기</button>
				</div>
           	</div>
          <!-- content-wrapper ends -->
          <!-- partial -->
        </div>
        <div> 푸터올곳</div>
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
  </body>
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script type="text/javascript">
function init(){

}

$(function(){
	init();
});
</script>
</html>