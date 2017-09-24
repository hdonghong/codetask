package person.dh.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import person.dh.dao.ApplicantDao;
import person.dh.domain.Applicant;
import person.dh.mapper.ApplicantMapper;

public class ApplicantDaoImpl implements ApplicantDao {
	private DataSource dataSource;
	private JdbcTemplate template;
	
	public void setDataSource(DataSource ds) { //TODO 不明白这个方法是如何自动调用的
		dataSource = ds;
		this.template = new JdbcTemplate(dataSource);
	}

	public void add(Applicant applicant) {
		String sql = "insert into applicant (id, name, qq) values (?, ?, ?)";
		template.update(sql, applicant.getId(), applicant.getName(), applicant.getQq());
		System.out.println("insert a record: id="+applicant.getId());
	}

	public Applicant getApplicant(Integer id) {
		String sql = "select id, name, qq from applicant where id=? limit 1";
		List<Applicant> query = template.query(sql, new ApplicantMapper(), id);
		System.out.println("select a record: id="+query.get(0).getId());
		return query.get(0);
	}

	public void update(Applicant applicant) {
		String sql = "update applicant set name=?, qq=? where id=? ";
		template.update(sql, applicant.getName(), applicant.getQq(), applicant.getId());
		System.out.println("update a record: id="+applicant.getId()+
				" name="+applicant.getName()+" qq="+applicant.getQq());
	}

	public void delete(int id) {
		String sql = "delete from applicant where id=? ";
		template.update(sql, id);
		System.out.println("delete a record: id="+id);
	}


}
