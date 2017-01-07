package cn.hncu.article.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.hncu.article.service.ArticleServiceImpl;
import cn.hncu.article.service.IArticleService;
import cn.hncu.domain.InfoAndReply;
import cn.hncu.utils.BaseServlet;
import cn.hncu.utils.IDUtils;

/**
 * 文章模块---显示具体文章
 * @author 陈浩翔
 *
 * 2017-1-5
 */
public class ArticleServlet extends BaseServlet{
	private IArticleService service = new ArticleServiceImpl(); 
	private Logger log = Logger.getLogger(ArticleServlet.class);
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		try {
			String id = req.getParameter("infoId");
			
			log.info("帖子的ID："+id+","+ArticleServlet.class);
			
			//帖子-标题，正文，作者，阅读量+1,id
			InfoAndReply article = service.findArticle(id);
			long time = article.getTime();
			
			String timeStr = IDUtils.timeToString(time);
			
			req.getSession().setAttribute("articleTime", timeStr);
			req.getSession().setAttribute("article", article);
			
			new ReadNumThread(id).start();//阅读量加1
			
			String pageNo = req.getParameter("page");
			
			if(pageNo==null || pageNo.trim().length()<=0){
			     pageNo="1";
			}
			Integer iPageNo=1;
			try {
				iPageNo = Integer.parseInt(pageNo.trim());
			} catch (NumberFormatException e) {
			    iPageNo=1;
			}
			//分页查询评论
			Map<String, Object> replys = service.findReplys(id,iPageNo);
			
			//给结果集补一个数据:currentPage-现在的页码
			replys.put("currentPage", iPageNo);
			
			//将帖子评论放到session中
			req.getSession().setAttribute("replys",replys);
			
			String path = getInitParameter("article");
			req.getRequestDispatcher(path).forward(req, resp);//转发
		} catch (Exception e) {//出异常了，直接转发到首页
			String path = getInitParameter("index");
			req.getRequestDispatcher(path).forward(req, resp);//转发
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户进行评论
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public void comment(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		try {
			String infoId = req.getParameter("infoId");//获得帖子ID
			String userId = req.getParameter("userId");//获得用户ID-评论者
			String message = req.getParameter("comment");//评论的内容
			log.info("评论的内容是:"+message);
			//这里应该全部防范一下null
			if(infoId==null||userId==null||message==null){
				resp.getWriter().print("-1");
				return ;
			}
			
			String ip = req.getRemoteAddr();
			new replyThread(infoId,userId,message,ip).start();//开一个线程进行评论
		} catch (Exception e) {
			//出异常了，直接返回-1
			resp.getWriter().print("-1");
		}
		//直接返回1
		resp.getWriter().print("1");
	}
	
}
