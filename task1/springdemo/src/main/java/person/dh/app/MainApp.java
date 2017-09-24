package person.dh.app;


import person.dh.domain.Applicant;
import person.dh.service.ApplicantService;
import person.dh.service.impl.ApplicantServiceImpl;

/**
 * 表示层的测试类
 */
public class MainApp {
	public static void main(String[] args) {
		//创建service执行业务逻辑
		ApplicantService service = new ApplicantServiceImpl();
		
		//创建一个applicant实例
		Applicant applicant = new Applicant(3333, "springdemo", "3333");
		
		try {
			//插入数据
			service.add(applicant);
			//查询数据
			applicant = service.getApplicant(applicant.getId());
			//更新数据
			service.update(applicant);
			//删除数据
			service.delete(applicant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
