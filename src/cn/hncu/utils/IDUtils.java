package cn.hncu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/**
 * 生成UUID和生成时间使用
 * @author 陈浩翔
 * 2016-12-27
 */
public class IDUtils {
	/**
	 * 生成UUID
	 * @return
	 */
	public static String uuid(){
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		return uuid;
	}
	
	public static String timeToString(long time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(time));
	}
	
	public static void main(String[] args) {
		System.out.println(timeToString(new Date().getTime()));
		System.out.println(new Date().getTime());
	}
	
}
