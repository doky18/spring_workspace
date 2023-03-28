<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>EduZino</title>

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
	
	 <!-- **********************버튼************************** -->
	<div class="container">
		<div class="row">
			<!-- **********************사이드 바************************** -->
			<div class="col-md-3">
				<!-- partial:partials/_sidebar.html -->
				<jsp:include page="./inc/mypage/sidebar.jsp"></jsp:include>
				 <!-- sidebar.html end  -->
			</div>
			<!-- **********************사이드 바************************** -->
			<!-- ********************** 내 계정 수정 ************************** -->
			<div class="col-md-9 mt-5">
			<div class="member-container  page-modify page-modify-decoupled-index env-production" data-controller="modify" data-log-pack="{ &quot;isMobile&quot;:false }">
            
<section class="usermodify">
    <h1 class="usermodify-title">회원정보 수정</h1>
   <div class="usermodify-sub-option" style="display: none;">
       <form class="usermodify-util-form" action="/login/showPersonalInformationUseHistory.pang" method="get">
           <button type="submit" class="usermodify-util-button">개인정보 이용내역 보기</button>
       </form>
    </div>
    
    <form name="userModifyForm" id="userModifyForm">
        <input type="hidden" id="confirmTicket" name="confirmTicket" value="3xX866hqjbLYGuv83x8aIQqja715__LhL0LllrrszpCNTp4GxC20h2An">
        <input type="hidden" id="successMessage" name="successMessage" value=""> 
    </form>
    <table class="usermodify-table">
        <tbody>
            
                <tr>
    <th scope="row">아이디(이메일)</th>
    <td><div class="usermodify-email">
	<input type="hidden" id="originEmail" value="soyeoni0118@gmail.com">
	<input type="hidden" id="regEmail" value="soyeoni0118@gmail.com">
	<input type="hidden" id="emailDupCheck" value="N">
    <input type="hidden" id="changeEmail" value="">

    <strong class="usermodify-email-current-mail">soyeoni0118@gmail.com</strong>
    <button type="button" class="usermodify-email-change-btn" style="display: inline-block;">이메일 변경</button>
    <button type="button" class="usermodify-email-change-cancel" style="display: none;">이메일 변경취소</button>

    <form class="usermodify-email-change-auth" action="/login/checkEmailDuplication.pang" method="POST" style="display: none;">
        <input data-errmsg="이미 가입된 메일주소입니다. 다른 이메일을 입력하여 주세요." data-target="usermodify-email-change-errmsg" class="usermodify-email-tf" type="text" value="soyeoni0118@gmail.com">
        <button type="submit" class="usermodify-email-change-auth-send">인증메일 전송</button>
        <div class="form-err usermodify-email-change-errmsg" style="display: none;"></div>
    </form>

    <form class="usermodify-email-change-form" action="/member/modify/sendEmail.pang" method="POST" style="display: none;">
        <input type="password" class="usermodify-email-change-tf">
        <button type="submit" class="usermodify-email-change-submit">비밀번호 확인</button>
        <span class="usermodify-email-change-msg">안전한 변경을 위해 쿠팡 비밀번호를 입력해주세요.</span>
    </form>

    <div class="usermodify-email-change-done">
        <div class="usermodify-email-change-done-msg">
            회원님은 현재 이메일주소를 변경하여, 신청하신 이메일(<strong class="usermodify-email-change-done-email"></strong>)로 인증메일이 발송되었습니다.
            <br>
            이메일 확인 후 <strong>회원정보 수정 인증</strong> 버튼을 클릭하시면 이메일 변경이 완료되며, 변경하신 이메일주소로 로그인 하실 수 있습니다.
        </div>
        <div class="usermodify-email-change-done-foot">
            <button type="button" class="usermodify-email-change-done-cancel">이메일 변경취소</button>
            <button type="button" class="usermodify-email-change-resend">인증메일 재전송</button>
        </div>
    </div>
</div>
</td>
</tr>
<tr>
    <th scope="row">이름</th>
    <td><div class="usermodify-name">
    <span class="usermodify-name-name">안소연</span>
        <div class="usermodify-name-changename-success" style="display: none;">
        <strong>개명하신 이름으로 변경되어 저장되었습니다.</strong>
    </div>
    <span class="usermodify-name-errmsg" style="display: none;">
        <i class="icon-alert-gray"></i> 본인확인이 필요합니다.
    </span>
    <div class="usermodify-name-auth" style="display: none;">
        <div class="usermodify-name-auth-msg usermodify-name-auth-msg__auth" style="display: none;">본인 미인증 고객의 경우, 입력하신 정보가 기존 회원정보와 상이할 시 입력하신 정보로 회원정보가 자동 변경됩니다.</div>
        <div class="usermodify-name-auth-msg usermodify-name-auth-msg__change" style="">개명하신 경우 본인인증을 하시면 자동으로 이름이 변경됩니다.</div>
        <div class="usermodify-name-auth-method">
            <label class="usermodify-name-auth-method-radio active">
                <input class="usermodify-name-auth-method-phone" id="usermodify-name-auth-method-phone" name="usermodify-name-auth-method" type="radio" checked="">
                <span>본인명의 휴대폰으로 인증</span>
            </label>
        </div>
        <div class="usermodify-name-auth-box">
            <div class="usermodify-name-auth-phone">
                회원님의 명의로 등록된 휴대폰으로 본인인증을 진행합니다.
                <button type="button" class="usermodify-name-auth-phone-btn">본인명의 휴대폰으로 인증</button>
            </div>
        </div>
    </div>
</div>
</td>
</tr>
<tr>
    <th scope="row">휴대폰 번호</th>
    <td><div class="usermodify-phone">
	<input type="hidden" id="originPhoneNumber" value="01079633077">
    <strong class="usermodify-phone-current-number">01079633077</strong>
    <button type="button" class="usermodify-phone-change" style="display: inline-block;">휴대폰 번호 변경</button>
    <button type="button" class="usermodify-phone-cancelchange" style="display: none;">휴대폰 번호 변경 취소</button>
    <form class="usermodify-phone-auth-send" action="/member/modify/sendSmsAuthNumber.pang" method="post" style="display: none;">
        <input type="text" class="usermodify-phone-tf" value="01079633077">
        <button type="submit" class="usermodify-phone-auth-send-submit">인증번호 전송</button>
        <div class="form-err usermodify-phone-auth-errmsg" style="display: none;"></div>
    </form>
    <form class="usermodify-phone-authform" action="/member/modify/changePhone.pang" method="post" style="display: none;">
        <input type="text" class="usermodify-phone-auth-tf" placeholder="인증번호 입력">
        <button type="submit" class="usermodify-phone-auth-submit">인증</button>
        <button type="button" class="usermodify-phone-auth-resend">인증번호 재전송</button>
        <div class="form-err usermodify-phone-auth-errmsg" style="display: none;"></div>
    </form>
    <div class="usermodify-phone-auth-msg" style="display: none;">입력하신 번호로 인증번호가 발송 되었습니다.</div>
</div></td>
</tr>


            
            <tr>
                <th scope="row">비밀번호변경</th>
                <td><div class="usermodify-password">
    <table class="usermodify-input-table">
        <tbody><tr>
            <th>
                현재 비밀번호
            </th>
            <td>
                <input type="password" class="usermodify-password-currentpassword-tf member__input-border"><div class="member__input-guide-area"></div>
            </td>
        </tr>
        <tr>
            <th>
                새 비밀번호
            </th>
            <td>
                <input type="password" class="usermodify-password-newpassword-tf member__input-border"><div class="member__input-guide-area"></div>
            </td>
        </tr>
        <tr>
            <th>
                비밀번호 다시 입력
            </th>
            <td>
                <input type="password" class="usermodify-password-newpassword-confirm-tf member__input-border"><div class="member__input-guide-area"></div>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="button" class="usermodify-password-submit">비밀번호 변경</button>
            </td>
        </tr>
    </tbody></table>
    
</div>
</td>
            </tr>
            <tr>
                <th scope="row">배송지</th>
                <td>배송지 주소 관리는 <a href="#" id="deliveryAddressPopUp"><strong>[배송지 관리]</strong></a>에서 수정, 등록 합니다.</td>
            </tr>
            <tr>
                <th scope="row">수신설정</th>
                <td>
                    
                        <!--마케팅 및 이벤트 목적의 개인정보 수집 및 이용 동의함 21.08.13 popup-->



<!--광고성 정보 수신 동의함 21.08.13 popup-->



<div id="personal-result-template" class="dn">
    <div class="blue-gray-800 t4">
        <div>전송자: 쿠팡</div>
        <div>일시: ${year}년 ${month}월 ${day}일 ${hour}시 ${minute}분</div>
        <div class="bold">처리 결과:</div>
    </div>
</div>







<div class="modify__group modify__group--subscribe">
    <div class="modify__row modify__row--subscribe">
        <div class="modify__label-wrap--subscribe-agree-ads">
            <label class="modify__label-wrap modify__label-wrap--subscribe-email gray-600">
                <input checked="checked" type="checkbox" class="checkbox-personal" style="vertical-align: text-top;">
                <span>마케팅 및 이벤트 목적의 개인정보 수집 및 이용 <span class="info_checkbox_text">동의함 </span></span><span class="blue-gray-600 agree-collect-updated-time"></span>
            </label>

            <div class="ml22">
                <section class="rds-text-button rds-text-button--xs gray-800">
                    <button class="personal-show-more">
                        <div class="rds-content">
                            <span class="rds-content__text">전문보기</span>
                            <div class="rds-content__suffix">
                                <div class="icon-arrow-right-outline-333"></div>
                            </div>
                        </div>
                    </button>
                </section>
            </div>

            <div class="rds-divider rds-divider--horizontal-sm mt18 mb23"></div>

            <label class="modify__label-wrap  gray-700">
                <input type="checkbox" class="checkbox-ads" style="vertical-align: text-top;">
                <span>광고성 정보 수신 <span class="market_checkbox_text">철회함 </span></span>
                <span class="blue-gray-600 agree-marketing-updated-time">22.01.27</span>
            </label>
            (
            <label class="gray-700">
                <input type="checkbox" class="checkbox-ads-sms" style="vertical-align: text-top;"> SMS,MMS
            </label>

            <label class="gray-700">
                <input type="checkbox" class="checkbox-ads-mail" style="vertical-align: text-top;"> 이메일
            </label>

            <label class="gray-700">
                <input disabled="" type="checkbox" class="checkbox-ads-marketing" style="vertical-align: text-top;"> 푸시 알림
            </label>
            )
        </div>

        <div class="ml22">
            <section class="rds-text-button rds-text-button--xs gray-800">
                <button class="ads-show-more">
                    <div class="rds-content">
                        <span class="rds-content__text">전문보기</span>
                        <div class="rds-content__suffix">
                            <div class="icon-arrow-right-outline-333"></div>
                        </div>
                    </div>
                </button>
            </section>
        </div>
    </div>
    <div class="modify__row modify__row--guide gray-500 ml22">

        
            <div>
                *푸시 알림을 받으려면 고객님 기기에서 알림을 허용해주세요.
            </div>
        

        *위 항목을 모두 동의하셔야 쿠팡의 맞춤평 쇼핑혜택(광고)을 받으실 수 있습니다.
    </div>
</div>

                    

                </td>
            </tr>
        </tbody>
    </table>
    <div class="usermodify-secession">
        탈퇴를 원하시면 우측의 회원탈퇴 버튼을 눌러주세요.
        <a class="usermodify-secession-btn" href="secession.pang">회원탈퇴</a>
    </div>
    <div class="usermodify-foot">
        <button type="button" class="usermodify-cancel">나가기</button>
    </div>
</section>

        </div>

			</div>
			<!-- ********************** 내 계정 수정 ************************** -->		</div>	
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
</html>