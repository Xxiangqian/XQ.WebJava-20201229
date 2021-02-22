package com.rj.bd;

import java.util.Calendar;
import java.util.Date;

import cn.hutool.core.date.BetweenFormatter.Level;
import cn.hutool.core.date.ChineseDate;
import cn.hutool.extra.tokenizer.Word;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.TimeInterval;

public class DateTest {
	public static void main(String[] args) {

		//计时器用于计算某段代码或过程花费的时间
		
				TimeInterval timer = DateUtil.timer();

				
		
		
		//当前时间
		Date date = DateUtil.date();
		System.out.println(date);
		//当前时间
		Date date2 = DateUtil.date(Calendar.getInstance());
		System.out.println(date2);
		//当前时间
		Date date3 = DateUtil.date(System.currentTimeMillis());
		System.out.println(date3);
		//当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
		String now = DateUtil.now();
		System.out.println(now);
		//当前日期字符串，格式：yyyy-MM-dd
		String today= DateUtil.today();
		System.out.println(today);
	
		/**
		 * 字符串转日期
		 */
		String dateStr = "2021-02-20";
		Date date4 = DateUtil.parse(dateStr);
		System.out.println(date4);
		//自定义日期格式转化
		String dateStr2 = "2021-02-20";
		Date date5 = DateUtil.parse(dateStr, "yyyy-MM-dd");
		System.out.println(date5);
		
		//获取Date对象的某个部分
		Date date6 = DateUtil.date();
		//获得年的部分
		int year = DateUtil.year(date6);
		//获得月份，从0开始计数
		int month = DateUtil.month(date6);
		//获得月份枚举
		Month monthenum = DateUtil.monthEnum(date6);
		//.....
		System.out.println(year);
		System.out.println(month);
		System.out.println(monthenum);
		
		/**
		 * 开始和结束时间
		 * 获得每天的开始时间、结束时间，每月的开始和结束时间等等
		 */
		String dateStr3 = "2021-02-19 11:11:11";
		Date date7 = DateUtil.parse(dateStr3);

		//一天的开始，结果：2021-02-19 00:00:00
		Date beginOfDay = DateUtil.beginOfDay(date7);

		//一天的结束，结果：2021-02-19 23:59:59
		Date endOfDay = DateUtil.endOfDay(date7);
		
		System.out.println("一天的开始:"+beginOfDay);
		System.out.println("一天的结束:"+endOfDay);
		
		
		/**
		 *  日期时间偏移
		 */
		//日期或时间的偏移指针对某个日期增加或减少分、小时、天等等，达到日期变更的目的。
		String dateStr5 = "2021-02-19 11:11:11";
		Date date8 = DateUtil.parse(dateStr5);

		//结果：2021-02-21 11:11:11
		Date newDate = DateUtil.offset(date8, DateField.DAY_OF_MONTH, 2);

		//常用偏移，结果：2021-02-22 11:11:11
		DateTime newDate2 = DateUtil.offsetDay(date8, 3);

		//常用偏移，结果：2021-02-19 08:11:11
		DateTime newDate3 = DateUtil.offsetHour(date8, -3);
		
		System.out.println(newDate);
		System.out.println(newDate2);
		System.out.println(newDate3);
		
		//针对当前时间，提供了简化的偏移方法（例如昨天、上周、上个月等）
		//昨天
		DateTime yesterday = DateUtil.yesterday();
		//明天
		DateTime tomorrow = DateUtil.tomorrow();
		//上周
		DateTime lastWeek = DateUtil.lastWeek();
		//下周
		DateTime nextWeek = DateUtil.nextWeek();
		//上个月
		DateTime lastMonth = DateUtil.lastMonth();
		//下个月
		DateTime nextMonth = DateUtil.nextMonth();
		
		System.out.println("昨天:"+yesterday);
		System.out.println("明天:"+tomorrow);
		System.out.println("上周:"+lastWeek);
		System.out.println("下周:"+nextWeek);
		System.out.println("上个月:"+lastMonth);
		System.out.println("下个月:"+nextMonth);
		
		/**
		 * 日期时间差
		 */
		//计算两个日期之间的时间差
		String dateStr6 = "2021-03-01 22:33:23";
		Date date9 = DateUtil.parse(dateStr6);

		String dateStr7 = "2021-04-01 23:33:23";
		Date date10 = DateUtil.parse(dateStr7);

		//相差一个月，31天
		long betweenDay = DateUtil.between(date9, date10, DateUnit.DAY);

		System.out.println(date9+"和"+date10+"之间相差:"+betweenDay+"天");
		
		/**
		 * 格式化时间差
		 */
		//有时候我们希望看到易读的时间差，比如XX天XX小时XX分XX秒
		//Level.MINUTE表示精确到分
		String formatBetween = DateUtil.formatBetween(betweenDay, Level.MINUTE);
		//输出：31天1小时
		System.out.println(formatBetween);
		
		/**
		 * 计时器
		 */
		//计时器用于计算某段代码或过程花费的时间
		
		//TimeInterval timer = DateUtil.timer();

		//---------------------------------
		//-------这是执行过程
		//---------------------------------

		long interval = timer.interval();//花费毫秒数
		long intervalRestart = timer.intervalRestart();//返回花费时间，并重置开始时间
		long intervalMinute = timer.intervalMinute();//花费分钟数
		
		System.out.println("花费毫秒数:"+interval);
		System.out.println("返回花费时间:"+intervalRestart);
		System.out.println("花费分钟数:"+intervalMinute);
		
		/**
		 * 星座和属相
		 */
		
		// "天蝎座"
		String zodiac = DateUtil.getZodiac(Month.OCTOBER.getValue(), 25);
		System.out.println("徐向前的星座是："+zodiac);
		// "蛇"
		String chineseZodiac = DateUtil.getChineseZodiac(2001);
		System.out.println(2001+"年是"+chineseZodiac+"年");
		
		/**
		 * 年龄
		 */
		int age = DateUtil.ageOfNow("2001-10-25");
		System.out.println("我的年龄是："+age);
		boolean LeapYear = DateUtil.isLeapYear(2001);
		System.out.println("我的出生日期是否是闰年："+LeapYear);
		
		/**
		 * 农历日期-ChineseDate
		 */
		//1.构建ChineseDate对象
		//ChineseDate表示了农历的对象，构建此对象既可以使用公历的日期，也可以使用农历的日期。
		//通过农历构建
		ChineseDate chineseDate = new ChineseDate(2001,9,9);

		//通过公历构建
		ChineseDate chineseDate2 = new ChineseDate(DateUtil.parseDate("2001-10-25"));
		
		System.out.println("通过农历构建"+chineseDate);
		System.out.println("通过公历构建"+chineseDate2);
		
		//2.基本使用
		//通过公历构建
		ChineseDate date11 = new ChineseDate(DateUtil.parseDate("2001-10-25"));
		//ChineseDate date11 = new ChineseDate(DateUtil.parseDate("2000-07-28"));
		// 九月
		String ChineseMonth = date11.getChineseMonth();
		System.out.println(ChineseMonth);
		// 九月
		String ChineseMonthName = date11.getChineseMonthName();
		System.out.println(ChineseMonthName);
		// 初九
		String ChineseDay = date11.getChineseDay();
		System.out.println(ChineseDay);
		// 辛巳
		String Cyclical = date11.getCyclical();
		System.out.println(Cyclical);
		// 生肖：蛇
		String ChineseZodiac = date11.getChineseZodiac();
		System.out.println(ChineseZodiac);
		// 传统节日（部分支持，逗号分隔）：重阳节
		String Festivals = date11.getFestivals();
		System.out.println("传统节日:"+Festivals);
		// 辛巳蛇年 九月初九
		String date11Str = date11.toString();
		System.out.println(date11Str);
		
		//获取天干地支
		//通过公历构建
		ChineseDate chineseDate3 = new ChineseDate(DateUtil.parseDate("2001-10-25"));

		// 庚子年甲申月癸卯日
		String cyclicalYMD = chineseDate3.getCyclicalYMD();
		System.out.println("天干地支:"+cyclicalYMD);
	}
	
	
}
