<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>Admin-blacklist</title>
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
          
	<!-- *********************상단 버튼들************************** -->
      <div class="page-header flex-wrap">
        <div class="header-left">
        <button type="button" class="btn btn-outline-danger btn-icon-text">
                            <i class="mdi mdi-download btn-icon-sm"></i> Download </button>
       <button type="button" class="btn btn-outline-primary btn-icon-text">
                            <i class="mdi mdi-email-variant btn-icon-prepend"></i> Send Mail </button>
        </div>
        <div class="header-right d-flex flex-wrap mt-2 mt-sm-0">
          <button type="button" class="btn btn-primary mt-2 mt-sm-0 btn-icon-text">
            <i class="mdi mdi-circle"></i> Add Prodcut </button>
        </div>
      </div>
	<!-- *********************상단 버튼들************************** -->
            
	<!-- **********************회원 테이블************************** -->
	
	<div class="card-body">
		<h4 class="card-title">Striped Table</h4>
		<div class="table-responsive">
			<table class="table table-striped">
	<!-- - - - - - - - - -컬럼명 - - - - - - - - - - - -->	
				<thead>
					<tr>
						<th>회원</th>
						<th>닉네임</th>
						<th>메일</th>
						<th>정지사유</th>
						<th>정지일</th>
					</tr>
				</thead>
	<!-- - - - -디비에 저장된 회원들이 출력 될 곳 - - - - - - -->			
				<tbody>
					<tr>
						<td class="py-1">
							<img src="../../assets/images/faces-clipart/pic-1.png" alt="image">
						</td>
						<td><a href="/admin/member/blackdetail"> Herman Beck</a></td>
						<td>doky@eduzino.com</td>
						<td>비방, 욕설</td>
						<td> 23-03-23</td>
					</tr>						
				</tbody>
			</table>
		</div>
	</div>
	
	
	<!-- **********************회원 테이블************************** -->

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

</html>