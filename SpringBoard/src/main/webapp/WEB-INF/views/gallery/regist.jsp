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

//사용자정의 UI컴포넌트 등록하기
//등록한 이후엔 마치 태그처럼 사용이 가능
const imagebox={
	template: `
	<div class="boxStyle">
        <div>X</div>
        <img :src="p_src">
    </div>
	`,
	/*이 컴포넌트를 태그로 호풀하는 자가 넘긴 속성을 받으려면 props로 받는다 */
	props:['src'],
	data(){
		return {
			/*
			props 용도 : 외부에서 전달된 속성값을 보관하기 위한 변수
			p_src의 용도 : 내부템플릿에서 접근하기 위한 변수
			변수명:해당속성*/
			p_src:this.src
			
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
			src:[]
		}
	});
}

//이미지 미리보기
function preview(files){
	//배열안에 들어있는 파일 정보를 하나씩 읽어들여, 화면에 출력
	for(let i=0; i<files.length; i++){
		//배열에 들어있는 파일 하나씩 꺼내기
		let file = files[i];
		
		let reader = new FileReader();		//파일 입력스트림 생성 
		reader.onload=function(e){
			console.log("이미지 읽기 완료 : ", e.target.result);
			app1.src[0]=e.target.result;			//??
			console.log("app1.src[0]", app1.src[0]);
		}
		reader.readAsDataURL(file);		//(대상파일)을 읽어들일거야
	}
}

$(function(){
	init();
	
	//이미지를 선택하면...
	$("input[name='photo']").change(function(){
		//files 배열을 read only 라서 조작이 불가능하다 
		console.log(this.files);
		
		preview(this.files);
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
						  <template>
    						{{src[0]}}
							<imagebox :src="src[0]" />
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