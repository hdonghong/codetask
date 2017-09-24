package person.dh.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;

import person.dh.domain.Applicant;
import person.dh.service.ApplicantService;

/**
 * 测试service实现类
 * @author Lenovo
 *
 */
public class ApplicantServiceImplTest {
	private static ApplicantService service;
	private static Applicant applicant;
	
	@BeforeClass 
	public static void setUpBeforeClass() {
		//获取service，执行业务逻辑
		service = new ApplicantServiceImpl();
		applicant = new Applicant(22, "mabatisdemo", "3333");
	}
	
	@Test
	public void testAdd() { //测试添加数据的方法
		service.add(applicant);
	}

	@Test
	public void testGetApplicant() { //测试查询数据的方法
		applicant = service.getApplicant(4);
	}

	@Test
	public void testUpdate() { //测试更新数据的方法
		applicant.setName("黄蓉");
		service.update(applicant);
	}

	@Test
	public void testDelete() { //测试删除数据的方法
		//service.delete(applicant);
	}

}
