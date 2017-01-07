package cn.hncu.index.dao;

import static cn.hncu.utils.DataSourceUtils.getDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;

import cn.hncu.domain.InfoMod;
import cn.hncu.utils.QueryRunner;

public class IndexDaoJdbc implements IIndexDao {
	
	private Logger log = Logger.getLogger(IndexDaoJdbc.class);
	private final Integer pageSize = 5;// 每页显示

	/**
	 * 返回5篇热门帖子
	 */
	public List<InfoMod> hot() {
		String sql = "SELECT id,title,readNum,NAME FROM infoTable LEFT JOIN (SELECT id AS usersId,NAME FROM usertable) AS userstable ON infoTable.userId=userstable.usersId ORDER BY infoTable.readNum DESC LIMIT 5";// 降序
		QueryRunner run = new QueryRunner(getDataSource());
		List<InfoMod> infos = run.query(sql, new BeanListHandler<InfoMod>(
				InfoMod.class));
		return infos;
	}

	/**
	 * 返回所有帖子
	 */
	public Map<String, Object> all(Integer iPageNo) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 获取总页数 pageCount = rows/pageSize + ((rows%pageSize==0)?0:1)
		// 总行数 rows
		String sql = "select count(1) from infoTable";
		QueryRunner run = new QueryRunner(getDataSource());
		int rows = Integer.parseInt("" + run.query(sql, new ScalarHandler()));
		// 总页数
		int pageCount = rows / pageSize + ((rows % pageSize == 0) ? 0 : 1);
		log.info("所有帖子的总页数为:"+pageCount);
		result.put("pageCount", pageCount);
		
		// 分页后的当前页面内容datas
		// 起始行号
		int startN = (iPageNo - 1) * pageSize;
		sql = "SELECT id,title,readNum,NAME FROM infoTable LEFT JOIN (SELECT id AS usersId,NAME FROM Usertable) AS userstable ON infoTable.userId=userstable.usersId ORDER BY infoTable.time desc limit "
				+ startN + " , " + pageSize;
		List<Map<String, Object>> datas = run.query(sql, new MapListHandler());
		result.put("datas", datas);// 封装到result

		return result;
	}
}
