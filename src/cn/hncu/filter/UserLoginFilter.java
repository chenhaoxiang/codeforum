package cn.hncu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/**
 * 用户登录拦截器
 * @author 陈浩翔
 * 2016-12-27
 */
public class UserLoginFilter implements Filter{
	private Logger log = Logger.getLogger(UserLoginFilter.class);
	private FilterConfig conf;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.conf=filterConfig;
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//验证用户是否已经登录
		HttpServletRequest req = (HttpServletRequest) request;

		//评论时：
		if(req.getParameter("cmd")!=null&&req.getParameter("cmd").equals("comment")&&req.getSession().getAttribute("user")==null){
			String loginPath = conf.getInitParameter("loginPage");
			log.info("未登录时想评论被拦截！");
			//返回到登录页面
//			HttpServletResponse resp = (HttpServletResponse) response;
//			resp.sendRedirect(loginPath);
			String nativeInfoId = req.getParameter("infoId");
			req.getSession().setAttribute("nativeInfoId", nativeInfoId);
//			req.getRequestDispatcher(loginPath).forward(request, response);//转发
			response.getWriter().print("0");
			
		}else{
			chain.doFilter(request, response);//放行
		}
	}
	public void destroy() {
		
	}
}
