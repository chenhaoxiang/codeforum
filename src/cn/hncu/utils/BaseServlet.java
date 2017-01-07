package cn.hncu.utils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/**
 * 基类， 1:修改HttpServletRequest增强 2:动态调用用户指定的方法?cmd=save....,默认为execute方法
 * @author 陈浩翔
 *
 * 2017-1-5
 */
public abstract class BaseServlet extends HttpServlet {
	private Logger log = Logger.getLogger(BaseServlet.class);
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if (null == cmd || cmd.trim().equals("")) {
			cmd = "execute";
		}
		log.debug("调用的方法为:"+cmd);
		try {
			Method method = this.getClass().getMethod(cmd,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("没有此方法：" + e.getMessage(), e);
		}catch(InvocationTargetException e){
			throw new RuntimeException("目标方法执行失败：" + e.getMessage(), e);
		}catch(IllegalAccessException e){
			throw new RuntimeException("你可能访问了一个私有的方法：" + e.getMessage(), e);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	public abstract void execute(HttpServletRequest req,
			HttpServletResponse resp) throws Exception;
}
