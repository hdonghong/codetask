package person.dh.spring;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * dao的实现类 使用JdbcTemplate
 */
public class ApplicantDaoImple implements ApplicantDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		//创建模板类并设置数据源
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void create(String name, String qq) {
		String sql = "insert into applicant(name, qq) values (?, ?)";
		jdbcTemplateObject.update(sql, name, qq);
		System.out.println("insert a record name=" + name + " qq="+qq);
	}

	public Applicant getApplicant(Integer id) {
		String sql = "select * from applicant where id=? limit 1";
		return (Applicant) jdbcTemplateObject.query(sql, new ApplicantMapper(), id);
	}

	public List<Applicant> listApplicants() {
		String sql = "select * from applicant";
		List<Applicant> applicant = jdbcTemplateObject.query(sql, new ApplicantMapper());
		return applicant;
	}
	
	public void copyTable() {
		String sql = " insert into applicant (name, qq) select name, qq from applicant ";
		jdbcTemplateObject.update(sql);
	}
}
