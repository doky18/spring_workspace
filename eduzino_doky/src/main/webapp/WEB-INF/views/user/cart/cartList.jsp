<%@page import="com.edu.zino.domain.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.zino.domain.Cart"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List cartList = (List)request.getAttribute("cartList");

	int totalPrice=0;
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cart List</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- header_link -->
<jsp:include page="../inc/header_link.jsp"></jsp:include>
<link rel="stylesheet" href="/resources/shop/css/style_cart.css">
<script src="https://js.tosspayments.com/v1/payment"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />

<style>
	.modal{
 	position: relative;
	position: fixed;
	z-index: 300000;
	  top: 50%;
	  left: 50%;
	  transform: translate(-50%, -50%);
	}
	
	.pay_bt{
		font-size: 17px;
	    color: #ffffff;
	    background: rgb(60 181 49);
	    font-weight: 600;
	    border: none;
	    text-transform: uppercase;
	    display: inline-block;
	    padding: 10px 30px;
	    border-radius: 50px;
	    width: 100%;
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
 
		
	<section class="shop-cart spad">
        <div class="container" id="app_cart">
        <div class="row">
         	<div class="col-lg-4">
            	<div class="breadcrumb__links">
					<a href="#"><i class="fa fa-home"></i> Home</a>
					<span>수강 신청</span>
				</div>
			</div>
		</div>
			
			<span>&nbsp;</span>
            <div class="row">
            
				<!-- 결제 체크 modal -->
				  <!-- The Modal -->
				  <div class="modal fade" id="myModal">
				    <div class="modal-dialog modal-dialog-centered">
				      <div class="modal-content">
				      
				        <!-- Modal Header -->
				        <div class="modal-header">
				          <h4 class="modal-title">결제 내역 확인</h4>
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				        </div>
				        
				        <!-- Modal body -->
				        <div class="modal-body" >
				          	<table>				          	
					          	<tr>
									<td id="checkedTitle">
										
									</td>
								</tr>
								<tr>
									<td id="checkedLng">
									</td>
								</tr>
				          	</table>	
				        </div>
				        
				        <!-- Modal footer -->
				        <div class="modal-footer">
				          <button type="button" class="site-btn" data-dismiss="modal" id="bt_closeModal">Close</button>
				          <button type="button" class="site-btn" id="bt_pay">결제하기</button>
				        </div>
				      </div>
				    </div>
				  </div>
					<!-- 결제 체크 모달 끝 -->
					
                <div class="col-lg-12">
                    <div class="shop__cart__table">
                        <table>
                            <thead>
                                <tr>
                                	<th>
	                                 	<div class="check_wrap">
										  <input type="checkbox" id="checkAll" name="checkAll"/>
										 <span>select all</span>
										</div>
                                 	</td>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th></th>
                                </tr>
                            </thead>
                          	<tbody class="cart_form_box" id="app_orderCheck">>
                     	        <template v-for="cart in cartList">
                     	        	<cart_table :key="cart.cart_idx"  :cart="cart"/>
                     	        </template>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
           
            <div class="row" style="justify-content: flex-end;">
	             <div class="col-lg-6 offset-lg-2">
                    <div class="cart__total__procced">
                          <h4>포인트 사용</h4>                       
                            <ul>
                            <li>보유 포인트 <span>1,000</span></li>
                              </ul>
                            <div class="discount__content">
                        <form action="#">
                            <input type="text" placeholder="Enter your point">
                            <button type="submit" class="site-btn" style="right: -126px; ">전액 사용</button>
                        </form>
                    </div>
                    </div>
                </div>
                   <div class="col-lg-6 offset-lg-2">
                    <div class="cart__total__procced">
                        <h4>총 결제 금액</h4>
                        <ul>
                            <li>할인 금액 <span>1,000</span></li>
                            <li>결제 금액 <span><%=totalPrice %></span></li>
                        </ul>
                          <button class="pay_bt" style="color: white" id="bt_payCheck" data-toggle="modal" data-target="#myModal" >결제하기</button>
                    </div>
				</div>
            </div>
        </div>
    </section>
	
	
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
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script type="text/javascript">
/*---------장바구니 vue----------------*/
	let cartApp;
	
	
	
	const cart_table={
			template:`
			 <tr>
            	<td>
            	<div class="check_wrap">
            			<input type="hidden" name="hidden_cart_idx" :value="item.cart_idx">
					  	<input type="checkbox" name="cart_idx" :value="item.subject.subject_idx" class="col-2" />
						<span>select</span>
					</div>
            	</td>
                <td class="cart__product__item">
                    <img src="/resources/shop/img/shop-cart/cp-1.jpg" alt="">
                    <div class="cart__product__item__title"  name="subject_title" :value="item.subject.subject_title">
                        <h6>{{item.subject.subject_title}}</h6>
                        <span>{{item.subject.subject_subTitle}}</span>
                    </div>
                </td>
                <td class="cart__price">{{item.subject.subject_price}}</td>
                <td class="cart__close" ><span class="icon_close" @click="del(item.cart_idx)"></span></td>
            </tr>
			`, props:['cart']
			,data(){
				return{
					item:this.cart
				};
			},methods:{
				del:function(key){
					delAsyncCart(key);
				}
				,checkChange:function(event,item){
					console.log(event);
					console.log(item);
					if(event.srcElement.checked){
						
						let json = [];
						json['cart_idx']=item.cart_idx;
						json['subject']=item.subject;
						
						checkList.push(json);
					}
				}
			}
		
		}
	

	cartApp=new Vue({
		el:"#app_cart",
		components:{
			cart_table
		},
		data:{
			cartList:[],
			count:4
		}
		
	});
	
	function getCheckIndex(idx){
		let list = cartApp.cartList;
		for(let i=0; i<list.length; i++){
			if(list[i].cart_idx == idx) return i;
		}
		return -1;
	}
	
	
/*-------------------------메서드 영역-----------------------------------------------*/
	
	
	//시작하자마자 목록을 가져온다
	function getCartList(){
		$.ajax({
			url:"/rest/cart/list",
			type:"get",
			success:function(result,status,xhr){
				//console.log("result",result);
				cartApp.cartList = result;
			}
		});
	}
	
	//선택한 강좌명 가져오기
	function getOrderTitle(){
		let checkedBox=$("input[name='cart_idx']:checked");
		let checkTitle=[]; //선택한 강좌명을 저장할 배열
		let checkedList = [];//선택한 cart json정보를 담는 배열
		
		for(let i=0; i<checkedBox.length; i++){					
			let idx = getCheckIndex($(checkedBox[i]).val());
			checkedList.push(cartApp.cartList[idx]);
			checkTitle.push(cartApp.cartList[idx].subject.subject_title);
		}
		console.log(checkTitle);
		console.log(checkedList);
		let str = "";
		for(let i=0;i<checkTitle.length;i++){
			str+=checkTitle[i]+"<br>"
		}
		$("#checkedTitle").html(str);
		$("#checkedLng").html("총 "+checkTitle.length+"건 결제하시겠습니까?");
	}

		
	
	//선택한 강좌 결제창으로 넘기기
	function cartTopay(){
		let checkLng=$("input[name='cart_idx']:checked").length;
		let checkval; //여기에 cart_idx를 담고
		let checkval2; //여기에 subject_idx를 담을 것
		
		let arr=[];
		
		for(let i=0; i<checkLng; i++){
			checkval = $($("input[name='hidden_cart_idx']")[i]).val(); //얘는 cart_idx임
			checkval2=$($("input[name='cart_idx']")[i]).val(); //얘는 subject_idx임
		
			console.log("checkval: cart_idx",checkval);
			console.log("checkval2: subject_idx",checkval2);
			
			let json={};
			let subject={};
			subject["subject_idx"]=checkval2;
			
			json["cart_idx"]=checkval;
			json["subject"]=subject;
			arr.push(json);
			
		}
		
		console.log("arr is", JSON.stringify(arr));
		
		$.ajax({
			url:"/rest/pay/payment1",
			type:"POST",
			contentType:"application/json",
			data:JSON.stringify(arr),
			success:function(result,status,xhr){
				console.log("result is ",result);
			}, errer:function(xhr,status,err){
				
			}
		});
		
	}
	

	//선택 장바구니 비동기로 삭제
	function delAsyncCart(cart_idx){
		if(!confirm("선택하신 항목을 삭제하시겠습니까?")){
			return;
		}else{
			$.ajax({
				url:"/rest/cart/list/"+$("input[name='cart_idx']").val(),
				type:"DELETE",
				success:function(result,status,xhr){
					console.log(result);
					getCartList();
				},error:function(xhr, status, err){
					
				}
			});
		}
	}


	//체크박스 전체 선택
	function allCheckBox(){
		if($("#checkAll").is(':checked')){
			$("input[name=cart_idx]").prop("checked", true);
		}else{
			$("input[name=cart_idx]").prop("checked", false);	
		}
	};
	
	//체크박스 개별 선택
	function CheckBox(){
		if($("input[name=cart_idx]:checked").length==$("input[name=cart_idx]").length){
			$("#checkAll").prop("checked", true);
		}	else{
			$("#checkAll").prop("checked", false);
		}
	}
	
	/*-------------------*/
function showPayModal(){
		
	 var clientKey = 'test_ck_D5GePWvyJnrK0W0k6q8gLzN97Eoq'
    var tossPayments = TossPayments(clientKey) // 클라이언트 키로 초기화하기
  
    tossPayments.requestPayment('카드', { // 결제 수단 파라미터
    	  // 결제 정보 파라미터
    	  amount: 15000, //order_summary.totalbuy
    	  orderId: 'MNprnPRH0LEGq1CA837vT',  //이건 날짜+시간 조합으로 만들까봐
    	  orderName: '토스 티셔츠 외 2건', //order_detail.subject_idx
    	  customerName: '박토스', //member.member_nickname
    	  successUrl: 'http://localhost:7777/pay/payment1', //결제가 완료되었습니다>결제내역으로 이동
    	  failUrl: 'http://localhost:에러페이지', //결제가 실패했습니다.> 카트리스트로 이동
    	})
    	.catch(function (error) {
    	  if (error.code === 'USER_CANCEL') {
    	    // 결제 고객이 결제창을 닫았을 때 에러 처리
    	  } else if (error.code === 'INVALID_CARD_COMPANY') {
    	    // 유효하지 않은 카드 코드에 대한 에러 처리
    	  }
    	})
	
	}
	
	
	/*-------토스 api 여는 함수------------*/

	$(function(){
		getCartList();
		

		//모달에서 결제창 클릭
		$("#bt_pay").click(function(){
			showPayModal();
		});
		
		//모달 닫기 버튼
		$("#bt_closeModal").click(function(){
			//checkTitle 초기화
		});
	
		
		//결제버튼 클릭
		$("#bt_payCheck").click(function(){
			getOrderTitle();
		});

		//전체선택 클릭
		$("#checkAll").click(function(){			
			allCheckBox();
		});
		
		//개별 선택 클릭
		$("input[name=cart_idx]").click(function(){
			CheckBox();
		});
	
	});

	

</script>
</html>