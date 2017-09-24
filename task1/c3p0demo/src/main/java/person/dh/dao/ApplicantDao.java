package person.dh.dao;

import java.sql.SQLException;

import person.dh.domain.Applicant;

/**
 * 数据访问层，直接访问数据库
 */
public interface ApplicantDao {
	/**
	 * insert a new record into the applicant table
	 */
	public int add(Applicant applicant) throws SQLException;
	/**
	 * select and get a record by id
	 * @param id
	 * @return
	 */
	public Applicant getApplicant(Integer id) throws SQLException;
	/**
	 * update a record
	 * @return
	 */
	public int update(Applicant applicant) throws SQLException;
	/**
	 * delete a record
	 */
	public int delete(int id) throws SQLException;
	
}
