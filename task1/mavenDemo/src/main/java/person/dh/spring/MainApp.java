package person.dh.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		//加载数据源文件
		ApplicationContext context = new ClassPathXmlApplicationContext("application-beans.xml");
		//创建dao实例
		ApplicantDao dao = (ApplicantDao) context.getBean("applicantDaoImple");
		
		//插入数据
		//dao.create("小红", "110");
		//dao.create("小明", "120");
		//dao.create("小刚", "119");
		
		//获取数据
//		List<Applicant> applicants = dao.listApplicants();
//		for (Applicant applicant : applicants) {
//			System.out.println("id="+applicant.getId() + "\t name="+applicant.getName()
//						+"\t qq="+applicant.getQq());
//		}
		
		for (int i = 0; i < 18; i++) {
			dao.copyTable();
		}
	}
}
