package cn.hncu.publish.dao;

import static cn.hncu.utils.DataSourceUtils.getConnection;

import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;

import cn.hncu.domain.Info;
import cn.hncu.utils.QueryRunner;

public class PublishDaoJdbc implements IPublishDao {
	private Logger log = Logger.getLogger(PublishDaoJdbc.class);
	
	private final Integer integral = 50; //一篇新文章加50积分

	public String publish(Info info) {
		String sql = "insert into infotable(id,title,readnum,TIME,message,userid) values(?,?,?,?,?,?)";
		log.info("新文章info的数据为:"+info);
		//声明Runner
		QueryRunner run = new QueryRunner();
		run.update(getConnection(),sql,info.getId(),info.getTitle(),info.getReadNum(),
				info.getTime(),info.getMessage(),info.getUserId());
		//新增文章之后，给用户加积分
		
		sql = "select integral from usertable where id=?";
		long i = Long.parseLong(""+run.query(getConnection(),sql, new ScalarHandler(), info.getUserId()));
		i = i+integral;
		
		//修改积分
		sql =  "update usertable set integral =? where id=?";
		run.update(getConnection(),sql, i, info.getUserId());
		
		return info.getId();
	}
}
