<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>Admin-정지회원상세</title>
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
            <!-- partial -->
            <!-- partial:partials/_navbar.html -->
            <jsp:include page="../inc/navbar.jsp"></jsp:include>
            <!-- partial -->
            <div class="main-panel">
                <div class="content-wrapper pb-0">

                    <!-- *********************상단 버튼들 시작************************** -->
                    <div class="page-header flex-wrap">
                        <div class="header-left">
                            <button class="btn btn-primary mb-2 mb-md-0 mr-2"> Mail </button>
                            <button class="btn btn-outline-primary bg-white mb-2 mb-md-0"> Excel </button>
                        </div>
                        <div class="header-right d-flex flex-wrap mt-2 mt-sm-0">
                            <button type="button" class="btn btn-primary mt-2 mt-sm-0 btn-icon-text">
                                <i class="mdi mdi-circle"></i> Add Prodcut </button>
                        </div>
                    </div>
                    <!-- *********************상단 버튼들 끝************************** -->

                    <!-- *********************회원 정보 시작************************** -->
                    <h3 class="card-title mb-5">정지회원 상세정보</h3>
                    <div class="row">
                        <!-- *** 프로필 사진 *** -->
                        <div class="col-md-3">
                            <div style="width:200px">
                                <img class="card-img-center" src="/resources/admin/data/profile1.png"
                                    alt="Card image" style="width:100%">
                            </div>
                        </div>
                        <!-- *** 상세정보 *** -->
                        <div class="col-md-9">
                        	<form id="form1">
	                            <div class="card">
	                                <div class="card-body">
	                                    <form class="forms-sample">
	                                        <div class="form-group row">
	                                            <label class="col-sm-2 col-form-label">닉네임</label>
	                                            <div class="col-sm-7">
	                                                <input type="text" class="form-control" id="nickname" placeholder="nickname">
	                                            </div>
	                                        </div>
	                                        <div class="form-group row">
	                                            <label class="col-sm-2 col-form-label">이메일</label>
	                                            <div class="col-sm-7">
	                                                <input type="email" class="form-control" id="email" placeholder="Email">
	                                            </div>
	                                        </div>
	                                        <div class="form-group row">
	                                            <label class="col-sm-2 col-form-label">회원상태 </label>
	                                            <div class="col-sm-7">
	                                                <input type="text" class="form-control" id="age" placeholder="수강생 / 강사">
	                                            </div>
	                                        </div>
	                                        <div class="form-group row">
	                                            <label class="col-sm-2 col-form-label">정지일</label>
	                                            <div class="col-sm-7">
	                                                <input type="text" class="form-control" id="regdate" placeholder="Regdate">
	                                            </div>
	                                        </div>
	
	            <!-- * * * * * * * * * * * * * * * * * * * * * * * *  -->
	                                        <div class="form-group row">
	                                            <label class="col-sm-2 col-form-label">정지사유</label>
	                                            <div class="col-sm-7">
	                                               <textarea class="form-control" id="exampleTextarea1" rows="4"></textarea>
	                                            </div>
	                                            <div class="col-sm-3">
	                                                <button type="button" class="btn btn-outline-danger btn-icon-text" data-toggle="modal" data-target="#blackModal">
	                                                	<i class="mdi mdi-lead-pencil"></i> 수정하기 </button>
	                                                <!-- The Modal -->
	                                                <div class="modal fade" id="blackModal">
														<div class="modal-dialog modal-dialog-centered">
															<div class="modal-content">
	
	                                                            <!-- Modal Header -->
	                                                            <div class="modal-header">
	                                                                <h4 class="modal-title">회원 계정 정지</h4>
	                                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
	                                                            </div>
	
	                                                            <!-- Modal body -->
	                                                            <div class="modal-body">
																	<div class="form-group row">
																	    <label for="exampleInputConfirmPassword2" class="col-sm-3 col-form-label"> 정지 사유:</label>
																	    <div class="col-sm-9">
																	    	<textarea class="form-control" id="exampleTextarea1" rows="4"></textarea>
																	    </div>
																	</div>																
	                                                            </div>
	
	                                                            <!-- Modal footer -->
	                                                            <div class="modal-footer">
		                                                            <button type="button" class="btn btn-secondary" id="bt_edit"> 저장하기</button>
	                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal"> 나가기 </button>
	                                                            </div>
	
	                                                        </div>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </div>
	                                        <button type="button" class="btn btn-primary mr-2" id="bt_delblack"> 정지해제 </button>
	                                        <button type="button" class="btn btn-light" id="bt_list">목록으로</button>
	                                    </form>
	                                </div>
	                            </div>
                            </form>
                        </div>
                    </div>

                    <!-- 회원 테이블 -->
                    <!-- **********************회원 정보 끝************************** -->

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
</body>

<script type="text/javascript">

$(function(){
	//정지 사유 수정하기
	 $("#bt_edit").click(function(){
		 if(confirm("사유를 수정하시겠어요?")){
			$("#form1").attr({
				// action:"/admin/member/{blacklist_idx}",
				 method:"delete"		
			 });
			 $("#form1").submit();	
		}	
	 });
	 
	//정지 해제하기
	 $("#bt_delblack").click(function() {
			if(confirm("정지 상태를 해제하시겠어요?")){
				$("#form1").attr({
					// action:"/admin/member/{blacklist_idx}",
					 method:"delete"		
				 });
				 $("#form1").submit();	
			}
		});
	 
	//정지회원 목록으로 
	 $("#bt_list").click(function(){
			location.href="/admin/member/blacklist";
	});
});



</script>
</html>