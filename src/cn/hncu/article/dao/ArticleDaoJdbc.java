package cn.hncu.article.dao;

import static cn.hncu.utils.DataSourceUtils.getConnection;
import static cn.hncu.utils.DataSourceUtils.getDataSource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;

import cn.hncu.domain.InfoAndReply;
import cn.hncu.utils.IDUtils;
import cn.hncu.utils.QueryRunner;

public class ArticleDaoJdbc implements IArticleDao {
	private Logger log = Logger.getLogger(ArticleDaoJdbc.class);
	private final Integer pageSize = 5;

	/**
	 * 实现查询帖子
	 */
	public InfoAndReply findArticle(String id) {
		// 先查找出帖子
		String sql = "SELECT id,title,readNum,TIME,message,NAME FROM infotable LEFT JOIN (SELECT id AS usersId,NAME FROM usertable) AS userstable ON infoTable.userId=userstable.usersId WHERE id=?";
		QueryRunner run = new QueryRunner(getDataSource());
		InfoAndReply info = run.query(sql, new BeanHandler(InfoAndReply.class),
				id);
		log.info("帖子信息为：" + info);
		return info;
	}

	/**
	 * 增加1个阅读量
	 */
	public void readNumAdd(String id) {
		// 先找出原来的阅读量
		String sql = "select readNum from infotable where id=?";
		QueryRunner run = new QueryRunner(getDataSource());
		InfoAndReply info = run.query(sql, new BeanHandler(InfoAndReply.class),
				id);
		long readNum = info.getReadNum() + 1;
		sql = "update infotable set readNum =? where id=?";
		log.info("id:" + id + ",readNum" + readNum);
		run.update(sql, readNum, id);
	}

	/**
	 * 查找5个评论
	 */
	public Map<String, Object> findReplys(String id, Integer iPageNo) {

		Map<String, Object> result = new HashMap<String, Object>();
		// 获取总页数 pageCount = rows/pageSize + ((rows%pageSize==0)?0:1)
		// 总行数 rows
		String sql = "SELECT COUNT(1) FROM replytable WHERE infoid = ?";
		QueryRunner run = new QueryRunner(getDataSource());
		// 总共的数据量
		int rows = Integer.parseInt(""
				+ run.query(sql, new ScalarHandler(), id));

		// 总页数
		int pageCount = rows / pageSize + ((rows % pageSize == 0) ? 0 : 1);
		log.info("id为:" + id + ",的总页数为:" + pageCount);
		result.put("pageCount", pageCount);

		// 分页后的当前页面内容datas
		// 起始行号
		int startN = (iPageNo - 1) * pageSize;
		sql = "SELECT TIME,message,ip,NAME,integral FROM (SELECT * FROM replytable WHERE infoid = ?) AS replytable2 LEFT JOIN (SELECT id AS usersId,NAME,integral FROM Usertable) AS userstable ON replytable2.userId=userstable.usersId ORDER BY replytable2.time DESC LIMIT "
				+ startN + " , " + pageSize;
		List<Map<String, Object>> datas = run.query(sql, new MapListHandler(),
				id);

		Integer i = 0;
		for (Map<String, Object> map : datas) {
			datas.get(i).put("time",
					IDUtils.timeToString((Long) map.get("time")));
			i++;
		}

		result.put("datas", datas);// 封装到result
		return result;
	}

	public void reply(String infoId, String userId, String message, String ip) throws Exception{
		String id = IDUtils.uuid();
		long time = new Date().getTime();
		String sql = "insert  into `replytable`(`id`,`TIME`,`message`,`infoid`,`ip`,`userid`) values (?,?,?,?,?,?);";
		QueryRunner run = new QueryRunner();
		log.info("插入一个评论:" + "id=" + id + ",message:"+ message );
		run.update(getConnection(),sql, id, time, message, infoId, ip, userId);//getConnection()为同一个，因为开启事务的需要

		// 先找出原来的阅读量
		sql = "select integral from usertable where id=?";
		long integral = Long.parseLong(""+run.query(getConnection(),sql, new ScalarHandler(), userId));
		integral = integral + 10;
		sql = "update usertable set integral =? where id=?";
		log.info("积分增加-id:" + id + ",integral:" + integral);
		run.update(getConnection(),sql, integral, userId);
	}

}
