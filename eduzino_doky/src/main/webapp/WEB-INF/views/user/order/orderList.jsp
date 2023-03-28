<%@page import="com.edu.zino.util.PageManager"%>
<%@page import="com.edu.zino.domain.OrderSummary"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<OrderSummary> orderList = (List)request.getAttribute("orderList");
	PageManager pm = new PageManager();
%>
<%
	pm.init(orderList,request);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Order Summary</title>
<style type="text/css">
 .pagination{
 	position:absolute;
 }
 .page-link{
 	background-color:rgb(60 181 49);
 }
 
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- header_link -->
<jsp:include page="../inc/header_link.jsp"></jsp:include>
<!-- header_link end -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
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
			<div class="col-md-9">
			<div class="card mt-5">
                  <div class="card-body">
                    <h4 class="card-title">결제내역</h4>
                    
                    <div class="table-responsive">
                      <table class="table table-hover">
                        <thead>
                          <tr>
                            <th>순번</th>
                            <th>주문번호</th>
                            <th>강좌명</th>
                            <th>결제일</th>
                            <th>수강료</th>
                            <th>결제방식</th>
                            <th>결제상태</th>
                          </tr>
                        </thead>
                        <tbody>
                        	<%
                        		int curPos = pm.getCurPos();
                        		int num = pm.getNum();
                        	%>
                        	
                        	<%for(int i=0; i<orderList.size(); i++){ %>
                        	<%if(num<1) break; %>                    
                        	<%OrderSummary order = orderList.get(i); %>
							<tr>
                            <td><%=num-- %></td>
                            <td>2023019001741</td>
                            <td><%=order.getOrderDetailList().get(i).getSubject().getSubject_title()%></td>
                            <td>2023-03-19</td>
                            <td><%=order.getTotal_buy() %></td>
                            <td><%=order.getPayment().getPayment_type()%></td>
                            <td><%=order.getPaystate().getState()%></td>
                          </tr>
                          <%} %>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
                  	<div class="btn-group" role="group" aria-label="Basic example" >
                           <div class="dataTables_paginate paging_simple_numbers" style="float:center" id="example2_paginate"><ul class="pagination">
                          <li class="paginate_button page-item previous disabled" id="example2_previous"><a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">Previous</a></li>
                          <li class="paginate_button page-item active"><a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">1</a></li>
                          <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0" class="page-link">2</a></li>
                          <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0" class="page-link">3</a></li>
                          <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0" class="page-link">4</a></li>
                          <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0" class="page-link">5</a></li>
                          <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0" class="page-link">6</a></li>
                          <li class="paginate_button page-item next" id="example2_next"><a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0" class="page-link">Next</a></li></ul></div>
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
<script type="text/javascript">


</script>
</html>