package person.dh.spring;

import java.util.List;
import javax.sql.DataSource;

/**
 * Data Source Object
 */
public interface ApplicantDao {
	/**
	 * initialize database resources ie
	 * @param ds
	 */
	public void setDataSource(DataSource ds);
	/**
	 * insert a new record into the applicant table
	 * @param name
	 * @param qq
	 */
	public void create(String name, String qq);
	/**
	 * select and get a record by id
	 * @param id
	 * @return
	 */
	public Applicant getApplicant(Integer id);
	/**
	 * select and get all records from applicant table
	 * @return
	 */
	public List<Applicant> listApplicants();
	/**
	 * 复制表
	 */
	public void copyTable();
	
}
