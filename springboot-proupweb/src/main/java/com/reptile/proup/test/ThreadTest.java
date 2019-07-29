package com.reptile.proup.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
	
	public static void main(String[] args) {
		begin();
	}
	
	public static void begin() {
		String[] str = {"0","1","2","3","4","5","6","7","8","9","10"};
		
		ExecutorService exepool = Executors.newCachedThreadPool();

		Future<String[]>  result = exepool.submit(new Callable<String[]>() {

			@Override
			public String[] call() throws Exception {
				return getIndex0to3(str);
			}
			
		});
		
		Future<String[]>  result2 = exepool.submit(new Callable<String[]>() {
			
			@Override
			public String[] call() throws Exception {
				return getIndex3to7(str);
			}
			
		});
		
		try {
			String r1[] = result.get();
			String r2[] = result2.get();
			for (int i = 0; i < r1.length; i++) {
				System.out.print(" " + r1[i]);
			}
			System.out.println();
			for (int i = 0; i < r2.length; i++) {
				System.out.print(" "+r2[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		exepool.shutdown();
		System.out.println("主线程："+Thread.currentThread().getName());
		
	}
	
	
	
	public static String[] getIndex0to3(String[] str){
		
		String[] strs = new String[3];
		
		for (int i = 0; i < 3; i++) {
			strs[i] = str[i];
		}
		
		return strs;
	}
	
	public static String[] getIndex3to7(String[] str){
		
		String[] strs = new String[4];
		
		int j = 0;
		for (int i = 3; i < 7; i++) {
			strs[j] = str[i];
			j++;
		}
		
		return strs;
	}
}
