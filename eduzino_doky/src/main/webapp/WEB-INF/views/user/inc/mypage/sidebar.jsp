<%@ page contentType="text/html;charset=UTF-8"%>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
<ul class="nav">
  <li class="nav-item nav-profile border-bottom">
    <a href="#" class="nav-link flex-column">
      	<div class="nav-profile-image">
        <img src="/resources/teacher/assets/images/faces/face1.jpg" alt="profile" />
        <!--change to offline or busy as needed-->
        </div>
        <div class="nav-profile-text d-flex ml-0 mb-3 flex-column">
          <span class="font-weight-semibold mb-1 mt-2 text-center">Antonio Olson</span>
        </div>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/mypage">
        <i class="mdi mdi-checkbox-blank-circle menu-icon"></i>
        <span class="menu-title">대시보드</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/mypage">
        <i class="mdi mdi-star menu-icon"></i>
        <span class="menu-title">공지사항</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="collapse" href="#ui-basic1" aria-expanded="true" aria-controls="ui-basic">
      	<i class="mdi mdi-comment-text-outline menu-icon"></i>
        <span class="menu-title">활동</span>
        <i class="menu-arrow"></i>
      </a>
      <div class="collapse show" id="ui-basic1">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item">
            <a class="nav-link" href="/user/message">메세지</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="pages/ui-features/buttons.html">작성한 리뷰</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="pages/ui-features/buttons.html">문의 내역</a>
          </li>
        </ul>
      </div>
    </li>
    <li class="nav-item">
       <a class="nav-link" data-toggle="collapse" href="#ui-basic2" aria-expanded="true" aria-controls="ui-basic">
        <i class="mdi mdi-play-protected-content menu-icon"></i>
        <span class="menu-title">수강신청 관리</span>
         <i class="menu-arrow"></i>
      </a>
      <div class="collapse show" id="ui-basic2">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item">
            <a class="nav-link" href="/cart/list">장바구니</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/cart/wishlist">찜목록</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/order/point">포인트</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/order/orderlist">구매내역</a>
          </li>
        </ul>
      </div>
    </li>
    <li class="nav-item">
       <a class="nav-link" data-toggle="collapse" href="#ui-basic3" aria-expanded="true" aria-controls="ui-basic">
        <i class="mdi mdi-clipboard-account menu-icon"></i>
        <span class="menu-title">설정</span>
                 <i class="menu-arrow"></i>
      </a>
      <div class="collapse show" id="ui-basic3">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item">
            <a class="nav-link" href="/user/mypage">내 프로필</a>
          </li>
        </ul>
      </div>
    </li>
  </ul>
</nav>
      