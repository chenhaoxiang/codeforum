package cn.hncu.user.service;
import cn.hncu.domain.User;
import cn.hncu.user.dao.IUserDao;
import cn.hncu.user.dao.UserDaoJdbc;

public class UserServiceImpl implements IUserService{
	//声明dao
	private IUserDao dao = new UserDaoJdbc();
	public Integer reg(User u) {
		return dao.reg(u);
	}
	public Integer val(String name){
		return dao.val(name);
	}
	public User login(String name,String pwd){
		return dao.login(name,pwd);
	}
	public void saveIp(String name,String ip){
		dao.saveIp(name, ip);
	}
}
