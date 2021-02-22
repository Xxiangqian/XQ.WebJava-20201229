package com.rj.bd;

import java.awt.Image;
import java.awt.Toolkit;

import cn.hutool.core.swing.clipboard.ClipboardUtil;

public class Cut {
	public static void main(String[] args) {
		//setStr 设置文本到剪贴板
		//ClipboardUtil.setStr("123");
		//getStr 从剪贴板获取文本
		System.out.println(ClipboardUtil.getStr());
		
		//定义一个图片类型和地址
		Image image = Toolkit.getDefaultToolkit().createImage("e:/qrcodeFile/456.png");
		//setImage 设置图片到剪贴板
		ClipboardUtil.setImage(image);
		
		//getImage 从剪贴板获取图片
		ClipboardUtil.getImage();
	}
}
