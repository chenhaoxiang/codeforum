package cn.hncu.utils;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
/**
 * 盐和密码
 * @author 陈浩翔
 *
 * 2016-12-27
 */
public class PasswordUtils {
	private static Logger log = Logger.getLogger(PasswordUtils.class);
	
	/**
	 * 生成盐
	 */
	public static String getSolt(){
		String solt = UUID.randomUUID().toString().replace("-", "");
		log.info("盐为:"+solt);
		return solt;
	}
	
	/**
	 * 参数1为原密码，参数2为盐值
	 */
	public static String md5(String password,String solt){
		Md5PasswordEncoder en = new Md5PasswordEncoder();
		String str = en.encodePassword(password.toLowerCase(), solt.toLowerCase());
		log.info("加密以后值为:"+str);
		return str;
	}
	
	public static void main(String[] args) {
		//String pwd = PasswordUtils.md5("1234", "chx");//8591bfa530427dec20b1992c63322830
		//String pwd = PasswordUtils.md5("a", "a");//21b0304492b4e80831d66abd78514f29
		String pwd = PasswordUtils.md5("admin", "admin");//ceb4f32325eda6142bd65215f4c0f371
		System.out.println(pwd);
		
		System.out.println("盐为："+getSolt());
	}
}
