package cn.hncu.domain;


/**
 * 在单个帖子的时候需要---添加了正文和时间
 * @author 陈浩翔
 * 2017-1-5
 */
public class InfoAndReply {
	private String id;
	private String title; //标题
	private long readNum; //阅读量
	private long time; //发表时间
	private String message;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "InfoAndReply [title=" + title + ", readNum=" + readNum
				+ ", time=" + time + ", message=" + message + ", name="
				+ name + "]";
	}
	
}
