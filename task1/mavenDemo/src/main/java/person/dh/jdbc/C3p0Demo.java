package person.dh.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Demo {
	public static void main(String[] args) throws SQLException {
		//1.创建一个数据库连接池
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		//2.从池中获取连接
		Connection conn = ds.getConnection();
		
	}
}
