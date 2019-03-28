/***
 * web服务主js函数文件，包含页面初始化/事件的前后端响应
 * 
 * @author yangsw
 * @date 2019-3
 */




/***
 * 页面事件部分 ---------------------------------------------------------------------------------------
 * 
 * 职位搜索按钮
 * @author yangsw
 */
function jobSearch(){


	var param = getPageFilterParams();

	$.ajax({
		type:"get",
		url:"/main/searchJob",
		dataType:"json",
		async:true,
		success:function(data,flag){
			if(data.mapData.list != null && data.mapData.list.length > 0 ){
				console.log(data.message);
				changeJobData('boss_job_data',1);//显示数据，默认显示Boss直聘页面
			}else{
				alert("查询异常，请稍后再试！");
			}
		}

	});
}

/***
 * 附加导航栏位点击时右方的数据切换
 * 
 * @author yangsw
 * @param idkey 附加导航栏的id,也是redis中数据的key
 * @param defaultNum 默认显示第几页数据
 */
function changeJobData(idkey,defaultNum){

	var joblist = getSerialData(idkey);//获取数据
	var length = joblist.length;
	var pageNum = Math.ceil(length/10);//页数,获取此值也为了下方分页按钮的动态生成

	if(joblist != null){

		var job_start_tag = "";
		var info_title_tag = "";
		var job_salary_address_tag = "";
		var company_start_tag = "";
		var company_tag = "";
		var company_info_tag = "";
		
		//数据分页
		var pageBegin = (defaultNum-1)*10;
		var pageEnd = defaultNum * 10;

		$("#joblist").empty();//数据变更前先清空数据div
		$.each(joblist,function(i,job){
			if(i >= pageBegin && i < pageEnd){
				job_start_tag = "<div class=\"job-item\"><div class=\"job-info\">";
				info_title_tag = "<div class=\"info-title\"><a class=\"cursortag\" link=\""+job.job_link+"\">"+job.title+"</a>"+
				"<span class=\"job-exp-degree\">"+job.exp+"<em class=\"vline\"></em>"+job.degree+"</span></div>";

				job_salary_address_tag = "<div class=\"job-salary\">"+job.salary+"<span class=\"job-address\">"+job.address+"</span></div></div>";

				company_start_tag = "<div class=\"job-company\">";
				company_tag = "<div class=\"info-title-right\"><a class=\"cursortag\" link=\""+job.company.link+"\">"+job.company.name+"</a>" +
				"<span class=\"typeword\">"+job.job_time+"</span></div>";
				company_info_tag = "<div class=\"company-info\"><span >"+job.company.type+"<em class=\"vline\"></em>"+job.company.stage+"<em class=\"vline\">" +
				"</em>"+job.company.scale+"</span></div></div></div>";

				$("#joblist").append(job_start_tag+info_title_tag+job_salary_address_tag+company_start_tag+company_tag+company_info_tag);

				//附加菜单选中
				$("#"+idkey).parent().addClass("active");

			}
		});

		//页面是否已经生成过分页按钮, 只是为了切换分页数据，则下方分页按钮不再生成
		if($("#pagination:has(li)").length==0){
			//动态拼接分页栏位显示
			paginationAppend(pageNum);
		}

	}
}

/***
 * 查询时获取选择的条件进行参数处理
 * @returns json-params
 */
function getPageFilterParams(){
	var city = $("#hotcity").children("span[selectspan='true']").html();
	
	//工作经验
	var exp = $("#ExpSelect").next().children("button").attr("title");
	console.log(exp);
	
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

	var li_boss = "<li><a id=\"boss_job_data\" class=\"cursortag\" name=\"left_affix\" >Boss直聘</a></li>";
	var li_zhilian = "<li><a id=\"zhilian_job_data\" class=\"cursortag\" name=\"left_affix\" >智联招聘</a></li>";
	var li_51 = "<li><a id=\"51_job_data\" class=\"cursortag\" name=\"left_affix\" >51job</a></li>";

	$("#affixul").append(li_boss+li_zhilian+li_51);

}

/***
 * 页码分页动态添加
 */
function paginationAppend(pageNum){
	var li_a_start = "";

	if(pageNum > 1){
		$("#pagination").empty();
		for (var i = 0; i <= pageNum+1; i++) {
			if(i == 0){
				li_a_start += "<li ><a id=\"pagination_a\" class=\"cursortag\">&laquo;</a></li>";
			}else if(i == pageNum+1){
				li_a_start += "<li><a id=\"pagination_a\" class=\"cursortag\">&raquo;</a></li>";
			}else{
				li_a_start += "<li><a id=\"pagination_a_"+i+"\" class=\"cursortag\">"+i+"</a></li>";
			}
		}
	}
	
	$("#pagination").append(li_a_start);
	$("#pagination_a_1").parent().addClass("active");

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
			url : "TransientData/getSerialData",
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