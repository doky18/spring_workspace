<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>내 계정</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- header_link -->
	<jsp:include page="../inc/header_link.jsp"></jsp:include>
	<!-- header_link end -->

</head>
<body>
	<!-- hero-content -->
    <div class="page-header">
    	<!-- header-->
		<jsp:include page="../inc/page/header.jsp"></jsp:include>
		<!-- header end -->
    	<jsp:include page="../inc/page/header_main.jsp"></jsp:include>
    </div>
    <!-- hero-content end-->
	
	
	
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<!-- partial:partials/_sidebar.html -->
				<jsp:include page="../inc/mypage/sidebar.jsp"></jsp:include>
				 <!-- sidebar.html end  -->
			</div>
			<div class="col-md-9 mt-5">
			
			
			<div class="card">
            <div class="card-body">
                <form class="forms-sample">
                    <div class="form-group row">
                        <div class="profile_photo">
							<img id="imgThumb" src="https://phinf.pstatic.net/contact/20210427_157/1619532053625FKw67_JPEG/DSC01453.JPG?type=s160" width="200" height="200">
							<span class="mask"></span>
                        </div>
			            <div class="form-group">
			                <label>File upload</label>
			                <input type="file" name="img[]" class="file-upload-default">
			                <div class="input-group col-xs-6">
			                    <input type="text" class="form-control file-upload-info" disabled="" placeholder="선택된 사진 ">
			                    <span class="input-group-append">
			                        <button class="file-upload-browse btn btn-primary" type="button"> Upload </button>
			                    </span>
			                </div>
			            </div>
                    </div>
                    
                    
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">닉네임</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="nickname" placeholder="nickname">
                        </div>
                    </div>
                    
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">연령 </label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="age" placeholder="Age">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">가입일</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="regdate" placeholder="Regdate">
                        </div>
                    </div>
<!-- * * * * * * * * * * * * * * * * * * * * * * * *  -->
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">회원상태</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="status" placeholder="회원상태">
                        </div>
                    </div>
<!-- * * * * * * * * * * * * * * * * * * * * * * * *  -->
                   
                    <div class="flex-wrap">
                    	<div class="header-left">
                    		<button type="submit" class="btn btn-primary mr-2"> 수정하기 </button>
                    	</div>
                    	 <div class="right d-flex flex-wrap mt-2 mt-sm-0">
			        		<button type="submit" class="btn btn-light">탈퇴하기 </button>
			        	</div>
			        </div>
                </form>
            </div>
        </div>
			    
			    
			</div>
		</div>	
	</div>
   
	
	<!-- clients_logo -->
    <jsp:include page="../inc/clients_logo.jsp"></jsp:include>
    <!-- clients_logo end -->
    
	<!-- footer -->
	<jsp:include page="../inc/footer.jsp"></jsp:include>
	<!-- footer -->
	<!-- footer_link -->
	<jsp:include page="../inc/footer_link.jsp"></jsp:include>
	<!-- footer_link end-->

</body>
</html>