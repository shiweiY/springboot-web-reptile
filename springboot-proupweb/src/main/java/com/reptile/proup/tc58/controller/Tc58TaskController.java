package com.reptile.proup.tc58.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.reptile.proup.tc58.service.Tc58Service;
import com.reptile.proup.utils.IOUtil;
import com.reptile.proup.utils.StringUtil;

@RestController
@RequestMapping("/proup/Tc58/")
public class Tc58TaskController {

	private static final Logger LOG = LoggerFactory.getLogger(Tc58TaskController.class);

	private static final String URLTMP = "https://bj.58.com/job/";
	private static final String CITYPAGEURL = "https://www.58.com/changecity.html";

	private static CloseableHttpClient CLIENT = HttpClients.createDefault();

	@Autowired
	Tc58Service tc58service;

	//前往58同城城市信息页面 获取城市信息并更入DB
	@GetMapping(value = "/Tc58CityInfoUpdate")
	public void cityInfoUpdate(){

		try {
			URIBuilder ubuilder = new URIBuilder(CITYPAGEURL);

			URI uri = ubuilder.build();
			HttpGet doGet = new HttpGet(uri);

			CloseableHttpResponse response = CLIENT.execute(doGet);

			if(response.getStatusLine().getStatusCode() == 200){
				String result = EntityUtils.toString(response.getEntity(),"UTF-8");

				IOUtil.StringBufferedOutPutFile(result, "E://reptile/tc58UpdateCity.html");
				//				boolean flag = tc58service.cityInfoUpdate(result);
				boolean flag = tc58service.cityInfoUpdate(result);

				if(flag){
					LOG.info("58同城  城市信息更新成功！");
				}else{
					LOG.error("58同城  城市信息时出现异常！");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("58同城  城市信息时出现异常！");
		}

	}

	@GetMapping(value = "/updateQueryParamsMapping")
	public void updateQueryParamsMapping(){
        try {
            URIBuilder ubuilder = new URIBuilder(CITYPAGEURL);

            URI uri = ubuilder.build();
            HttpGet doGet = new HttpGet(uri);

            CloseableHttpResponse response = CLIENT.execute(doGet);

            if(response.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(response.getEntity(),"UTF-8");

//                IOUtil.StringBufferedOutPutFile(result, "E://reptile/tc58UpdateCity.html");
                //				boolean flag = tc58service.cityInfoUpdate(result);
                boolean flag = tc58service.cityInfoUpdate(result);

                if(flag){
                    LOG.info("58同城  城市信息更新成功！");
                }else{
                    LOG.error("58同城  城市信息时出现异常！");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.info("58同城  城市信息时出现异常！");
        }
	}



}
