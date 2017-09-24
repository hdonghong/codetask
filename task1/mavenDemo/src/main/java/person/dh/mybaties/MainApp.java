package person.dh.mybaties;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainApp {
	public static void main(String[] args) {
		try {
			//通过配置文件获取数据库连接信息
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			//通过配置文件信息构建一个SqlSessionFactory
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			//通过SqlSessionFactory打开一个数据库会话
			SqlSession session = factory.openSession();
			//通过session获取mapper
			ApplicantDao mapper = session.getMapper(ApplicantDao.class);
			
			//插入数据
			Applicant a = new Applicant("测试mybatis", "123");
			mapper.create(a);
			
			//查询
			List<Applicant> applicants = mapper.listApplicants();
			for (Applicant applicant : applicants) {
				System.out.println("id="+applicant.getId() + "\t name="+applicant.getName()
					+"\t qq="+applicant.getQq());
			}

			//提交事务，关闭session
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
