package cn.hncu.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.hncu.utils.DataSourceUtils;

public class TestConn {
	@Test
	public void test() throws Exception{
		for(int i=0;i<20;i++){
			final int a=i;
			new Thread(){
				public void run() {
					Connection con = DataSourceUtils.getConnection();
					System.err.println(a+":"+con);
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				};
			}.start();
		}
		System.in.read();
	}
}
