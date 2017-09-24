package person.dh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo {
	/**
	 * 使用jdbc连接数据库
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//1.加载驱动，即将Driver类加载入内存中
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.获取数据库连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "toor");
		
		//3.通过连接获取预编译对象
		PreparedStatement st = conn.prepareStatement("select * from applicant where id = ? limit 1");
		
		//4.设置参数(第几个问号, 值)
		st.setInt(1, 2);
		
		//5.执行sql 返回值：结果集
		ResultSet query = st.executeQuery();
		
		//6.检验结果
		while (query.next()) {
			System.out.println("id="+query.getString("id")+"  name="+query.getString("name"));
		}
		
		//7.关闭资源(先开启的后关闭)
		query.close();
		st.close();
		conn.close();
	}
}
