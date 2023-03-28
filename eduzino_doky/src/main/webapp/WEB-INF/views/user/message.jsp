<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Chat-Message</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- header_link -->
	<jsp:include page="./inc/header_link.jsp"></jsp:include>
	<!-- header_link end -->

</head>
<body>
	<!-- hero-content -->
    <div class="page-header">
    	<!-- header-->
		<jsp:include page="./inc/page/header.jsp"></jsp:include>
		<!-- header end -->
    	<jsp:include page="./inc/page/header_main.jsp"></jsp:include>
    </div>
    <!-- hero-content end-->
	
	
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<!-- partial:partials/_sidebar.html -->
				<jsp:include page="./inc/mypage/sidebar.jsp"></jsp:include>
				 <!-- sidebar.html end  -->
			</div>
			<div class="col-md-9">
			<div class="chat-container p-0">
		<div class="card-chat">
			<div class="row-chat g-0">
				<div class="col-12 col-lg-5 col-xl-4 border-right">

					<div class="px-4 d-none d-md-block">
						<div class="d-flex align-items-center">
							<div class="flex-grow-1">
								<input type="text" class="form-control my-3" placeholder="대화상대이름..">
							</div>
							<div class="chat-icon mdi mdi-comment-plus-outline"></div>
						</div>
					</div>

					<a href="#" class="list-group-item list-group-item-action border-0">
						<div class="badge bg-success float-right">5</div>
						<div class="d-flex align-items-start">
							<img src="https://bootdey.com/img/Content/avatar/avatar5.png" class="rounded-circle mr-1" alt="Vanessa Tucker" width="40" height="40">
							<div class="chatname flex-grow-1 ml-3">
								신지환
								<div class="chatmessage">안녕하세요</div>
							</div>
						</div>
					</a>

					<hr class="d-block d-lg-none mt-1 mb-0">
				</div>
				<div class="col-12 col-lg-7 col-xl-8">
					<div class="         px-4 border-bottom d-none d-lg-block chat-item-float-overflow">
						<div class="d-flex align-items-center py-1 chat-item-align-left">
							<div class="position-relative">
								<img src="https://bootdey.com/img/Content/avatar/avatar3.png" class="rounded-circle mr-1" alt="Sharon Lessman" width="40" height="40">
							</div>
							<div class="flex-grow-0 pl-3">
								<strong>신지환</strong>
							</div>
						</div>
							<div class="close-item-box-bg">
								<div class="chat-icon mdi mdi-close btn-close-item"></div>
							</div>
					</div>

					<div class="position-relative" style="height:70%">
						<div class="chat-messages p-4" id="chatArea">


						</div>
					</div>

					<div class="flex-grow-0 py-3 px-4 border-top">
						<div class="chat-textarea">
							<textarea class="form-control" rows="6"; cols="30" placeholder="메세지를 입력하세요..." id="t_content"></textarea>
							<button class="btn btn-primary" style="float:right;" id="bt_send">전송</button>											
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
			
			
			
			
			</div>
		</div>	
	</div>
   
	
	<!-- clients_logo -->
    <jsp:include page="./inc/clients_logo.jsp"></jsp:include>
    <!-- clients_logo end -->
    
	<!-- footer -->
	<jsp:include page="./inc/footer.jsp"></jsp:include>
	<!-- footer -->
	<!-- footer_link -->
	<jsp:include page="./inc/footer_link.jsp"></jsp:include>
	<!-- footer_link end-->

</body>
<script type="text/javascript">
	let ws;
	


  //웹소켓을 이용한 서버에 접속
  function connect(){
  	ws=new WebSocket("ws://localhost:8888/chat");
  	
  	ws.onopen=function(){
  		console.log("서버에 접속됨 onopen");
  	}
  	
  	ws.onmessage=function(e){
  		console.log("서버가 보낸 데이터", e.data);
  		
  		//서버가 보낸 메시지를 area에 누적 
  		//$("#t_receive").append(e.data+"\n");
  		showMessageRightCard(e.data);
  	}
  	
  	ws.onclose=function(e){
  		console.log("서버와 접속이 끊김");
  		//끊기는 시점을 발견할때, 1초의 시간 뒤에 다시 재접속하여 프로그램의 
  		//안정성을 높이자
  		setTimeout("connect()", 1000);
  	}
  	ws.onerror=function(e){
  		console.log("에러발생 ",e);
  	}
  }
  
  
  	function getList(){
  		//비동기로 서버에서 불러왔다는 전제하에...
  		let messageList=[];
  		
  		for(let i=0;i<10;i++){
	  		let json={
	  			title:"해영씨"+i	
	  		};
	  		messageList.push(json);
  		}
  		console.log(messageList);
  		
  	}
  	
  	function showMessageRightCard(msg){
  		//현재 시간구하기
  		let date = new Date();
  		let time = date.toLocaleTimeString();
  		
  		//profile, name, time, content
  		let messageRightCard = new MessageRightCard("https://bootdey.com/img/Content/avatar/avatar5.png","신지환",time, msg);
  		$("#chatArea").append(messageRightCard.getBox());	
  	}
  	
  	
  	function sendMsg(){
  		let msg = $("#t_content").val();
  		ws.send(msg);
  	}
  	
	$(function(){
		connect();
		
		$("#bt_send").click(function(){
			sendMsg();	
		});
		
	});  	
  </script>
</html>