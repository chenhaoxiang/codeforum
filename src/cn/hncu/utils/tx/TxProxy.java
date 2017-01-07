package cn.hncu.utils.tx;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import org.apache.log4j.Logger;

import cn.hncu.utils.DataSourceUtils;
/**
 * 事务的代理
 * @author 陈浩翔
 * 2016-12-27
 */
public class TxProxy implements InvocationHandler {
	private Logger log = Logger.getLogger(TxProxy.class);
	private Object srcObject;
	private TxProxy(Object o) {
		this.srcObject = o;
	}
	@SuppressWarnings("unchecked")
	public static <T>T getProxy(Object src) {
		Object proxedObj = Proxy.newProxyInstance(
				TxProxy.class.getClassLoader(), src.getClass().getInterfaces(),
				new TxProxy(src));
		return (T)proxedObj;
	}
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Object src,Class<T> cls) {
		Object proxedObj = Proxy.newProxyInstance(
				TxProxy.class.getClassLoader(), src.getClass().getInterfaces(),
				new TxProxy(src));
		return (T)proxedObj;
	}
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> cls) {
		Object src=null;
		try {
			src = cls.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		Object proxedObj = Proxy.newProxyInstance(
				TxProxy.class.getClassLoader(), src.getClass().getInterfaces(),
				new TxProxy(src));
		return (T)proxedObj;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.isAnnotationPresent(Transaction.class)) {
			Connection conn = null;
			Object returnValue = null;
			try {
				conn = DataSourceUtils.getConnection();
				log.info("开始事务。连接对象为："+conn);
				conn.setAutoCommit(false);
				returnValue = method.invoke(srcObject, args);
				log.info("提交一个事务");
				conn.commit();
			} catch (Exception e) {
				log.info("事务出错回滚");
				conn.rollback();
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				log.info("将Connection放回到池中");
				conn.setAutoCommit(true);
				conn.close();
				/**
				 * 为了保证不出错，必须要remove一下
				 */
				DataSourceUtils.remove();
			}
			return returnValue;
		} else {
			log.info("不存在此注解，不开事务。");
			return method.invoke(srcObject, args);
		}
	}
}
