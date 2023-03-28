<%@page import="java.util.List"%>
<%@page import="com.edu.zino.domain.Wish"%>
<%@page import="com.edu.zino.domain.Subject"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List wishList = (List)request.getAttribute("wishList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>WishList</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- header_link -->
<jsp:include page="../inc/header_link.jsp"></jsp:include>
<!-- development version, includes helpful console warnings -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<!-- header_link end -->
<style type="text/css">
.eduzino-box-line{
	display: inline;
	margin: 0px 5px;
}
.subejct-item-checkbox input[type='checkbox'], .check_wrap input[type='checkbox']{
	zoom:1.5;
    width: 15px;
    height: 15px;
}
</style>
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
			<div class="col-md-9" style="overflow: hidden;">
				<div class="card mt-5">
					<div class="card-body">
						<h4 class="card-title" style="margin-left:12px">Wish List</h4>
						<div class="table-responsive">
							<div class="col">
								<div class="check_wrap">
									<input type="checkbox" id="checkAll" name="checkAll" /> <span style="font-size:20px">전체 선택</span>
								</div>
									<form id="form1">
										<div  id="app_wish">										
										<template v-for="wish in wishList">
											<wish_table :key="wish.wish_idx" :wish="wish"/>
										</template>
										
								</form>
							</div>
						</div>
					</div>
					
				</div>
				<div class="row" style="float: right; margin: 10px 0px 5px 10px">
					<button type="button" class="btn btn-success btn-md" style="margin-right:10px" id="bt_del">선택항목 삭제</button>
	                 <button type="button" class="btn btn-success btn-md" id="bt_cart"> 장바구니로 이동</button>
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
<script type="text/javascript">
let wishApp;

	const wish_table={
		template:`
			<div  class="row">
				<div class="course-content flex flex-wrap justify-content-between align-content-lg-stretch">
				<div class="eduzino-box-line subejct-item-checkbox">
				  <input type="hidden" name="hidden_wish_idx"  :value="item.wish_idx">
				  <input type="checkbox" name="wish_idx" :value="item.subject.subject_idx" />
				</div>
				<div class="eduzino-box-line">
					<figure class="course-thumbnail" style="width: 200px; height: 220px;">
						<a href="#"><img src="/resources/shop/img/shop-cart/cp-1.jpg" alt=""></a>
					</figure>
				</div>
				<!-- .course-thumbnail -->
				<div class="course-content-wrap eduzino-box-line" style="width:500px; height: 220px;">
					<header class="entry-header">
						<h2 class="entry-title"><a href="#">{{item.subject.subject_title}}</a></h2>
						<span>부제목</span>
						<div class="entry-meta flex flex-wrap align-items-center">
							<div class="course-author">
								<a href="#">강사명</a>
							</div>
						</div>
						<!-- .course-date -->
					</header>
					<!-- .entry-header -->
					<footer class="entry-footer flex justify-content-between align-items-center">
						{{item.subject.subject_price}}
						<!-- .course-cost -->
					</footer>
					<!-- .entry-footer -->
					</div>
				<!-- .course-content-wrap -->
				</div>
			<!-- .course-content -->
			</div>
		`	,props:['wish']
			,data(){
			return{
				item:this.wish
			};
		}	
	}

	wishApp=new Vue({
		el:"#app_wish",
		components:{
			wish_table
		},
		data:{
			wishList:[],
			count:5
		}
	});
	
	
	
	//시작하자마자 목록을 가져온다
	function getWishList(){
		$.ajax({
			url:"/rest/cart/wishlist",
			type:"get",
			success:function(result,status,xhr){
				console.log("result",result);
				wishApp.wishList = result;
				//console.log("위시앱",wishApp);
			}
		});
	}


/*-------------------------------*/
	let data=$("input[name=wish_idx]:checked").val();
	
	function test(){
		let checkLng2=$("input[name='wish_idx']:checked").length;
		let arr2=[];
		let checkval2;
		
		for(let i=0;i<checkLng2;i++){
			if($("input[name=wish_idx]").is(':checked')){
				checkval2=$($("input[name='hidden_idx']")[i]).val();
				console.log("checkval",checkval2);
			}
		}
	}
	
	//선택 찜 비동기로 삭제
	function delAsyncWish(){
	let checkLng=$("input[name='wish_idx']:checked").length;
	let arr=[];
	let checkval;
	
	for(let i=0;i<checkLng;i++){
		if($("input[name=wish_idx]").is(':checked')){
			checkval=$($("input[name='hidden_wish_idx']")[i]).val();
			console.log("checkval",checkval);
		}
		let json={};
		console.log("checkval",checkval);
		json["wish_idx"]=checkval;
		arr.push(json);
	}
	
	console.log("arr is ", JSON.stringify(arr));
	if($("input[name=wish_idx]").is(':checked')){
		if(!confirm("찜에서 삭제하시겠습니까?")){
			return;
		}else{
			$.ajax({
				url:"/rest/cart/wish_list",
				type:"DELETE",
				contentType:"application/json",
				data: JSON.stringify(arr),
				success:function(result, status, xhr){
					console.log("삭제 완료");
					getWishList();
				}
			});
		}
	}
}


	//찜내역 카트에 추가하기
	function insertCart(){
		//체크된 개수
		let checkLng2=$("input[name='wish_idx']:checked").length;
		let arr2=[];
		let checkval; //여기에 wish_idx를 담고
		let checkval2; //여기에 subject_idx를 담을 것
		
		for(let i=0;i<checkLng2;i++){
			checkval = $($("input[name='hidden_wish_idx']")[i]).val(); //얘는 wish_idx임
			checkval2=$($("input[name='wish_idx']")[i]).val(); //얘는 subject_idx임
			console.log("checkval: wish_idx",checkval);
			console.log("checkval2: subject_idx",checkval2);
			
			let json={};
			let subject ={};
			//console.log("checkval2",checkval2);
			subject["subject_idx"]=checkval2;
			json["wish_idx"]=checkval;
			json["subject"]=subject;
			arr2.push(json);
		}
		
		console.log("arr2 is ", JSON.stringify(arr2));
		if($("input[name=wish_idx]").is(':checked')){
			if(!confirm("장바구니에 추가하시겠습니까?")){
				return;
			}else{
				$.ajax({
					url:"/rest/cart/wishTocart",
					type:"POST",
					contentType:"application/json",
					data: JSON.stringify(arr2),
					success:function(result, status, xhr){
						//if(confirm("장바구니로 이동하시겠습니까?")){
							//location.href="/cart/list";
						//}
						console.log(result);
					}
				});
			}
		}
		
	}

	//체크박스 전체 선택
	function allCheckBox(){
		if($("#checkAll").is(':checked')){
			$("input[name=wish_idx]").prop("checked", true);
		}else{
			$("input[name=wish_idx]").prop("checked", false);	
		}
	};
	
	//체크박스 개별 선택
	function CheckBox(){
		if($("input[name=wish_idx]:checked").length==$("input[name=wish_idx]").length){
			$("#checkAll").prop("checked", true);
		}	else{
			$("#checkAll").prop("checked", false);
		}
	}

	$(function(){
		getWishList();
		
		$("#bt_del").click(function(){
			delAsyncWish();
		});
		$("#bt_cart").click(function(){
			insertCart();
			//test();
		});
		
		$("#checkAll").click(function(){			
			allCheckBox();
		});
		$("input[name=wish_idx]").click(function(){
			CheckBox();
		});
	
	});

</script>
</html>