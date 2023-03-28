<%@page import="com.edu.zino.vo.StudyPlanVO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%StudyPlanVO studyPlanVO = (StudyPlanVO)request.getAttribute("studyPlanVO"); %>
<div class="side-nav--side-nav--h8FTL" data-purpose="side-menu">
	<ul class="ud-unstyled-list side-nav--nav--6iscr side-nav--nav-sections--1OE5j">
       	<li class="side-nav--nav-section--2jHwe">
       		<div class="ud-heading-md side-nav--nav-section-title--Hq2Jb">강의 계획</div>
       		<ul class="ud-unstyled-list">
       			<li class="side-nav--nav-item--3XyR4 <%if(studyPlanVO.getStataus() == 0){%>side-nav--nav-item-active--10cLf<%}%>">
       				<a class="ud-link-neutral side-nav--nav-item-link--2qfvl" data-purpose="react-nav-link-goals" href="/teacher/regist/goal">
       					<span class="side-nav--completion--25WQ7" aria-label="불완전함">
       						<svg aria-hidden="true" focusable="false" class="ud-icon ud-icon-xsmall ud-icon-color-neutral"></svg>
      							<span>✔</span>
       					</span>
       					<span>학습목표</span>
      					</a>
   				</li>
       			<li class="side-nav--nav-item--3XyR4 <%if(studyPlanVO.getStataus() == 1){%>side-nav--nav-item-active--10cLf<%}%>">
       				<a class="ud-link-neutral side-nav--nav-item-link--2qfvl" data-purpose="react-nav-link-goals" href="/teacher/regist/detail">
       					<span class="side-nav--completion--25WQ7">
       						<svg aria-hidden="true" focusable="false" class="ud-icon ud-icon-xsmall ud-icon-color-neutral"></svg>
       					</span>
       					<span>강의내용</span>
      					</a>
   				</li>
       			<li class="side-nav--nav-item--3XyR4 <%if(studyPlanVO.getStataus() == 2){%>side-nav--nav-item-active--10cLf<%}%>">
<<<<<<< HEAD
       				<a class="ud-link-neutral side-nav--nav-item-link--2qfvl" data-purpose="react-nav-link-goals" href="/teacher/regist/movie">
=======
       				<a class="ud-link-neutral side-nav--nav-item-link--2qfvl" data-purpose="react-nav-link-goals" href="/instructor/course/5198112/manage/goals">
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
       					<span class="side-nav--completion--25WQ7"></span>
       					<span>커리큘럼</span>
      					</a>
   				</li>
       			<li class="side-nav--nav-item--3XyR4 <%if(studyPlanVO.getStataus() == 3){%>side-nav--nav-item-active--10cLf<%}%>">
       				<a class="ud-link-neutral side-nav--nav-item-link--2qfvl" data-purpose="react-nav-link-goals" href="/instructor/course/5198112/manage/goals">
       					<span class="side-nav--completion--25WQ7"></span>
       					<span>강의미리보기</span>
      					</a>
   				</li>
  				</ul>
			</li>
		</ul>
</div>