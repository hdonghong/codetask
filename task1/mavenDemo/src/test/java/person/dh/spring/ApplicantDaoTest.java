package person.dh.spring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicantDaoTest {
	private static ApplicationContext context;
	private static ApplicantDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-beans.xml");
	}
	@Before
	public void setUp() throws Exception {
		dao = (ApplicantDao) context.getBean("applicantDaoImple");
	}
	@Test
	public void testListApplicants() {
		assertNotNull(dao.listApplicants());
	}
	@Test
	public void test() {
		assertNotNull(dao.listApplicants());
	}
}
