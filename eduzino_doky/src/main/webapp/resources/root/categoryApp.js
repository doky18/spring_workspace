/**
 * 
 */
let categoryApp;
const category_item={
	template:`
		<option :value="category_idx">{{category_name}}</option>
	`,props:['value','name']
	,data(){
		return{
		category_idx:this.value,
		category_name:this.name
		};
	}
}
categoryApp = new Vue({
	el:"#category_app",
	components:{
		category_item
	},
	data:{
		topCategoryList:[],
		midCategoryList:[],
		subCategoryList:[],
	},
	methods:{
		topCategoryChange:function(event){//상위 카테고리가 변경되었을때 발생하는 메서드
			for(let i=0;i<this.topCategoryList.length;i++){
				if(this.topCategoryList[i].top_category_idx == event.target.value){
					this.midCategoryList=this.topCategoryList[i].midCategoryList
					return;
				}
			}
			this.midCategoryList=[];
			this.subCategoryList=[];
		}
		,midCategoryChange:function(event){//미드 카테고리가 변경되었을때 발생하는 메서드
			for(let i=0;i<this.midCategoryList.length;i++){
				if(this.midCategoryList[i].mid_category_idx == event.target.value){
					this.subCategoryList=this.midCategoryList[i].subCategoryList
					return;
				}
			}
			this.subCategoryList=[]
		}
	}
});