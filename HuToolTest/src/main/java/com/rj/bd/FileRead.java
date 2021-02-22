package com.rj.bd;

import cn.hutool.core.io.file.FileReader;

public class FileRead {
	public static void main(String[] args) {
		FileReader fileReader = new FileReader("e:/qrcodeFile/123.txt");
		/**
		 * FileReader提供了以下方法来快速读取文件内容：
		 * readBytes
		 * readString
		 * readLines
		 * 
		 * 同时，此类还提供了以下方法用于转换为流或者BufferedReader：
		 * getReader
		 * getInputStream
		 */
		String result = fileReader.readString();
		System.out.println(result);
	}
}
