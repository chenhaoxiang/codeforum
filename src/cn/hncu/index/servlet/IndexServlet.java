package cn.hncu.index.servlet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.hncu.domain.InfoMod;
import cn.hncu.index.service.IIndexService;
import cn.hncu.index.service.IndexServiceImpl;
import cn.hncu.utils.BaseServlet;
/**
 * 主页模块
 * @author 陈浩翔
 * 2016-12-27
 */
public class IndexServlet extends BaseServlet {
	private Logger log = Logger.getLogger(IndexServlet.class);
	private static final long serialVersionUID = 1L;
	//声明
	private IIndexService service = new IndexServiceImpl();
	//默认
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		try {
			String pageNo = req.getParameter("page");
			if(pageNo==null || pageNo.trim().length()<=0){
			     pageNo="1";
			 }
			Integer iPageNo=1;
			try {
				iPageNo = Integer.parseInt(pageNo);
			} catch (NumberFormatException e) {
			    iPageNo=1;
			}
			//查询5个热门帖子
			List<InfoMod> infoHots = service.hot();
			
			//分页查询
			Map<String, Object> infoAlls = service.all(iPageNo);
			//给结果集补一个数据:currentPage-现在的页码
			infoAlls.put("currentPage", iPageNo);
			
			//将热门帖子信息放到session中
			req.getSession().setAttribute("infoHots",infoHots);
			//将所有帖子信息放到session中
			req.getSession().setAttribute("infoAlls",infoAlls);
			
			String path = getInitParameter("index");
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (Exception e) {
			String path = getInitParameter("index");
			req.getRequestDispatcher(path).forward(req, resp);
			e.printStackTrace();
		}
	}
}
