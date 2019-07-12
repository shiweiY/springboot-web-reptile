/***
 * web服务主js函数文件，包含页面初始化/事件的前后端响应
 * 
 * @author yangsw
 * @date 2019-3
 */

var mpath = "/web/controller";


/***
 * 页面事件部分 ---------------------------------------------------------------------------------------
 * 
 * 职位搜索按钮
 * @author yangsw
 */
function jobSearch(){

	var searchId = new Array("tc58");
	
	var timestart=new Date().getTime();
	
	var params = getPageParams();
	params.page = "";
	
	$("div[class='alert alert-danger']").remove();
	$.each(searchId,function(i,id){
		params.showid = id;
		
		var url = mpath+"/"+id+"/searchJob";

		var joblist;
		if(i != 0){//非第一个采用异步查询
			joblist = ajaxGetSearch(url,params);//true 异步
		}else{
			joblist = ajaxGetSearch(url,params);//false 同步
			
			changeShowBox(id);
			$("#boxinfo").attr({"pn":"1","show":id,"cachekey":id+"JobArray"})//当前显示数据的信息
			//初始化下方页码
			initPagination(joblist.length);
		} 
		
		if(joblist != null && joblist.length > 0 ){
			setJobData(id,id+"JobArray",joblist);
			$('#jobbox').data(id+"-server-page","");//源页面的页码 比如boss直聘
		}else{
			$('#'+id).data(id,null);
			$("#"+id).empty();
			$("#"+id).append("<div class=\"alert alert-danger\">无数据！</div>");
			$("#pagination").empty();
		}
		
		
	});
	
	var timeend=new Date().getTime();
	console.log("本次查询共耗时: "+(Number(timeend)-Number(timestart))+" ms");
}

function ajaxGetSearch(curl,params){
	
	var resultJob;
	
	$.ajax({
		type:"get",
		url:curl,
		data:params,
		dataType:"json",
		async:false,
		success:function(data){
			//如果出现异常，显示错误讯息，清空已查询出的数据和分页标签
			if(data.flag == false){
				//显示错误讯息
				$("#jobbox").append("<div class=\"alert alert-danger\">"+data.message+"</div>");
				return;
			}

			resultJob = data.mapData.resultJobArray;
		}

	});
	
	return resultJob;
	
}

//异步查询
function ajaxAsyncSearch(curl,params,id){
	
	$.ajax({
		type:"get",
		url:curl,
		data:params,
		dataType:"json",
		async:true,
		success:function(data){
			//如果出现异常，显示错误讯息，清空已查询出的数据和分页标签
			if(data.flag == false){
				//显示错误讯息
				$("#jobbox").append("<div class=\"alert alert-danger\">"+data.message+"</div>");
				return;
			}

			var joblist = data.mapData.resultJobArray;
			
			if(joblist != null && joblist.length > 0 ){
				setJobData(id,id+"JobArray",joblist);
				$('#jobbox').data(id+"-server-page","");//源页面的页码 比如boss直聘
			}
			
		}

	});
}

function setJobData(divid,cachekey,joblist){

	if(joblist != null){
		//置入jquery缓存
		$('#'+divid).data(cachekey,joblist);

		$("#"+divid).empty();//数据变更前先清空数据div

		jobDomAppend(joblist,divid,0);//动态拼接数据dom

		
	}
}

/***
 * 职位数据拼接展示
 * 
 * @author yangsw
 */
function changeJobData(divid,cachekey,pagenum){

	var joblist = $('#'+divid).data(cachekey);//获取数据
	
//	console.log("changeJobData中获取数据:"+joblist);

	if(joblist != null){

		$("#"+divid).empty();//数据变更前先清空数据div
		
		jobDomAppend(joblist,divid,pagenum);//动态拼接数据dom
		
		$("#boxinfo").attr({"pn":pagenum,"show":divid,"cachekey":cachekey})//当前显示数据的信息
	}else{
		$("#pagination").empty();
		alert("无数据，请重试！");
//		$("#jobbox").append("<div class=\"alert alert-danger\">无数据，请重试！</div>");
	}
	
	return joblist;
}

/***
 * 页面职位数据动态添加
 * @param joblist  职位集合
 * @param divid    显示的div
 * @param pagenum  页码
 */
function jobDomAppend(joblist,divid,pagenum){

	var job_start_tag = "";
	var info_title_tag = "";
	var job_salary_address_tag = "";
	var company_start_tag = "";
	var company_tag = "";
	var company_info_tag = "";

	//数据分页
	var dataBegin = 0;
	var dataEnd =  9;

	if(pagenum > 1){
		dataBegin = (pagenum-1)*10;
		dataEnd =  pagenum * 10 - 1;//数据最开始从0开始
	}

	$.each(joblist,function(i,job){
		if(i >= dataBegin && i <= dataEnd){//i >= 10 && i <= 19
			job_start_tag = "<div class=\"job-item\"><div class=\"job-info\">";
			info_title_tag = "<div class=\"info-title\"><a class=\"cursortag\" link=\""+job.job_link+"\">"+job.title+"</a>"+
			"<span class=\"job-exp-degree\">"+job.exp+"<em class=\"vline\"></em>"+job.degree+"</span></div>";

			job_salary_address_tag = "<div class=\"job-salary\">"+job.salary+"<span class=\"job-address\">"+job.address+"</span></div></div>";

			company_start_tag = "<div class=\"job-company\">";
			company_tag = "<div class=\"info-title-right\"><a class=\"cursortag\" link=\""+job.company.link+"\">"+job.company.name+"</a>" +
			"<span class=\"typeword\">"+job.job_time+"</span></div>";

//			var otherInfo = job.company.otherInfo;

			company_info_tag = "<div class=\"company-info\"><span >"+job.company.otherInfo[0]+"<em class=\"vline\"></em>"+job.company.otherInfo[1]+"<em class=\"vline\">" +
			"</em>"+job.company.otherInfo[2]+"</span></div></div></div>";

			$("#"+divid).append(job_start_tag+info_title_tag+job_salary_address_tag+company_start_tag+company_tag+company_info_tag);
		}
	});

}

//  . . . 按钮查询
function paginationSearch(){
	
	var showid = $("#boxinfo").attr("show");
	var server_page = $('#jobbox').data(showid+'-server-page');
	if(server_page == ""){
		server_page = 1;
	}

	var prevpn = $('#jobbox').data(showid+"_prevpn");
	var params = getPageParams();
	params.page = Number(server_page)+1;//新页码
	params.showid = showid;
	var cachekey = showid+"JobArray"+params.page;

	$("div[class='alert alert-danger']").remove();
	
	var url= mpath+"/"+showid+"/searchJob";

	var joblist = ajaxGetSearch(url,params);
	
	if(joblist != null && joblist.length > 0 ){
		$('#'+showid).data(cachekey,joblist);
		
//		var pn = $("#boxinfo").attr("pn");
		changeJobData(showid,cachekey,"1");
		$('#jobbox').data(showid+'-server-page',params.page);//源页面页码 比如boss直聘
	}else{
		$("#jobbox").append("<div class=\"alert alert-danger\">未能正常查询出数据！</div>");
	}
	
	var startpn = Number(prevpn)+1;
	var endpn = joblist.length / 10;
	
	//更新下方页码
	paginationAppend(startpn,endpn);

}





/***
 * 职位数据拼接展示
 * 
 * @author yangsw
 * @param idkey 附加导航栏的id,也是redis中数据的key
 * @param defaultNum 默认显示第几页数据
 * @param pageNum  原頁面的第几大页
 */
//function changeJobData2(idkey,defaultNum,pageNum){

//var joblist = getSerialData(idkey);//获取数据
//var length = joblist.length;
//var paginationNum = Math.ceil(length/10);//页数,获取此值也为了下方分页按钮的动态生成

//if(joblist != null){

//var job_start_tag = "";
//var info_title_tag = "";
//var job_salary_address_tag = "";
//var company_start_tag = "";
//var company_tag = "";
//var company_info_tag = "";

////数据分页
//var dataBegin = (defaultNum-1)*10;
//var dataEnd = defaultNum * 10;

//$("#joblist").empty();//数据变更前先清空数据div
//$.each(joblist,function(i,job){
//if(i >= dataBegin && i <= dataEnd){
//job_start_tag = "<div class=\"job-item\"><div class=\"job-info\">";
//info_title_tag = "<div class=\"info-title\"><a class=\"cursortag\" link=\""+job.job_link+"\">"+job.title+"</a>"+
//"<span class=\"job-exp-degree\">"+job.exp+"<em class=\"vline\"></em>"+job.degree+"</span></div>";

//job_salary_address_tag = "<div class=\"job-salary\">"+job.salary+"<span class=\"job-address\">"+job.address+"</span></div></div>";

//company_start_tag = "<div class=\"job-company\">";
//company_tag = "<div class=\"info-title-right\"><a class=\"cursortag\" link=\""+job.company.link+"\">"+job.company.name+"</a>" +
//"<span class=\"typeword\">"+job.job_time+"</span></div>";

////var otherInfo = job.company.otherInfo;

//company_info_tag = "<div class=\"company-info\"><span >"+job.company.otherInfo[0]+"<em class=\"vline\"></em>"+job.company.otherInfo[1]+"<em class=\"vline\">" +
//"</em>"+job.company.otherInfo[2]+"</span></div></div></div>";

//$("#joblist").append(job_start_tag+info_title_tag+job_salary_address_tag+company_start_tag+company_tag+company_info_tag);

////左侧附加菜单选中
//$("#"+idkey).parent().addClass("active");

//}
//});

////页面是否已经生成过分页按钮, 只是为了切换分页数据，则下方分页按钮不再生成
//if($("#pagination:has(li)").length==0 || pageNum >= 1){
////动态拼接分页栏位显示		数据页数和当前大页
//paginationAppend(paginationNum,pageNum);
//}

//}
//}

/***
 * 查询前获取选择的条件进行参数处理
 * @returns json-params
 */
function getPageParams(){

	var params={};

	var city = $("#hotcity").children("span[selectspan='true']").html();

	if(city == undefined || city == ""){
		city = "全国";
	}

	//工作经验
	var exp = $("input[name='ExpSelect']").val();
	var degree = $("input[name='DegreeSelect']").val();
	var salary = $("input[name='SalarySelect']").val();
	var stage = $("input[name='StageSelect']").val();
	var scale = $("input[name='ScaleSelect']").val();
	var scale = $("input[name='ScaleSelect']").val();
	var query = $("#SearchInput").val();

	params.query=query;
	params.city=city;
	params.exp=exp;
	params.degree=degree;
	params.salary=salary;
	params.stage=stage;
	params.scale=scale;

	return params;

}



/***
 * 页面初始化函数部分 -------------------------------------------------------------------------
 * @returns
 */

function initPage(){
	initPageData();
	pageAffixAppend();
}

/***
 * 初始化页面上方的条件
 * @author yangsw
 */
function initPageData(){
	var hotcity = getSerialData('mainPage_hotcity');
//	var hotcity = result.mainPage_hotcity;
	if(hotcity != null){

		var taghtml = "<span class=\"label label-success\">热门城市: </span>&nbsp;";
		$("#hotcity").append(taghtml);
		$.each(hotcity,function(i,cityname){
			taghtml = "<span name=\"cityspan\" class=\"cursortag label label-success\">"+cityname+"</span>&nbsp;";
			$("#hotcity").append(taghtml);
		});
		var morecity = "<span  class=\"cursortag label label-warning\" data-toggle=\"tooltip\"  title=\"可以选择更多城市\">更多城市</span>";
		$("#hotcity").append(morecity);
	}

}

/***
 * 动态添加主页面左边附加导航
 * @author yangsw
 */
function pageAffixAppend(){

	var li_boss = "<li><a id=\"boss_affix\" class=\"cursortag\" name=\"left_affix\" servername=\"boss\" >Boss直聘</a></li>";
	var li_zhilian = "<li><a id=\"tc58_affix\" class=\"cursortag\" name=\"left_affix\" servername=\"tc58\" >58同城</a></li>";
	var li_51 = "<li><a id=\"zlzp_affix\" class=\"cursortag\" name=\"left_affix\" servername=\"zlzp\" >智联卓聘</a></li>";

	$("#affixul").append(li_boss+li_zhilian+li_51);

}




/***
 * 刚查出的数据初始化页码
 */
function initPagination(datalength){
	$("#pagination").empty();
	var li_a_start = "";

	//		左边<<
	li_a_start += "<li id=\"pagination_left_li\"><a id=\"pagination_left\" class=\"cursortag\">&laquo;</a></li>";

//	var numStart = 2*pageNum+(pageNum-2);

	var pagenums = Math.ceil(datalength/10);
//	datalength%10 > 0 ? pagenums++ : pagenums;
	var i = 1;
	while(i <= pagenums){
		li_a_start += "<li><a id=\"pagination_a_"+i+"\" name=\"pagination_a\" apn="+i+">"+i+"</a></li>";
		i++;
	}

	//更多页数据按钮
	li_a_start += "<li id=\"pagination_m_li\"><a id=\"pagination_m\" class=\"cursortag\">...</a></li>";
	//		右边>>
	li_a_start += "<li id=\"pagination_right_li\"><a id=\"pagination_right\" class=\"cursortag\">&raquo;</a></li>";


	$("#pagination").append(li_a_start);
	$("a[name='pagination_a']").first().parent().addClass("active");
}

/***
 * 页面下方分页页码  动态添加
 * @param paginationNum 数据总共页数
 * @param pageNum 当前第几大页
 * @param dataNum List中第几页的数据
 */
function paginationAppend(startpn,endpn){
	var li_a_start = "";

	$("#pagination").empty();

	//		左边<<
	li_a_start += "<li id=\"pagination_left_li\"><a id=\"pagination_left\" class=\"cursortag\">&laquo;</a></li>";

//	var numStart = 2*pageNum+(pageNum-2);
	var i = startpn;
	var j = 1;
	while(j <= endpn){
		li_a_start += "<li><a id=\"pagination_a_"+i+"\" name=\"pagination_a\" class=\"cursortag\" apn="+j+">"+i+"</a></li>";
		i++;
		j++;
	}

	//更多页数据按钮
	li_a_start += "<li id=\"pagination_m_li\"><a id=\"pagination_m\" class=\"cursortag\">...</a></li>";
	//		右边>>
	li_a_start += "<li id=\"pagination_right_li\"><a id=\"pagination_right\" class=\"cursortag\">&raquo;</a></li>";

	$("#pagination").append(li_a_start);
	$("a[name='pagination_a']").first().parent().addClass("active");
}


function changeShowBox(showid){
	//左侧附加菜单选中
	$("#affixul").find("#"+showid+"_affix").parent().addClass("active");
	$("#jobbox").find("div[name='jobcontent']").not("#"+showid).hide();
	$("#"+showid).show();
}







/**
 * 与后端数据交互部分-----------------------------------------------------------------------------------
 * 
 * 
 * 获取redis中的数据
 * @param key 键
 * @returns json
 * @author yangsw
 */
function getSerialData(key){
	var result;
	if(key != null){
		$.ajax({
			type : "get",
			url : "web/TransientData/getSerialData",
			data : {rediskey:key},
			dataType : "json",
			traditional:true,//通过ajax提交数组时，jquery深度序列化以适应php等,它会自动在所设定的参数后面增加中括号： [] 后台取值不便,traditional为true可防止深度序列化
			async : false,
			success:function(data,flag){
				result = data.mapData.result;
			}
		});
	}

	return result;
}

function updateCity(){
	var params = {};

	$.ajax({
		type:'post',
		url:'/boss/updateHotCity',
		data:params,
		dataType:'json',
		async:true,
		success:function(data){
			alert("ok");
		}

	});

}


function getCityData(){
	var listHotCity;
	$.ajax({
		type:'post',
		url:'/main/page/initPageCity',
		data:{},
		dataType:'json',
		async:false,
		success:function(data,flag){
			if(data.listData != null && data.listData != undefined){
				listHotCity = data.listData;
			}else{
				listHotCity = null;
				alert(data.message);
			}
		}
	});

	return listHotCity;
}