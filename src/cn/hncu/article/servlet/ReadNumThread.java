package cn.hncu.article.servlet;

import cn.hncu.article.service.ArticleServiceImpl;

/**
 * 阅读量+1
 * @author 陈浩翔
 *
 * 2017-1-5
 */
public class ReadNumThread extends Thread{
	private String id =null;
	public ReadNumThread() {
	}
	public ReadNumThread(String id) {
		this.id=id;
	}
	@Override
	public void run() {
		new ArticleServiceImpl().readNumAdd(id);
	}
}
