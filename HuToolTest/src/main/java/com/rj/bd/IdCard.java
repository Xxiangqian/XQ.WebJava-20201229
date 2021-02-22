package com.rj.bd;

import java.util.Date;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdcardUtil;
import junit.framework.Assert;
/**
 * 身份证测试
 * @author XQ
 *
 */
public class IdCard {
	public static void main(String[] args) {
		String ID_18 = "131025200110252115";

		//是否有效
		boolean valid = IdcardUtil.isValidCard(ID_18);
		
		System.out.println("当前身份证是否有效:"+valid);
		
		//年龄
		
		//获取当前日期字符串，格式：yyyy-MM-dd
		String today= DateUtil.today();
		
		DateTime date = DateUtil.parse(today);
		
		int age = IdcardUtil.getAgeByIdCard(ID_18, date);
		
		System.out.println("当前年龄："+age);
		
		//生日
		String birth = IdcardUtil.getBirthByIdCard(ID_18);
		System.out.println("生日:"+birth);
		
		//省份
		String province = IdcardUtil.getProvinceByIdCard(ID_18);
		System.out.println("省份:"+province);
		
	}
}
