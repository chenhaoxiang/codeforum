package cn.hncu.article.servlet;

import org.apache.log4j.Logger;

import cn.hncu.article.service.ArticleServiceImpl;
import cn.hncu.article.service.IArticleService;
import cn.hncu.utils.tx.TxProxy;

public class replyThread extends Thread {
	private String infoId = null;
	private String userId = null;
	private String message = null;
	private String ip = null;
	private IArticleService article = TxProxy.getProxy(new ArticleServiceImpl());//开启事务的支持---这里需要用同一个Connection
	private Logger log = Logger.getLogger(replyThread.class);

	public replyThread() {
	}

	public replyThread(String infoId, String userId, String message, String ip) {
		this.infoId = infoId;
		this.userId = userId;
		this.message = message;
		this.ip = ip;
	}

	@Override
	public void run() {
		try {
			article.reply(infoId, userId, message, ip);//这个方法上面添加了事务注解的
		} catch (Exception e) {
			log.info("出异常了，回滚事务");
			e.printStackTrace();
		}
	}
}
