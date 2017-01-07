package cn.hncu.publish.servlet;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.domain.Info;
import cn.hncu.publish.service.IPublishService;
import cn.hncu.publish.service.PublishServiceImpl;
import cn.hncu.utils.BaseServlet;
import cn.hncu.utils.IDUtils;
import cn.hncu.utils.tx.TxProxy;
/**
 * 用户发表文章的servlet
 * @author 陈浩翔
 *
 * 2017-1-7
 */
public class PublishServlet extends BaseServlet{
	private IPublishService service = TxProxy.getProxy(new PublishServiceImpl()); //事务处理
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		PrintWriter out= resp.getWriter();
		try {
			String userId = req.getParameter("userId");
			String title = req.getParameter("title");
			String message = req.getParameter("message");
			
			if(userId==null||title==null||message==null){
				out.print(0);//出错
				return ;
			}
			
			Info info = new Info();
			info.setId(IDUtils.uuid());
			info.setMessage(message);
			info.setReadNum(0);
			info.setTime(new Date().getTime());
			info.setTitle(title);
			info.setUserId(userId);
			
			String infoId = service.publish(info);
			if(infoId==null){
				out.print(0);
			}else{
				out.print(infoId);
			}
		} catch (Exception e) {
			out.print(0);
			e.printStackTrace();
		}
		
	}

}
