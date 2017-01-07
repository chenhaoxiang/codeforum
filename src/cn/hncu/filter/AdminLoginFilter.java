package cn.hncu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
public class AdminLoginFilter implements Filter {
	private FilterConfig conf;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.conf = filterConfig;
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//验证在session中是否存在admin这个key
		HttpServletRequest req = (HttpServletRequest) request;
		if(req.getSession().getAttribute("admin")==null){
			String loginPage = conf.getInitParameter("loginPage");
			req.getRequestDispatcher(loginPage).forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}
	public void destroy() {
	}
}
