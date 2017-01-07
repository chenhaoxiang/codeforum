package cn.hncu.domain;

import cn.hncu.utils.BaseDomain;
/**
 * 首页进行查询时需要
 * @author 陈浩翔
 *
 * 2016-12-27
 */
public class InfoMod extends BaseDomain{
	private String title;
	private long readNum;
	private String name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "InfoMod [title=" + title + ", readNum=" + readNum 
				+ ", name=" + name + ", getId()="
				+ getId() + "]";
	}
	
}
