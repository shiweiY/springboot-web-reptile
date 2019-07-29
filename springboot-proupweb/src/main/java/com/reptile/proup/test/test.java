package com.reptile.proup.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args) throws Throwable {
//		 String param = "java开发";
//		 
//		 String query = filterChineseParams(param);
//		 System.out.println(query);

       System.out.println(25%10);

	}
	
	public static String enChinese(String value) throws Throwable{
		
		return URLEncoder.encode(value, "utf-8");
	}
	
	
	
	/****
	 * 将参数中的中文字符转码
	 * @param value  参数
	 * @return String 中文转码后的参数
	 * @throws Throwable 
	 */
	public static String filterChineseParams(String param) throws Throwable{
		String reg = "[^\u4E00-\u9FA5]";//中文正则表达
		Pattern pat = Pattern.compile(reg);
		Matcher matcher = pat.matcher(param);
		
		String chineseText = matcher.replaceAll("");//过滤出的中文
		String encode = enChinese(chineseText);//将此中文转码
		
		return param.replace(chineseText, encode);
	}
	
}
