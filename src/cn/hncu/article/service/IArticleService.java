package cn.hncu.article.service;

import java.util.Map;

import cn.hncu.domain.InfoAndReply;
import cn.hncu.utils.tx.Transaction;

public interface IArticleService {
	/**
	 * 查找出帖子信息
	 * @param id
	 * @return
	 */
	public InfoAndReply findArticle(String id);
	/**
	 * 阅读量+1
	 * @param id
	 */
	public void readNumAdd(String id);
	/**
	 * 分页返回帖子的评论
	 * @param id
	 * @param iPageNo
	 * @return
	 */
	public Map<String, Object> findReplys(String id, Integer iPageNo);
	/**
	 * 用户评论帖子
	 * @param infoId
	 * @param userId
	 * @param message
	 * @param ip
	 * @throws Exception 
	 */
	@Transaction
	public void reply(String infoId, String userId, String message,String ip) throws Exception;
}
