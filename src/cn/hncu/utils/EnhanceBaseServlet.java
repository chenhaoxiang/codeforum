package cn.hncu.utils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 基类， 1:修改HttpServletRequest增强 2:动态调用用户指定的方法?cmd=save....,默认为execute方法
 * @author 陈浩翔
 *
 * 2016-12-27
 */
public abstract class EnhanceBaseServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cmd = req.getParameter("cmd"); // 获取调用方法的参数
		if (null == cmd || cmd.trim().equals("")) {
			cmd = "execute";
		}
		try {
			// 通过反射调用子类的方法,接收获取子类的什么方法，且子类的方法必须要接收两个参数
			Method method = this.getClass().getMethod(cmd,
					HttpServletRequest.class, HttpServletResponse.class);
			// 声明自己的包装类
			MyRequest request = new MyRequest(req);
			// 调用子类方法
			method.invoke(this, request, resp);
		} catch (Exception e) {
			throw new RuntimeException("没有此方法" + e.getMessage(), e);
		}
	}

	/**
	 * 默认用户必须要书写exeucte方法
	 */
	public abstract void execute(HttpServletRequest req,
			HttpServletResponse resp) throws Exception;
}

// 对HttpServletRequest进行包装
class MyRequest extends HttpServletRequestWrapper {
	public MyRequest(HttpServletRequest request) {
		super(request);
	}

	// 修改增强getparamter方法
	@Override
	public String getParameter(String name) {
		// 先获取参数的值
		String value = super.getParameter(name);
		// 是否是get方法
		if (super.getMethod().equalsIgnoreCase("GET")) {
			System.err.println("这是GET....");
			try {
				value = new String(value.getBytes("ISO-8859-1"),
						getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name); // 先从父类中获取所有的值
		// 判断是否是GET
		if (getMethod().equalsIgnoreCase("GET")) {
			for (int i = 0; i < values.length; i++) {
				try {
					values[i] = new String(values[i].getBytes("ISO-8859-1"),
							getCharacterEncoding());
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return values;
	}

	@Override
	public Map getParameterMap() {
		Map<String, String[]> map = super.getParameterMap();// 从父类中获取参数
		// 是否是GET
		if (getMethod().equalsIgnoreCase("GET")) {
			Iterator<Map.Entry<String, String[]>> it = map.entrySet()
					.iterator();
			try {
				while (it.hasNext()) {
					String[] values = it.next().getValue();
					for (int i = 0; i < values.length; i++) {
						values[i] = new String(
								values[i].getBytes("ISO-8859-1"),
								getCharacterEncoding());
					}
				}
			} catch (Exception e) {

			}
		}
		return map;
	}
}
