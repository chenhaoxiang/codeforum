package cn.hncu.user.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;

import cn.hncu.domain.User;
import cn.hncu.user.servlet.UserServlet;
import cn.hncu.utils.IDUtils;
import cn.hncu.utils.PasswordUtils;
import cn.hncu.utils.QueryRunner;
import static cn.hncu.utils.DataSourceUtils.*;

public class UserDaoJdbc implements IUserDao{
	private Logger log = Logger.getLogger(UserDaoJdbc.class);
	
	/**
	 * 实现用户注册
	 */
	public Integer reg(User user) {
		String sql = "insert into userTable(id,name,sex,age,profession,love,password,ip,integral,type,solt) values(?,?,?,?,?,?,?,?,?,?,?)";
		user.setId(IDUtils.uuid());
		user.setSolt(PasswordUtils.getSolt());
		user.setPassword(PasswordUtils.md5(user.getPassword().trim(), user.getSolt().trim()));
		log.debug("此时user的数据为:"+user);
		//声明Runner
		QueryRunner run = new QueryRunner(getDataSource());
		Object obj = run.update(sql,user.getId(),user.getName().trim(),user.getSex().trim(),user.getAge().trim(),user.getProfession().trim()
				,user.getLove().trim(),user.getPassword().trim(),user.getIp().trim(),user.getIntegral(),user.getType().trim(),user.getSolt().trim());
		log.info("用户注册后，数据库的返回信息:"+obj);
		return Integer.parseInt(""+obj);
	}
	
	/**
	 * 用户名是否存在
	 */
	public Integer val(String name){
		//查询是否拥有此用户名
		String sql = "select count(1) from userTable where name=?";
		QueryRunner run = new QueryRunner(getDataSource());
		Object obj = run.query(sql,new ScalarHandler(),name);//一行一列
		log.info("查询数据库用户名是否存在返回:"+obj);
		return Integer.parseInt(""+obj);
	}
	
	/**
	 * 用户登录功能
	 */
	public User login(String name,String pwd){
		//根据用户名查询出用户
		String sql = "select * from userTable where name=?";
		QueryRunner run = new QueryRunner(getDataSource());
		User user = run.query(sql,new BeanHandler<User>(User.class),name);
		//获得盐
		if(user==null){
			return null;
		}
		String solt = user.getSolt();
		String userPwd = PasswordUtils.md5(pwd, solt);
		if(userPwd.equals(user.getPassword())){//对密码加密后比较
			return user;
		}else{
			return null;
		}
	}
	
	public void saveIp(String name, String ip) {
		String sql = "update userTable set ip =? where name=?";
		log.info("修改"+name+"的ip为："+ip);
		QueryRunner run = new QueryRunner(getDataSource());
		run.update(sql, ip,name);
	}
	
}
