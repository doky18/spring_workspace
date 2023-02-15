<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 등록</title>
<style type="text/css">
.boxStyle{
	width:70px;
	height: 85px;
	border: 2px solid #ccc;
	display: inline-block;		/*inline: 다른 요소와 공존, block : 크기 설정*/
	margin: 5px;
}
.boxStyle img{
    width: 65px;
    height: 60px;
}
.boxStyle div{
	text-align: right;
	margin-right:5px;
	font-weight: bold;
}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<!-- development version, includes helpful console warnings -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>

<script type="text/javascript">

let app1;
let key=0;		//유저가 프로그램을 사용하는 동안 그 값을 계속 증가시킴. key 유일성을 확보하기 위한 방안

//사용자정의 UI컴포넌트 등록하기
//등록한 이후엔 마치 태그처럼 사용이 가능
const imagebox={
	template:`
		<div class="boxStyle">
			<div @click="delImg(p_idx)"><a href="#">X</a></div>
			<img :src="p_src"/>
		</div>					
	`, 
	/*이 컴포넌트를 태그로 호출하는 자가 넘긴 속성을 받으려면  props로 받는다*/
	props:['src', 'idx'],
	data(){
		return {
			/*
			props 용도 : 외부에서 전달된 속성값을 보관하기 위한 변수
			p_src의 용도 : 내부템플릿에서 접근하기 위한 변수
			변수명:해당속성*/
			p_src:this.src, 
			p_idx:this.idx
		};
	},
	methods:{
		delImg:function(idx){
			alert("삭제할 이미지 고유 idx "+idx);
			
			//imageList 안의 모든 json이 보유한 idx 값을 비교하여, 일치하면 삭제
			//즉 배열에서 제거
			for(let i=0; i<app1.imageList.length;i++){
				let json=app1.imageList[i];
				
				if(json.key==idx){
					app1.imageList.splice(i,1);		//(요소index, 지울 갯수)
				}
			}
		}
	}
};

function init(){
	app1=new Vue({
		el:"#app1",
		components: {
			imagebox
		},
		data : {
			count : 3,
			imageList:[]		/*유저가 선택한 파일에 대한 정보, src, name,...*/
		}
	});
}

//사용자가 선택한 이미지가 이미 app1.imageList에 들어있는지 여부 판단하기
function checkDuplicate(filename){
	let count=0;
	for(let i=0; i<app1.imageList.length; i++){
		let json = app1.imageList[i];
		if(json.name==filename){		//동일한 이름이 발견된다면...
			count++;
			break;
		}
	}
	return count;
}

//이미지 미리보기
function preview(files){
	console.log("files는 ", files);
	
	//배열안에 들어있는 파일 정보를 하나씩 읽어들여, 화면에 출력
	for(let i=0; i<files.length; i++){
		//배열에 들어있는 파일 하나씩 꺼내기
		let file = files[i];
		
		//파일 중복검사 : app1.imageList 배열이 존재하지 않을 경우만...!
		
		if(checkDuplicate(file.name)<1){	//1보다 작다면 발견된 게 없다는 것임
			let reader = new FileReader();		//파일 입력스트림 생성 
			reader.onload = (e)=>{
				console.log("이미지 읽기 완료 : ", e);
				//app1.src.push(e.target.result);			//배열에 넣어주기
				console.log("file 정보는 ", file);
				console.log("src 정보는 ", e.target.result);		//파일의 바이너리 정보 
				
				//이미지 정보를 낱개로 관리하지 말고, 하나의 ,json으로 몰아서 마치 DTO 처럼 관리해보자
				key++;
	
				let json=[];		//empty
				json['key']=key;		//고유값 넣기, 추후 이미지 삭제시 고유값을 사용하려고..
				json['name']=file.name;			//중복이미지 체크시 사용할 예정 
				json['binary']=e.target.result;		//img.src에 대입할 예정
				json['file']=file;			//파일 자체에 대한 모든 정보
				
				app1.imageList.push(json);
				
				//console.log("key 값은 ", key);
				//console.log("i 값은 ", i);
				//console.log("app1.src[0]", app1.src[0]);
			}
			reader.readAsDataURL(file);		//(대상파일)을 읽어들일거야
		}
	}
}

//갤러리 등록
function regist() {
	//기존 html의 폼을 이용하여 전송할 경우, 제일 마지막에 일으킨 이벤트에 의해 
	//등록된 이미지들만 전송하므로, 누적된 이미지는 전송할 수 없다
	//해결책) form을 대체하는 formData객체를 이용하여 개발자가 주도하여 
	//폼을 구성하여 전송하면 됨 html5 FormData + Jquery Ajax 사용이 쉽다
	
	let formData = new FormData();		//비어있는 폼을 하나 생성
	formData.append("title", $("input[name='title']").val());
	formData.append("writer", $("input[name='writer']").val());
	formData.append("content", $("textarea[name='content']").val());
	
	//파일 파라미터 채우기 (2개 이상임)
	for(let i=0; i<app1.imageList.length; i++){
		let file = app1.imageList[i].file;		//전송할 파일 끄집어내기
		formData.append("photo", file);		//여러개가 등록되면 자동으로 배열로 저장이 됨
	}
	
	//ajax 비동기 전송
	$.ajax({
		url:"/gallery/regist",
		type:"post",
		processData:false,	//title=test&writer=ddd 문자열화 방지
		contentType:false,	//application/x-www 방지
		data:formData,
		success:function(result, status, xhr){
			
		}
		
	})
	
	/* 얘 대신 위에 것으로 교체함
	$("#form1").attr({
		action:"/gallery/regist",
		method:"post",
		enctype:"multipart/form-data"
	});
	$("#form1").submit();
*/
}

$(function(){
	init();
	
	//이미지를 선택하면...
	$("input[name='photo']").change(function(){
		//files 배열을 read only 라서 조작이 불가능하다 
		//console.log(this.files);
		preview(this.files);
	});
	//등록버튼
	$("#bt_regist").click(function(){
		regist();
	});
});

</script>

<body>
	<div class="container" id="app1">
		<div class="row">
			<div class="col mt-3">
				<form id="form1">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter title" name="title">
					</div>				
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter writer" name="writer">
					</div>				
					<div class="form-group">
						<textarea class="form-control" name="content"></textarea>
					</div>
									
					<div class="form-group">
						<input type="file" class="form-control" name="photo" multiple>					
					</div>		
					
					<div class="form-group" id="previewArea">
						  <!-- div 하면 세로정렬이 되는데 template 하면 가로정렬이 됨 -->
						  <!-- imageList 안에는 json이 살고 있음 -->
						<template v-for="json in imageList">
							<!-- key 유일성을 확보하기 위한 방안 : 유저가 프로그램을 사용하는 동안 그 값을 계속 증가시킴 -->
							<imagebox :key="json.key" :src="json.binary" :idx="json.key"/>
						</template>
					  </div>
					  
					  <div class="form-group">
					    <button type="button" class="btn btn-primary" id="bt_regist">등록</button>
					    <button type="button" class="btn btn-primary" id="bt_list">목록</button>
					  </div>				
				</form>				

			</div>
		</div>
	</div>
</body>
</html>