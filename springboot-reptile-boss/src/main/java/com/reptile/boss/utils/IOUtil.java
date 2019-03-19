package com.reptile.boss.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {


	public static void StringBufferedOutPutFile(String fileStr,String filePath) {
		File file = new File(filePath);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

			bos.write(fileStr.getBytes());
			
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
