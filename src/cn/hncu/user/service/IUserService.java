package cn.hncu.user.service;

import cn.hncu.domain.User;

public interface IUserService {
	public Integer reg(User u);
	public Integer val(String name);
	public User login(String name,String pwd);
	public void saveIp(String name,String ip);
}
