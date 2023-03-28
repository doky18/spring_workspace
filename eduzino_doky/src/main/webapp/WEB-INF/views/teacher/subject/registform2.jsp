<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Plus Admin</title>
<!-- plugins:css -->
<jsp:include page="../inc/header_link.jsp"></jsp:include>
<style type="text/css">
.app--container--7qJMh {
    display: flex;
    padding: 3.2rem 2.4rem 6.4rem;
}
.ud-container {
    width: 100%;
    margin-right: auto;
    margin-left: 50px;
}
.side-nav--side-nav--h8FTL {
    max-width: 28.6rem;
    min-width: 17.2rem;
    padding: 7.2rem 2.4rem 3.2rem 0;
    position: relative;
}
.ud-heading-md {
    font-family: udemy sans,-apple-system,BlinkMacSystemFont,Roboto,segoe ui,Helvetica,Arial,sans-serif,apple color emoji,segoe ui emoji,segoe ui symbol;
    font-weight: 700;
    line-height: 1.2;
    letter-spacing: -.02rem;
    font-size: 1.0rem;
}
.ud-unstyled-list {
    list-style: none;
    margin: 0;
    padding: 0;
    max-width: none;
}
.side-nav--nav-section-title--Hq2Jb, .side-nav--nav-item--3XyR4, .side-nav--publish-button--yW0v1 {
    border-left: 5px solid transparent;
}
.side-nav--nav-item-active--10cLf {
    border-left-color: #1c1d1f;
}
.side-nav--nav-section-title--Hq2Jb {
    padding: 0.8rem 0 0.8rem 2.4rem;
}
.side-nav--nav-item-link--2qfvl {
    display: flex;
    align-items: flex-start;
    gap: 0.8rem;
    padding: 0.4rem 2rem;
}
.side-nav--completion--25WQ7 {
    border: 1px solid #1c1d1f;
    border-radius: 50%;
    flex-shrink: 0;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    width: 1.4rem;
    height: 1.4rem;
    margin: 0.1rem 0 0;
}
.ud-link-neutral {
    color: #1c1d1f;
}
.app--container--7qJMh {
    display: flex;
    padding: 3.2rem 2.4rem 6.4rem;
}
.app--content--3vcMt {
    flex: 1;
    min-width: 1px;
    width: 100%;
    background: #fff;
    box-shadow: 0 2px 4px rgb(0 0 0 / 8%), 0 4px 12px rgb(0 0 0 / 16%);
}
.sub-header--container--1pQeg {
    flex-wrap: wrap;
    justify-content: space-between;
    gap: 2.4rem;
    padding: 2.4rem 4.8rem;
    border-bottom: 1px solid #d1d7dc;
}

a {
    text-decoration: none;
}
</style>
</head>
  <body>
    <div class="container-scroller container" style="max-width: 1403px;">
		<!-- partial:partials/_sidebar.html -->
		<div class="side-nav--side-nav--h8FTL" data-purpose="side-menu">
			<ul class="ud-unstyled-list side-nav--nav--6iscr side-nav--nav-sections--1OE5j">
	        	<li class="side-nav--nav-section--2jHwe">
	        		<div class="ud-heading-md side-nav--nav-section-title--Hq2Jb">강의 계획</div>
	        		<ul class="ud-unstyled-list">
	        			<li class="side-nav--nav-item--3XyR4 side-nav--nav-item-active--10cLf">
	        				<a class="ud-link-neutral side-nav--nav-item-link--2qfvl" data-purpose="react-nav-link-goals" href="/instructor/course/5198112/manage/goals">
	        					<span class="side-nav--completion--25WQ7" aria-label="불완전함"></span>
	        					<span>대상 수강생</span>
	       					</a>
	    				</li>
	   				</ul>
	 			</li>
	 		</ul>
      	</div>
      <!-- sidebar.html end  -->
      
      <!-- partial  -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_navbar.html -->
        <jsp:include page="../inc/navbar.jsp"></jsp:include>
        <!-- partial -->
        <div class="main-panel">
            <div class="row">
              <div class="col-xl-12 stretch-card grid-margin border">
                	강의 등록 폼 나올곳
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
          
          <!-- partial:partials/_footer.html -->
          <div> 푸터올곳</div>
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

</html>