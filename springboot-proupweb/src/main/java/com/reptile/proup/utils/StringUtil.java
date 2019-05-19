package com.reptile.proup.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	private static final char[] provinceArray = {'省','市','盟','县'};

	/***
	 * 判断是否为null/空值	不为空返回true,反之false
	 * @param str
	 * @return
	 */
	public static boolean notNull(String str){
		return (str == null || str.isEmpty()) ? false:true;
	}
	
//	public static void main(String[] args) {
//		replaceProvince("吉林省,延边市,xx县,xx盟");
//	}
	
	/***
	 * 去除 省、市、盟  等字符
	 * @return
	 */
	public static String replaceProvince(String str){
		
		for (char c : provinceArray) {
			str = str.replace(String.valueOf(c), "");
			
		}
		return str;
	}
	
	/**
	 * 中文转换为Unicode码
	 * @param str
	 * @return
	 */
	public static String CN2Unicode(String str){
		char[] cr = str.toCharArray();
		
		StringBuffer sb = new StringBuffer();
		
		for (char c : cr) {
			StringBuffer sbhead = new StringBuffer("\\u");
			sb.append(sbhead.append(Integer.toString(c,16)).toString());
		}
		
		return sb.toString();
		
	}
	
	
	public static String formatVarJSON(String text,final int leftBracketIndex){
		if(!notNull(text))
			return "";
		
		ArrayList<Integer> leftBrackets= new ArrayList<>();
		ArrayList<Integer> rightBrackets = new ArrayList<>();
		
		System.out.println(text.length());
		int beginIndex = leftBracketIndex;
		while (true) {
			int leftIndex = text.indexOf("{", beginIndex);
			if(leftIndex != -1){
				leftBrackets.add(leftIndex);
			}else{
				break;
			}
			
			beginIndex=leftIndex+1;
			
		}
		
		beginIndex = leftBracketIndex;
		while (true) {
			int rightIndex = text.indexOf("}", beginIndex);
			if(rightIndex != -1){
				rightBrackets.add(rightIndex);
			}else{
				break;
			}
			
			beginIndex=rightIndex+1;
		}
		
		System.out.println(leftBrackets);
		System.out.println(rightBrackets);
		
		int rightBracketIndex = 0;
		for (int i = 0; i < leftBrackets.size(); i++) {
				if(rightBrackets.get(i) < leftBrackets.get(i+1)){
					rightBracketIndex = rightBrackets.get(i);
					break;
				}
		}
		
		
		
		return text.substring(leftBracketIndex, rightBracketIndex+1);
	}
}
