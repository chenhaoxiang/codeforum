package cn.hncu.user.dao;

import cn.hncu.domain.User;

public interface IUserDao {
	public Integer reg(User user);
	public Integer val(String name);
	public User login(String name,String pwd);
	public void saveIp(String name,String ip);
}
