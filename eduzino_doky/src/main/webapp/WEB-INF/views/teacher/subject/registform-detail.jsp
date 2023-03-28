<%@page import="com.edu.zino.vo.StudyPlanVO"%>
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
<<<<<<< HEAD
           			<!--<p class="goals-form--subtitle--3R5d-">
	       				<span>
		       				 적을내용이있으면 적자 
	       				</span>
	      			</p>-->
=======
           			<p class="goals-form--subtitle--3R5d-">
	       				<span>
		       				강의 내용은 eduzino에서 성공을 거두는 데 있어 중요합니다. 이 섹션을 완료하면서 사람들이 강의를 왜 수강 신청하려는지 보여주는 호소력 있는 강의 미리보기 만들기에 대해 생각해 보세요. 
		       				강의 미리보기 만들기 및 강의 제목 표준에 대해 자세히 알아보세요.
	       				</span>
	      			</p>
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
	      			<div>
	      				<div class="ud-heading-md goals-form--question-label--1lkHx">강의 제목</div>
		      			<div class="form-group details-form--question-text-container--2ac22">
							<input type="text" class="form-control" placeholder="강의제목을 입력해주세요" maxlength="65">
<<<<<<< HEAD
							<div class="subject-form-note">제목은 이목을 집중시키고, 정보를 전달하며, 검색에 최적화되어야 합니다</div>
=======
							<div id="u60-form-group-note--129" class="ud-form-note ud-text-xs">제목은 이목을 집중시키고, 정보를 전달하며, 검색에 최적화되어야 합니다</div>
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
						</div>
	      			</div>
	      			<div>
	      				<div class="ud-heading-md goals-form--question-label--1lkHx">강의 부제</div>
		      			<div class="form-group details-form--question-text-container--2ac22">
							<input type="text" class="form-control" placeholder="강의 부제를 입력해주세요" >
<<<<<<< HEAD
							<div class="subject-form-note">강의의 중요 키워드와 간단한 설명을 언급해주세요</div>
=======
							<div id="u60-form-group-note--129" class="ud-form-note ud-text-xs">강의의 중요 키워드와 간단한 설명을 언급해주세요</div>
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
						</div>
	      			</div>
	      			
	      			<fieldset>
	      				<legend class="ud-form-label ud-heading-md">카테고리 선택</legend>
	      				<div class="zino-subject-selectbox-inline-field">
	      					<div class="course-basics-form--category-fields--1M1_V">
<<<<<<< HEAD
	      						<div class="form-group" id="category_app">
		      						<div class="ud-select-container ud-select-container-large">
										<select aria-invalid="false" name="top_category" class="zino-subject-select" @change="topCategoryChange($event)">
										<option value="0">TOP카테고리 선택</option>
										<template v-for="topCategory in topCategoryList">
											<category_item :key="topCategory.top_category_idx" :value="topCategory.top_category_idx" :name="topCategory.top_name"/>
										</template>
									</select>
										
									</div>
    								<div class="ud-select-container ud-select-container-large">
    									<select aria-invalid="false" name="mid_category" class="zino-subject-select" @change="midCategoryChange($event)">
											<option value="0">MID카테고리 선택</option>
			      							<template v-for="midCategory in midCategoryList">
												<category_item :key="midCategory.mid_category_idx" :value="midCategory.mid_category_idx" :name="midCategory.mid_name"/>
											</template>
										</select>
	    							</div>
    								<div class="ud-select-container ud-select-container-large">
	    								<select aria-invalid="false" name="sub_category" class="zino-subject-select">
												<option value="0">SUB카테고리 선택</option>
				      							<template v-for="subCategory in subCategoryList">
													<category_item :key="subCategory.sub_category_idx" :value="subCategory.sub_category_idx" :name="subCategory.sub_name"/>
												</template>
										</select>
=======
	      						<div class="form-group">
		      						<div class="ud-select-container ud-select-container-large">
		      							<select aria-invalid="false" name="top_category" class="zino-subject-select">
		      								<option value="0">TOP카테고리 선택</option>
		      								<option value="1">IT</option>
		      								<option value="2">디자인</option>
	      								</select>
	    							</div>
    								<div class="ud-select-container ud-select-container-large">
		      							<select aria-invalid="false" name="mid_category" class="zino-subject-select">
		      								<option value="0">MID카테고리 선택</option>
		      								<option value="1">프론트</option>
		      								<option value="2">백엔드</option>
	      								</select>
	    							</div>
    								<div class="ud-select-container ud-select-container-large">
		      							<select aria-invalid="false" name="top_category" class="zino-subject-select">
		      								<option value="0">SUB카테고리 선택</option>
		      								<option value="1">C</option>
		      								<option value="2">Java</option>
	      								</select>
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
	    							</div>
    							</div>
  							</div>
  						</div>
  					</fieldset>
  					
  					<div>
	      				<div class="ud-heading-md goals-form--question-label--1lkHx">강의 이미지</div>
		      			<div class="form-group details-form--question-text-container--2ac22" style="overflow: hidden;" >
		      				<div class="float-left">		      				
								<img alt="강의이미지" src="/resources/teacher/subject/img/selectImage.png" id="subject_detail_photo" width="400" height="250">
		      				</div>
							<div class="float-right details-form-img-text-container">
								<p style="display: inline;">
									<span>
										여기에 강의 이미지를 업로드하세요. 이미지가 수락되려면 강의 <br>이미지 품질 기준을 충족해야 합니다. <br>
										중요 가이드라인: 750x468 픽셀의 .jpg, .jpeg, .gif, 또는 .png. 이미지에 텍스트가 포함되지 않아야 함.
									</span>
								</p>
							</div>
							<br>
							<input type="file" style="display: none;" name="subject_pic">
							<div id="detail-file-uploader-fake" style="display: flex;">
								<span class="file-uploader--fake-input">
									<span class="file-uploader--fake-input-text" id="file-upload-fake-filename">선택된 파일 없음</span>
								</span>
								<span class="file-btn-secondary">
									<span>파일 업로드</span>
								</span>
							</div>
						</div>
	      			</div>
	      			
	      			
	      			<div>
	      				<div class="ud-heading-md goals-form--question-label--1lkHx">강의 설명</div>
		      			<div class="form-group details-form--question-text-container--2ac22">
							<div id="summernote"></div>
						</div>
	      			</div>
	      			
           		</div>
				<div class="ud-form-group detail-form-btn-group">
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
<<<<<<< HEAD
<script src="/resources/root/categoryApp.js"></script>
<script type="text/javascript">
function prev(file){//미리보기 함수
=======
<script type="text/javascript">
function prev(file){
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
	let reader = new FileReader();
	reader.onload = function(e){
		$("#file-upload-fake-filename").html(file.name);
		$("#subject_detail_photo").attr({ src: e.target.result });
	}
	reader.readAsDataURL(file);
}
<<<<<<< HEAD
function getCategory(){//카테고리 가져오는 메서드
	$.ajax({
		url:"/rest/category",
		type:"get",
		success:function(result,status,xhr){
			console.log(result);
			categoryApp.topCategoryList = result;
		},error:function(xhr,status,error){
			console.log(xhr);
		}
	});
=======
function getTopCategory(){
	
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
}
function init(){
    $('#summernote').summernote({
      placeholder: '강의 설명을 적어주세요.',
      tabsize: 2,
      height: 200,
      lang : 'ko-KR',
      width: '48rem'
    });
<<<<<<< HEAD
    getCategory();
=======
    getTopCategory();
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
}
$(function(){
	init();
	$("#detail-file-uploader-fake").click(function(){
		$("input[name=subject_pic]").trigger('click');
	});
	$("input[name=subject_pic]").change(function(){
		prev(this.files[0]);
	});
});
</script>
</html>