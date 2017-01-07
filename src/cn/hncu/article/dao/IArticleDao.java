package cn.hncu.article.dao;

import java.util.Map;

import cn.hncu.domain.InfoAndReply;
import cn.hncu.domain.User;

public interface IArticleDao {
	public InfoAndReply findArticle(String id);
	public void readNumAdd(String id);
	public Map<String, Object> findReplys(String id, Integer iPageNo);
	public void reply(String infoId, String userId, String message,String ip) throws Exception;
}
