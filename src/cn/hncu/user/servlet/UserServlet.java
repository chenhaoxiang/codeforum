package cn.hncu.user.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.hncu.domain.User;
import cn.hncu.user.service.IUserService;
import cn.hncu.user.service.UserServiceImpl;
import cn.hncu.utils.BaseServlet;
import cn.hncu.utils.BeanUtils;

/**
 * 用户登录注册模块
 * 
 * @author 陈浩翔 2016-12-27
 */
public class UserServlet extends BaseServlet {
	private Logger log = Logger.getLogger(UserServlet.class);
	private static final long serialVersionUID = 1L;
	// 声明
	private IUserService service = new UserServiceImpl();

	// 默认转到注册页面
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String path = getInitParameter("reg");
		req.getRequestDispatcher(path).forward(req, resp);//转发
	}

	/**
	 * 用户注册功能
	 */
	public void reg(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		System.out.println("进入注册...");
		User user = BeanUtils.populate(User.class, req.getParameterMap());
		user.setIp(req.getRemoteAddr());
		user.setType("0");
		user.setIntegral(10);
		log.debug("用户注册信息为：" + user.toString() + "----即将进入service模块");
		PrintWriter out = resp.getWriter();
		if (service.reg(user) == 1) {
			out.print("1");
		} else {
			out.print("0");
		}

	}

	/**
	 * 验证用户名是否存在
	 */
	public void val(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String name = req.getParameter("name");// 接收用户名
		log.debug("接收到用户名:" + name);
		PrintWriter out = resp.getWriter();
		int msg = service.val(name);
		if (msg == 1) {
			out.print("userNameRepeat");
		} else {
			out.print("userNameOk");// 用户名可以用
		}
	}

	/**
	 * 用户登录功能
	 */
	public void log(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String result = "0";// 返回值
		String name = req.getParameter("name");// 接收用户名
		String password = req.getParameter("password");//接收密码
		User user = service.login(name,password);
		log.info("返回的user是：" + user);
		
		if (user == null) { // 登录不成功
			result = "-1";
		} else {// 登录成功
			result = "0";
			// 将用户信息放到session中
			req.getSession().setAttribute("user", user);
			//存储用户的ip---新开一个线程来存储
			String ip = req.getRemoteAddr();
			new IPThread(user.getName(),ip).start();
			String nativeInfoId = (String) req.getSession().getAttribute("nativeInfoId");
			if(nativeInfoId!=null&&!nativeInfoId.equals("")){
				req.getSession().setAttribute("nativeInfoId", null);
				result = nativeInfoId;//登录成功，且返回原来的帖子页面
			}
//			String articlePath = getInitParameter("article");
//			resp.sendRedirect(articlePath+"?infoId="+nativeInfoId);//重定向
		}
		PrintWriter out = resp.getWriter();
		out.print(result);
	}
	
	/**
	 * 用户退出功能
	 */
	public void out(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		req.getSession().setAttribute("user", null);
		String path = getInitParameter("index");
		resp.sendRedirect(path);//重定向
	}
}
