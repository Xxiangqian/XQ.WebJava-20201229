package com.rj.bd;

import java.util.List;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

public class Reptile {
	public static void main(String[] args) {
		
		
		for (int i = 1; i < 5; i++) {
			//请求列表页
			System.out.println("第"+i+"页");
			String listContent = HttpUtil.get("https://www.oschina.net/news/widgets/_news_index_project_list?p="+i+"&type=ajax");
//			String listContent = HttpUtil.get("https://www.oschina.net/news/widgets/_news_index_project_list?p=1&type=ajax");
			//			System.out.println(listContent);
			//使用正则获取所有标题
			List<String> titles = ReUtil.findAll("<h3 class=\"header\"><a href=\".*?\" target=\"_blank\" title=\".*?\">(.*?)</a></h3>", listContent, 1);
			List<String> link = ReUtil.findAll("<h3 class=\"header\"><a href=\"(.*?)\" (.*?)</a></h3>", listContent, 1);
			
			for (int j = 0; j < titles.size(); j++) {
				//打印标题 和 链接
				System.out.println("标题："+titles.get(j)+" \t链接："+link.get(j));
			}
			

			
		}
		
		
	}
}
