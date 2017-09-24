package person.dh.service.impl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import person.dh.dao.ApplicantDao;
import person.dh.domain.Applicant;
import person.dh.service.ApplicantService;

public class ApplicantServiceImpl implements ApplicantService {

	public void add(Applicant applicant) {
		//加载数据源
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-beans.xml");
		//获取dao的实例
		ApplicantDao dao = (ApplicantDao) context.getBean("applicantDaoImpl");
		//调用方法
		dao.add(applicant);
		//关闭容器
		context.close();
	}

	public Applicant getApplicant(Integer id) {
		//加载数据源
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-beans.xml");
		//获取dao的实例
		ApplicantDao dao = (ApplicantDao) context.getBean("applicantDaoImpl");
		//调用方法
		Applicant applicant = dao.getApplicant(id);
		//关闭容器
		context.close();
		return applicant;
	}

	public void update(Applicant applicant) {
		//加载数据源
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-beans.xml");
		//获取dao的实例
		ApplicantDao dao = (ApplicantDao) context.getBean("applicantDaoImpl");
		//调用方法
		dao.update(applicant);
		//关闭容器
		context.close();
	}

	public void delete(Applicant applicant) {
		//加载数据源
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-beans.xml");
		//获取dao的实例
		ApplicantDao dao = (ApplicantDao) context.getBean("applicantDaoImpl");
		//调用方法
		dao.delete(applicant.getId());
		//关闭容器
		context.close();
	}

}
