package com.rj.bd;

import java.awt.Color;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

public class Orcode {
	public static void main(String[] args) {
		/**
		 * 生成二维码
		 */
		QrConfig config = new QrConfig(300, 300);
		// 设置边距，既二维码和背景之间的边距
		config.setMargin(3);
		// 设置前景色，既二维码颜色（青色）
		config.setForeColor(Color.CYAN.getRGB());
		// 设置背景色（灰色）
		config.setBackColor(Color.GRAY.getRGB());

		// 生成二维码到文件，也可以到流
		QrCodeUtil.generate("向前你好", config, FileUtil.file("e:/qrcodeFile/qrcode2.jpg"));

		/**
		 * 纠错
		 * 很多时候，二维码无法识别，这时就要调整纠错级别。纠错级别使用zxing的ErrorCorrectionLevel枚举封装，包括：L、M、Q、H几个参数，由低到高。
		 * 低级别的像素块更大，可以远距离识别，但是遮挡就会造成无法识别。高级别则相反，像素块小，允许遮挡一定范围，但是像素块更密集。
		 */
		QrConfig config2 = new QrConfig();
		// 高纠错级别
		config.setErrorCorrection(ErrorCorrectionLevel.H);
		QrCodeUtil.generate("你好向前", config2, FileUtil.file("e:/qrcodeFile/qrcode3.jpg"));

		
		/**
		 * 识别二维码
		 */

//		String decode = QrCodeUtil.decode(FileUtil.file("e:/qrcodeFile/qrcode3.jpg"));
		String decode = QrCodeUtil.decode(FileUtil.file("e:/qrcodeFile/456.png"));
		System.out.println("识别的二维码："+decode);
	}
}
