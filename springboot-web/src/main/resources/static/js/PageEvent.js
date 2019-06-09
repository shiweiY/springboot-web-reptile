$(document).ready(function() {

	/**
	 * 处理页面上方条件中的城市tag
	 * 
	 * common.js中动态添加的元素无法用click直接绑定，使用on从父标签开始绑定
	 * 
	 * 点击程式label时标红，再点击另一个label时取消之前label的标红，将当前点击的标红
	 */
	$(".city-wrapper").on("click","span[name='cityspan']", function(){
		var hclass = $(this).hasClass("label-success");//判断时候未点击过
		if(hclass == true){//表示为绿色未点击过

			//现将其他点击过的label取消标红
			var cityEle = $("#hotcity").children();
			$.each(cityEle,function(i,city){
				if($(this).hasClass("label-danger") == true){
					$(this).removeClass("label-danger");
					$(this).removeAttr("selectspan");
					$(this).addClass("label-success");
				}
			});

			//将当前选择的label标红
			$(this).removeClass("label-success");
			$(this).addClass("label-danger");
			$(this).attr("selectspan","true");
		}else{
			$(this).removeClass("label-danger");
			$(this).addClass("label-success");
			$(this).removeAttr("selectspan");
		}
	});


	/***
	 * 左方附加导航栏点击时的active切换及事件
	 */
	$("#affixul").on("click","a",function(){

		//动态切换点击时候的显示状态
		changeActive(this,"affixul")
		
		//调用方法切换右方的数据显示
		changeJobData(this.id,1,1);

	});

	
	/**
	 * 页面下方分页按钮点击函数
	 */
	$("#pagination").on("click","a[name='pagination_a']",function(){
		
		//动态切换点击时候的显示状态
		changeActive(this,"pagination");
		
		var showdomid = $("div[show='true']").first().attr("id");
		var cachekey = $("div[show='true']").first().attr("cachekey");
		var pagenum = "";
		$("a[name='pagination_a']").each(function(i,ele){
			if($(this).parent().hasClass("active")){
				pagenum = $(this).text();
			}
		});
		
		//切换分页数据
		changeJobData(showdomid,cachekey,pagenum);
		
	});
	
	
	//分页栏位 左箭头 按钮
	$("#pagination").on("click","#pagination_left",function(){
		var pageNum = $("#pagination").attr("pagenum");
		var dnum = $("#pagination").attr("datanum");//选中元素的页码值
		
		if(Number(dnum) ==1 && Number(pageNum) == 1){//第一大页第一页数据  点击  << 无效
			return;
		}
		var activeTag = $("#pagination").children(".active");//当前选中的元素
		var prevTag = $(activeTag).prev().children().first();
		if($(prevTag).attr("id") == "pagination_left"){
			
			jobSearch(Number(pageNum)-1);
			return;
		}
		
		var num = Number(dnum) - 1;//向左翻页后的页码
		
		//左侧导航栏位选中的数据方
		var idkey = "";
		$("a[name='left_affix']").each(function(i,ele){
			if($(this).parent().hasClass("active")){
				idkey = this.id;
			}
		});
		
		$(activeTag).removeClass();//移出本元素的选中状态
		var lt = $(activeTag).prev();//前一个元素
		$(lt).addClass("active");//使前一个元素选中
		
		//切换分页数据
		changeJobData(idkey,num,pageNum);
		
		$("#pagination").attr("datanum",num)
		
		$("#pagination_a_"+num).parent().addClass("active");//选中当前页
		
	});
	
	//分页栏位 右箭头 按钮
	$("#pagination").on("click","#pagination_right",function(){
		var pageNum = $("#pagination").attr("pagenum");//当前Redis中的数据页
		
		var activeTag = $("#pagination").children(".active");//当前选中的元素
		var nextTag = $(activeTag).next().children().first();
		if($(nextTag).attr("id") == "pagination_m"){
			
			jobSearch(Number(pageNum)+1);
			return;
		}
		
		var dnum = $("#pagination").attr("datanum");//选中元素的页码值
		var num = Number(dnum) + 1;//向左翻页后的页码
		
		//左侧导航栏位选中的数据方
		var idkey = "";
		$("a[name='left_affix']").each(function(i,ele){
			if($(this).parent().hasClass("active")){
				idkey = this.id;
			}
		});
		
		$(activeTag).removeClass();//移除本元素的选中状态
		var nt = $(activeTag).next();//前一个元素
		$(nt).addClass("active");//使前一个元素选中
		
		//切换分页数据
		changeJobData(idkey,num,pageNum);
		
		$("#pagination").attr("datanum",num);
		$("#pagination_a_"+num).parent().addClass("active");//选中当前页
		
	});
	
	
	
	/**
	 * 页面下方分页按钮点击函数
	 */
	$("#pagination").on("click","#pagination_m",function(){
		var pageNum = $("#pagination").attr("pagenum");
		jobSearch(Number(pageNum)+1);
		
	});


//	//分页数据切换
//	function fydata(obj,id){
//		//动态切换点击时候的显示状态
//		changeActive(obj,id);
//
//		//点击的页码
//		var pageNum = $(obj).html();
//		
//		//左侧导航栏位选中的数据方
//		var idkey = "";
//		$("a[name='left_affix']").each(function(i,ele){
//			if($(this).parent().hasClass("active")){
//				idkey = this.id;
//			}
//		});
//		
//		//切换分页数据
//		changeJobData(idkey,pageNum);
//	}

	//动态切换标签点击时候的显示状态
	function changeActive(obj,id){
		var hasclass = $(obj).parent().hasClass("active");
		if(hasclass == false){
			var liEle = $("#"+id).children();
			$.each(liEle,function(i,li){
				if($(this).hasClass("active") == true){
					$(this).removeClass("active");
				}
			});
			$(obj).parent().addClass("active");
		}
	}

	/***
	 * 下拉选组件初始化
	 */
	$('#ExpSelect').dropdown( {
		gutter : 5
	});
	$('#DegreeSelect').dropdown( {
		gutter : 5
	});
	$('#SalarySelect').dropdown( {
		gutter : 5
	});
	$('#StageSelect').dropdown( {
		gutter : 5
	});
	$('#ScaleSelect').dropdown( {
		gutter : 5
	});

});

