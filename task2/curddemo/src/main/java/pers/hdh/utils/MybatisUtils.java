package pers.hdh.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 操作DB的工具类
 */
public class MybatisUtils {
	/**
	 * 打开一个数据库会话并返回
	 * @return
	 */
	public static SqlSession openSession() {
		Reader reader = null;
		try {
		//通过配置文件获取数据库连接信息
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//通过配置文件信息构建一个SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		//通过SqlSessionFactory打开一个数据库会话
		SqlSession session = factory.openSession();
		return session;
	}
	
	/**
	 * 提交事务并关闭会话
	 * @param session
	 */
	public static void commitAndClose(SqlSession session) {
		if (session != null) {
			session.commit();
			session.close();
		}
	}
	
	/**
	 * 事务回滚并关闭会话
	 * @param session
	 */
	public static void rollbackAndClose(SqlSession session) {
		if (session != null) {
			session.rollback();
			session.close();
		}
	}
}
