package cn.hncu.domain;

import cn.hncu.utils.BaseDomain;

/**
 * 回复信息
 * @author 陈浩翔
 *
 * 2016-12-27
 */
public class Reply extends BaseDomain{
	private long time;
	private String message;
	private String infoId;
	private String ip;
	private String userId;
	
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
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Reply [time=" + time + ", message=" + message + ", infoId="
				+ infoId + ", ip=" + ip + ", userId=" + userId + "]";
	}
	
}
