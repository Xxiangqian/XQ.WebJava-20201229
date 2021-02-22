package com.rj.bd;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;

public class Type {
	public static void main(String[] args) {
		/**
		 * 1.转换为字符串
		 */
		int a = 1;
		//将int类型 转成字符串
		String aStr = Convert.toStr(a);
		//将long数组 类型 转成字符串
		long [] b = {1,2,3,4,5};
		String bStr = Convert.toStr(b);
		
		System.out.println(aStr);

		System.out.println(bStr);
		
		/**
		 * 2.转换为指定类型数组
		 */
		String[] c = { "1", "2", "3", "4" };
		//结果为Integer数组
		Integer[] intArray = Convert.toIntArray(b);

		long[] d = {1,2,3,4,5};
		//结果为Integer数组
		Integer[] intArray2 = Convert.toIntArray(c);
		
		//输出各自为一的位置
		System.out.println(intArray[0]);
		System.out.println(intArray2[0]);
		
		/**
		 * 3.转为日期对象
		 */
		
		String e = "2021-02-20";
		Date value = Convert.toDate(e);
		System.out.println(value);
		
		/**
		 * 4.转为集合
		 */
		
		Object[] f = {"你", "好", "HuTool", 1};

		List<?> list = Convert.toList(f);
		
		System.out.println(list);
		
		/**
		 * 5. 16进制
		 */
		
		//转为16进制（Hex）字符串
		String g = "向前在学HuTool";
		
		String hex = Convert.toHex(g,CharsetUtil.CHARSET_UTF_8);
		System.out.println(g+" 转为16进制的字符串为 ："+hex);
		
		//将16进制（Hex）字符串转为普通字符串:
		
		String hex2 = "e59091e5898de59ca8e5ada64875546f6f6c";

		String raw = Convert.hexToStr(hex2, CharsetUtil.CHARSET_UTF_8);
		
		System.out.println(hex2+" 16进制转换为 ："+raw);
		
		
		/**
		 * 时间单位转换
		 */
		//Convert.convertTime方法主要用于转换时长单位，比如一个很大的毫秒，我想获得这个毫秒数对应多少分
		
		long h = 6000000;

		//结果为：100
		long minutes = Convert.convertTime(h, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
		
		System.out.println(minutes);
		
		/**
		 * 金额大小写转换
		 */
		//面对财务类需求，Convert.digitToChinese将金钱数转换为大写形式：
		double i = 8888.99;

		//结果为："捌仟捌佰捌拾捌元玖角玖分"
		String digitUppercase = Convert.digitToChinese(i);
		
		System.out.println(digitUppercase);
		
		
		
		
		
		
	}
}
