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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="/resources/teacher/subject/regist_style.css" />
</head>
  <body>
    <div class="container-scroller container" style="max-width: 1403px; overflow: initial;">
		<!-- partial:partials/_sidebar.html -->
		<jsp:include page="../inc/subject/sidebar.jsp"></jsp:include>
      <!-- sidebar.html end  -->
      
      <!-- partial  -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_navbar.html -->
        <jsp:include page="../inc/subject/navbar.jsp"></jsp:include>
        <!-- partial -->
        <div class="main-panel app--content--3vcMt" style="padding: 0px;">
           	<div class="sub-header--flex-align-center--1_RER sub-header--container--1pQeg">
           		<div class="sub-header--flex-align-center--1_RER sub-header--content--1H7YJ">
           			<h2 data-purpose="page-title" class="ud-heading-serif-xl">${studyPlanVO.getName()}</h2>
           		</div>
           	</div>
           	<div class="main-content--content--1Myl4">
           		<div class="goals--formgroup-box" id="app_goal">
           			<p class="goals-form--subtitle--3R5d-">
	       				<span>다음 설명은 강의 미리보기에서 공개되며 강의 성과에 직접적으로 영향을 미칩니다. 이러한 설명은 수강생이 강의가 자신에게 맞는지 여부를 판단할 수 있도록 돕습니다.</span>
	      			</p>
	      			<div class="ud-heading-md goals-form--question-label--1lkHx">수강생이 강의를 통해 무엇을 배우게 됩니까?</div>
	      			<p>
	      				<span>수강생이 강의 수료 후 달성하게 될 학습 목표 또는 결과를 2개 이상 입력해야 합니다.</span>
	     			</p>
	           		<form>
	           			<template v-for="item in goalList">
	           				<goal_item :key="item.key" :goal="item" />
	           			</template>
						<button type="button" data-purpose="add-learn-goal" class="btn--form-grop-plus" id="bt_goal_plus">
							<i class="bi bi-plus-lg"></i><span>&nbsp학습목표 추가</span>
						</button>
					</form>
           		</div>
				<div class="goals--formgroup-box" id="app_require">
	      			<div class="ud-heading-md goals-form--question-label--1lkHx">강의를 수강하기 위한 요구 사항 또는 필요 조건은 무엇인가요?</div>
	      			<p>
	      				<span>강의를 수강하기 전에 수강생들에게 필요한 스킬, 도구나 장비 사용 경험을 나열하세요.</span><br>
						<span>요구 사항이 없으면 이 공간을 초급자를 위해 장벽을 낮출 기회로 활용하세요.</span>
	     			</p>
	           		<form>
	           			<template v-for="item in requireList">
	           				<require_item :key="item.key" :require="item" />
	           			</template>
						<button type="button" data-purpose="add-learn-goal" class="btn--form-grop-plus" id="bt_require_plus">
							<i class="bi bi-plus-lg"></i><span>&nbsp요구사항 추가</span>
						</button>
					</form>
				</div>
				<div class="ud-form-group">
					<button class="btn btn-primary mb-2 mb-md-0 mr-2 btn--form-grop-save float-right">저장하기</button>
				</div>
           	</div>
          <!-- content-wrapper ends -->
          <!-- partial -->
        </div>
        <div> 푸터올곳</div>
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
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script type="text/javascript">
const goal_item={
	template:`
		<div class="form-group goals-form--question-text-container--2ac22">
			<input type="text" class="form-control" placeholder="예: 프로젝트 관리자의 역할과 책임을 정의합니다." maxlength="65" @input="update($event,item.key)">
			<span class="btn--input--close--icon" @click="del(item.key)"><i class="bi bi-x"></i></span>
<<<<<<< HEAD
		</div>
=======
		</div> 
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
	`,props:['goal'],
	data(){
		return{
			item:this.goal
		};
	},methods:{
		del:function(key){
			let idx = getIndex(goalApp.goalList,key);
			goalApp.goalList.splice(idx,1);
		},
		update:function(event,key){
			let idx = getIndex(goalApp.goalList,key);
			goalApp.goalList[idx].goal=event.target.value;
		}
	}
}
const require_item={
	template:`
		<div class="form-group goals-form--question-text-container--2ac22">
			<input type="text" class="form-control" placeholder="예: 이 강의를 수강하기 위해서는 window가 필요합니다" maxlength="65" @input="update($event,item.key)">
			<span class="btn--input--close--icon" @click="del(item.key)"><i class="bi bi-x"></i></span>
		</div>
	`,props:['require'],
	data(){
		return{
			item:this.require
		};
	},methods:{
		del:function(key){
			let idx = getIndex(requireApp.requireList,key);
			requireApp.requireList.splice(idx,1);
		},
		update:function(event,key){
			let idx = getIndex(requireApp.requireList,key);
			requireApp.requireList[idx].goal=event.target.value;
		}
	}
}
let goalApp= new Vue({
	el:"#app_goal",
	data:{
		goalList:[],
		key:0
	},
	components:{
		goal_item
	}
});
let requireApp= new Vue({
	el:"#app_require",
	data:{
		requireList:[],
		key:0
	},
	components:{
		require_item
	}
});
function getIndex(list,key){
	for(let i=0;i<list.length;i++){
		if(list[i].key == key)return i;
	}
	return -1;
}

function goalItemPlus(){
	let goal=[];
	goal['key']=++goalApp.key;
	goal['goal']='';
	goalApp.goalList.push(goal);
}
function requireItemPlus(){
	let require=[];
	require['key']=++requireApp.key;
	require['goal']='';
	requireApp.requireList.push(require);
}
function init(){
	for(let i=0;i<2;i++){
		goalItemPlus();
	}
	requireItemPlus();
	
	$("#bt_goal_plus").click(function(){
		goalItemPlus();
	});
	$("#bt_require_plus").click(function(){
		requireItemPlus();
	});
}

$(function(){
	init();
});
</script>
</html>