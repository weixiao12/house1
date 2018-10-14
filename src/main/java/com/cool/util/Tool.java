package com.cool.util;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class Tool {
	public String ConvertDatetToString(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		} else {
			return "";
		}
	}

	
	public static String createUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	//将图片的Base64字符串，反转为字节数组，最后写入指定图片文件中
	public static void writeImgBase64ToFile(String imgBase64,String filePath)throws Exception{
		if(imgBase64 == null || imgBase64.length() == 0) return;

		//判断是否带有协议前缀：data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAA
		if(imgBase64.startsWith("data")){
			imgBase64 = imgBase64.substring(imgBase64.indexOf(",") + 1);
		}
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bs = decoder.decodeBuffer(imgBase64);
		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(bs);
		fos.close();
	}

}
