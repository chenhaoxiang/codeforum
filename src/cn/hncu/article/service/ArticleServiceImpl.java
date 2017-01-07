package cn.hncu.article.service;

import java.util.Map;

import cn.hncu.article.dao.ArticleDaoJdbc;
import cn.hncu.article.dao.IArticleDao;
import cn.hncu.domain.InfoAndReply;

public class ArticleServiceImpl implements IArticleService {
	// 声明dao
	private IArticleDao dao = new ArticleDaoJdbc();

	public InfoAndReply findArticle(String id) {
		return dao.findArticle(id);
	}

	public void readNumAdd(String id) {
		dao.readNumAdd(id);
	}

	public Map<String, Object> findReplys(String id, Integer iPageNo) {
		return dao.findReplys(id, iPageNo);
	}

	public void reply(String infoId, String userId, String message, String ip) throws Exception{
		dao.reply(infoId, userId, message, ip);
	}
}
