<%@page import="com.edu.mvc3.domain.Board"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
		Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script type="text/javascript">
 $(function(){
	 $("#bt_regist").click(function(){
		 $("#form1").attr({
			 action:"/board/regist",
			 method:"post"
		 });
		 $("#form1").submit();	
	 });
	 
	 $("#bt_edit").click(function() {
			if(confirm("수정하시겠어요?")){
				$("#form1").attr({
					 action:"/board/edit",
					 method:"post"		
				 });
				 $("#form1").submit();	
			}
		})
	 
	 $("#bt_del").click(function() {
		if(confirm("삭제하시겠어요?")){
			$("#form1").attr({
				 action:"/board/delete",
				 method:"post"		
			 });
			 $("#form1").submit();	
		}
	})
	 //아래에 input 타입 히든으로 줘야함 -> deleteController 작성 -> beanname.xml에서 엮어주기
 });

</script>
</head>
<body>
	<div id="container">
		<div class="row">
			<div class="col">
				<form id="form1">
					<input type="hidden" name="board_idx" value="<%=board.getBoard_idx()%>">
					  <div class="form-group">
					    <input type="text" class="form-control" value=<%=board.getTitle() %> placeholder="Enter title" id="id" name="title">
					  </div>
					  <div class="form-group">
					    <input type="text" class="form-control" value=<%=board.getWriter() %> placeholder="Enter name" id="writer" name="writer">
					  </div>
					  <div class="form-group">
						<textarea class="form-control" name="content"><%=board.getContent() %></textarea>
					</div>
					<div class="form-group">
					  <button type="submit" class="btn btn-danger" id="bt_regist">등록</button>
					  <button type="submit" class="btn btn-danger" id="bt_del">삭제</button>
					  <button type="submit" class="btn btn-danger" id="bt_edit">수정</button>
					 </div>
					</form>
			</div>
		</div>
	</div>
</body>
</html>