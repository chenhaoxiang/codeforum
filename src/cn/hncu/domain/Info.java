package cn.hncu.domain;

import cn.hncu.utils.BaseDomain;

/**
 * 帖子信息
 * @author 陈浩翔
 * 2016-12-27
 */
public class Info extends BaseDomain{
	private String title; //标题
	private long readNum; //阅读量
	private long time; //
	private String message;
	private String userId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getReadNum() {
		return readNum;
	}
	public void setReadNum(long readNum) {
		this.readNum = readNum;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Info [title=" + title + ", readNum=" + readNum + ", time="
				+ time + ", message=" + message + ", userId=" + userId
				+ ", getId()=" + getId() + "]";
	}
	
}
