<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/vue@2.7.14/dist/vue.js"></script>

</head>
<body>
	<div class="container">
		<div class="row m-3">
			<div class="col-md-3 border">
				<form>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter ID" name="id">
					</div>		
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Pass" name="pass">
					</div>		
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Pass" name="name">
					</div>		
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Pass" name="email">
					</div>
							
					<div class="form-group text-center">
						<button type="button" class="btn btn-primary">등록</button>
					</div>		
				</form>		
			</div>
			<div class="col-md-6 border">
			
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>Firstname</th>
							<th>Lastname</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>John</td>
							<td>Doe</td>
							<td>john@example.com</td>
						</tr>
						<tr>
							<td>Mary</td>
							<td>Moe</td>
							<td>mary@example.com</td>
						</tr>
						<tr>
							<td>July</td>
							<td>Dooley</td>
							<td>july@example.com</td>
						</tr>
					</tbody>
				</table>
			
			</div>
			<div class="col-md-3 border">
				<form>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter ID" name="id">
					</div>		
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Pass" name="pass">
					</div>		
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Pass" name="name">
					</div>		
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Pass" name="email">
					</div>
							
					<div class="form-group text-center">
						<button type="button" class="btn btn-primary">수정</button>
						<button type="button" class="btn btn-primary">삭제</button>
					</div>		
				</form>		
			</div>
		</div>				
	</div>
</body>
</html>


