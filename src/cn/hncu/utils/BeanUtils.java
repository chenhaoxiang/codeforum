package cn.hncu.utils;
import java.util.Map;
/**
 * @author 陈浩翔
 *
 * 2017-1-5
 */
public class BeanUtils {
	public static <T>T populate(T t,Map<String,Object> map){
		try{
			org.apache.commons.beanutils.BeanUtils.populate(t,map);
			return t;
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	public static <T>T populate(Class<T> cls,Map<String,Object> map){
		try{
			T t = cls.newInstance();
			return populate(t, map);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
}
