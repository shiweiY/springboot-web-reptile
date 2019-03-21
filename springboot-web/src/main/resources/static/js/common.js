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
//	var selectspan = $("span[selectspan=\"true\"]");
//	var city_name = selectspan.html();


	var param = {
			cityname : ''
	};

	$.ajax({
		type:"get",
		url:"/main/searchJob",
		dataType:"json",
		async:true,
		success:function(data,flag){
			if(data.listData != null && data.listData.length > 0 ){
				changeJobData('boss_job_data');//显示数据，默认显示Boss直聘页面
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
 */
function changeJobData(idkey){
	debugger;
	$("#"+idkey).parent().addClass("active");
	var joblist = getSerialListData(idkey);//获取数据

	if(joblist != null){

		var job_start_tag = "";
		var info_title_tag = "";
		var job_salary_address_tag = "";
		var company_start_tag = "";
		var company_tag = "";
		var company_info_tag = "";

		$.each(joblist,function(i,job){
			if(i < 10){
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

			}else{
				return false;
			}
		});
	}


}




/***
 * 页面初始化函数部分 -------------------------------------------------------------------------
 * @returns
 */

function initPage(){
//	initPageData();
	pageAffixAppend();
}

/***
 * 初始化页面上方的条件
 * @author yangsw
 */
function initPageData(){
	var result = getSerialListData('mainPage_hotcity');
	var hotcity = result.mainPage_hotcity;
	if(hotcity != null){

		var taghtml = "<span class=\"label label-success\">热门城市: </span>&nbsp;";
		$("#hotcity").append(taghtml);
		$.each(hotcity,function(i,city){
			taghtml = "<span name=\"cityspan\" class=\"cursortag label label-success\">"+city.hc_name+"</span>&nbsp;";
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








/**
 * 与后端数据交互部分-----------------------------------------------------------------------------------
 * 
 * 
 * 获取redis中的List数据
 * @param key 键
 * @returns json
 * @author yangsw
 */
function getSerialListData(key){
	var result;
	if(key != null){
		$.ajax({
			type : "get",
			url : "TransientData/getSerialListData",
			data : {rediskey:key},
			dataType : "json",
			traditional:true,//通过ajax提交数组时，jquery深度序列化以适应php等,它会自动在所设定的参数后面增加中括号： [] 后台取值不便,traditional为true可防止深度序列化
			async : false,
			success:function(data,flag){
				result = data.listData;
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