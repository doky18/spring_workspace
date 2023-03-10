<%@page import="com.edu.mvc3.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List boardList=(List)request.getAttribute("boardList");
	out.print("게시물 수는 "+boardList.size());

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap 1 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- jquery 2 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<!-- vue -->
<script src="https://cdn.jsdelivr.net/npm/vue@2.7.14/dist/vue.js"></script>

<script type="text/javascript">
	$(function () {
		$("#bt_regist").click(function(){
			alert("등록합니다?");
			location.href="/board/registform";	
		});
	});
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>No</th>
							<th>제목</th>
							<th>작성자</th>
							<th>내용</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<%for(int i=0; i<boardList.size();i++){ %>
						<%Board board=(Board)boardList.get(i); %>
						<tr>
							<td><%=i %></td>
							<td><a href="/board/detail?board_idx=<%=board.getBoard_idx()%>"><%=board.getTitle() %></a></td>
							<td><%=board.getWriter() %></td>
							<td><%=board.getContent() %></td>
							<td><%=board.getRegdate() %></td>
						</tr>
						<%} %>
						<tr>
							<td colspan="5">
								<button type="button" class="btn btn-danger" id="bt_regist">등록</button>								
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>