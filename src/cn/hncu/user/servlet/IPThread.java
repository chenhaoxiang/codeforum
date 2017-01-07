package cn.hncu.user.servlet;

import cn.hncu.user.service.UserServiceImpl;

public class IPThread extends Thread{
	private String name =null;
	private String ip = null;
	
	public IPThread() {
	}

	public IPThread(String name, String ip) {
		this.name=name;
		this.ip=ip;
	}

	@Override
	public void run() {
		new UserServiceImpl().saveIp(name, ip);
	}
}
