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
	$("#affixul").on("click","a[name='left_affix']",function(){
		
		var hasclass = $(this).parent().hasClass("active");
		
		if(hasclass == false){
			var liEle = $("#affixul").children();
			$.each(liEle,function(i,li){
				if($(this).hasClass("active") == true){
					$(this).removeClass("active");
				}
			});
			
			$(this).parent().addClass("active");
		}
		
		//调用方法切换右方的数据显示
		changeJobData(this.id);
		
	});
	
	
	
	
	
	
	
	/***
	 * 下拉选组件初始化
	 */
	$("#ExpSelect").multiselect({
		nonSelectedText: "工作经验",
		buttonWidth:139,
		width:80
	});
	$("#DegreeSelect").multiselect({
		nonSelectedText: "学历要求",
		buttonWidth:139,
		width:80
	});
	$("#SalarySelect").multiselect({
		nonSelectedText: "薪资要求",
		buttonWidth:139,
		width:80
	});
	$("#StageSelect").multiselect({
		nonSelectedText: "融资阶段",
		buttonWidth:139,
		width:80
	});
	$("#ScaleSelect").multiselect({
		nonSelectedText: "公司规模",
		buttonWidth:139,
		width:80
	});

});

