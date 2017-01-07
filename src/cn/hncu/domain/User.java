package cn.hncu.domain;

import cn.hncu.utils.BaseDomain;

/**
 * @author 陈浩翔
 * 2016-12-27
 */
public class User extends BaseDomain{
	private String name;
	private String sex;//性别
	private String age;
	private String profession;//职业
	private String love;
	private String password;
	private String ip;
	private long integral;//积分--注册时默认为10，发帖一次+10，回复一次+2
	private String type;//用户类型-默认注册时为1：1-普通用户，0-管理员
	private String solt;//加密用的盐
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getIntegral() {
		return integral;
	}
	public void setIntegral(long integral) {
		this.integral = integral;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSolt() {
		return solt;
	}
	public void setSolt(String solt) {
		this.solt = solt;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", profession=" + profession + ", love=" + love
				+ ", password=" + password + ", ip=" + ip + ", integral="
				+ integral + ", type=" + type + ", solt=" + solt + ", getId()="
				+ getId() + "]";
	}
	
}
