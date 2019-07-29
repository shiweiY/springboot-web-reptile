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
		changeActive(this,"affixul");
		
		var showid = $(this).attr("servername");
		var server_page = $('#jobbox').data(showid+'-server-page');
		var cachekey = showid+"JobArray"+server_page;
		
		changeShowBox(showid);
		
		//调用方法切换右方的数据显示
		var joblist = changeJobData(showid,cachekey,"1");
		
		var prevpn = $('#jobbox').data(showid+"_prevpn");
		if(prevpn == undefined)
			prevpn = 0 ;
		
		var startpn = Number(prevpn)+1;
		var endpn = joblist.length / 10;
		
		//更新下方页码
		paginationAppend(startpn,endpn);

	});
	
	
	/**
	 * 页面下方分页按钮点击函数
	 */
	$("#pagination").on("click","a[name='pagination_a']",function(){
		
		//动态切换点击时候的显示状态
		changeActive(this,"pagination");
		
		//页面正在显示的div,也是jquery.data()和redis中的的key
		var showid = $("#boxinfo").attr("show");
		//数据key
		var server_page = $('#jobbox').data(showid+'-server-page');
		var cachekey = showid+"JobArray"+server_page;
		var pagenum = $(this).attr("apn");//点选的页码
		
		//切换分页数据
		changeJobData(showid,cachekey,pagenum);
		
	});
	
	/**
	 * 页面下方分页按钮点击函数
	 */
	$("#pagination").on("click","#pagination_m",function(){
		readyRightPaginationSearch();
		paginationSearch();
	});
	
	function readyRightPaginationSearch(){
		var showid = $("#boxinfo").attr("show");
		var prevpn = $("a[name='pagination_a']").last().text();
		$('#jobbox').data(showid+"_prevpn",prevpn);//  boss_prevpn
	}
	function readyLeftPaginationSearch(){
		var showid = $("#boxinfo").attr("show");
		var prevpn = $("a[name='pagination_a']").first().text();
		$('#jobbox').data(showid+"_prevpn",prevpn);//  boss_prevpn
	}
	
	
	//分页栏位 左箭头 按钮 
	$("#pagination").on("click","#pagination_left",function(){

		var pagenum = $("#boxinfo").attr("pn");//当前显示的数据页码
		
		var activeTag;
		$("a[name='pagination_a']").each(function(i,ele){
			if($(this).parent().hasClass("active")){
				activeTag = $(this);
				return false;
			}
		});
		
		if(Number($(activeTag).text()) < 2){
			return;
		}
		
		var num = Number(pagenum) - 1;//向左翻页后的页码
		
		var showid = $("#boxinfo").attr("show");
		var server_page = $('#jobbox').data(showid+'-server-page');
		var cachekey = showid+"JobArray"+server_page;
		
		if($(activeTag).parent().prev().attr("id") != "pagination_left_li"){
			$(activeTag).parent().removeClass();//移出本元素的选中状态
			$(activeTag).parent().prev().addClass("active");//使前一个元素选中;
			//切换分页数据
			changeJobData(showid,cachekey,num);
		}else{
			server_page = Number(server_page)-1;
			if(server_page == 1 || server_page < 0){
				server_page = "";
			}
			$('#jobbox').data(showid+'-server-page',server_page);
			
			cachekey = showid+"JobArray"+server_page;
			
//			var joblist = $('#'+showid).data(cachekey);
			var joblist = changeJobData(showid,cachekey,1);
			readyLeftPaginationSearch();
			
			var prevpn = $('#jobbox').data(showid+"_prevpn");
			var endpn = parseInt(joblist.length / 10);//Math.floor(x)
			var startpn = Number(prevpn)-endpn;
			
			//更新下方页码
			paginationAppend(startpn,endpn);
		}
		
	});
	
	//分页栏位 右箭头 按钮
	$("#pagination").on("click","#pagination_right",function(){
		var pagenum = $("#boxinfo").attr("pn");//当前显示的数据页码

		var num = Number(pagenum) + 1;//向右翻页后的页码
		
		var activeTag;
		$("a[name='pagination_a']").each(function(i,ele){
			if($(this).parent().hasClass("active")){
				activeTag = $(this).parent();
				return false;
			}
		});
		
		
		var showid = $("#boxinfo").attr("show");
		var server_page = $('#jobbox').data(showid+'-server-page');
		var cachekey = showid+"JobArray"+server_page;
		//判断下一个链接按钮是不是 ... 按钮
		if($(activeTag).next().attr("id") != "pagination_m_li"){
			$(activeTag).removeClass();//移出本元素的选中状态
			$(activeTag).next().addClass("active");//使前一个元素选中;
			
			//切换分页数据
			changeJobData(showid,cachekey,num);
		}else{
			readyRightPaginationSearch();
			paginationSearch();
		}
		
	});
	
	
	
	//动态切换标签点击时候的显示状态, 左侧导航和 下方 分页
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

