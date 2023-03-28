<%@page import="com.edu.zino.domain.Subject"%>
<%@page import="com.edu.zino.domain.OrderSummary"%>
<%@page import="com.edu.zino.domain.OrderDetail"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<OrderSummary> orderSummaryList = (List)request.getAttribute("orderSummaryList");
	List<Subject> subjectList = (List)request.getAttribute("subjectList");
%>
<%
	OrderSummary orderSummary = null;
	OrderDetail orderDetail = null;
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
			<!-- partial -->
			<!-- partial:partials/_navbar.html -->/'
			<jsp:include page="../inc/navbar.jsp"></jsp:include>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper pb-0">
				
				<form class="d-flex align-items-center" id="form1">
				<!-- 검색창 -->
				<select class="form-control form-control-sm my-3" style="margin-right: 20px; width: 40%" name="subject_idx" id="subject_idx">
	                <option value="0">나의 강의 목록을 선택해 주세요</option>

                    <% for(int i=0;i<subjectList.size();i++){ %>
                    <% Subject subject = subjectList.get(i); %>
	                <option value="<%= subject.getSubject_idx() %>"><%= subject.getSubject_title() %></option>
					<% } %>

	           	</select>
              <div class="input-group width: 40%;">
                <input type="text" class="form-control border-0" placeholder="이름을 입력해주세요" name="member_nickname">
                <div class="input-group-prepend" id="bt_search">
                  <i class="input-group-text border-0 mdi mdi-magnify"></i>
                </div>
              </div>
            </form>
            
            
            <!-- 수강생테이블 -->
            <div class="card-body">
            <h4 class="card-title">수강생 관리</h4>
                    <div class="table-responsive">
                      <table class="table">
                        <thead class="thead-light">
                          <tr>
                            <th>이름</th>
                            <th>강의</th>
                            <th>메세지</th>
                            <th>차단여부</th>
                          </tr>
                        </thead>
                        <tbody>
                        	<% for(int i=0;i<orderSummaryList.size();i++){ %>
                        	<%
                        		orderSummary = orderSummaryList.get(i);
                        	%>
                          <tr>
                            <td><%= orderSummary.getMember().getMember_nickname() %></td>
                            <td>
                            <% for(int a=0;a<orderSummary.getOrderDetailList().size();a++){ %>
                            <% orderDetail = orderSummary.getOrderDetailList().get(a); %>
                            <%= orderDetail.getSubject().getSubject_title() %> / 
                            <% } %>
                            </td>
                            <td>
                            	<button type="button" class="btn btn-outline-warning" id="bt_messege" >메세지</button>
                            </td>
                            <td>
                              	<button type="button" class="btn btn-outline-danger" id="bt_onOff">차단</button>
                            </td>
                          </tr>
                          <% } %>
                        </tbody>
                      </table>
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
</body>

<script type="text/javascript">
	
	function search() {
		$("#form1").attr({
			action:"/teacher/student/studentManagement",
			method:"post"
		});
		$("#form1").submit();
	}
  	
	$(function(){
		
		$("#bt_search").click(function(){
			//이름조회
			//alert($("#t_search").val());
			search();
		});
		
		
		$("#bt_message").click(function(){
			
		});

		$("#bt_onOff").click(function(){
			if($(this).html() == "차단"){
				$(this).html("해제");
			}else if($(this).html() == "해제"){
				$(this).html("차단");
			}
		});
		
	});  	
</script>

</html>