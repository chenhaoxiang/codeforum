package cn.hncu.utils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * @author 陈浩翔
 * 2016-12-27
 */
public class DataSourceUtils {
	private static Logger log = Logger.getLogger(DataSourceUtils.class);
	private static DataSource ds;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	static{
		try{
			ds = new ComboPooledDataSource("mySql");
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	public static DataSource getDataSource(){
		return ds;
	}
	public static Connection getConnection(){
		Connection con = tl.get();
		if(con==null){
			try {
				con = ds.getConnection();
				log.info("没有连接对象，返回一个新的...");
			} catch (SQLException e) {
				throw new RuntimeException("获取连接时出错"+e.getMessage(),e);
			}
			tl.set(con);
		}
		return con;
	}
	public static void remove(){
		tl.remove();
	}
}
