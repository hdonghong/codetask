package person.dh.app;

import person.dh.domain.Applicant;
import person.dh.service.ApplicantService;
import person.dh.service.impl.ApplicantServiceImpl;

public class MainApp {
	public static void main(String[] args) {
		//获取service，执行业务逻辑
		ApplicantService service = new ApplicantServiceImpl();
		
		//创建一个applicant实例
		Applicant applicant = new Applicant(22, "mabatisdemo", "3333");
		
		try {
			//插入数据
			service.add(applicant);
			//查询数据
			applicant = service.getApplicant(4);
			//更新数据
			applicant.setName("黄蓉");
			service.update(applicant);
			//删除数据
			service.delete(applicant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
