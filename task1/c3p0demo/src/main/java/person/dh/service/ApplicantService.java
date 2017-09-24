package person.dh.service;

import java.sql.SQLException;

import person.dh.domain.Applicant;

public interface ApplicantService {
	/**
	 * insert a new record
	 * @param applicant
	 */
	int add(Applicant applicant) throws SQLException ;
	/**
	 * select and get a record by id
	 * @param id
	 * @return 
	 */
	Applicant getApplicant(Integer id) throws SQLException ;
	/**
	 * update a record
	 * @return
	 */
	int update(Applicant applicant) throws SQLException ;
	/**
	 * delete a record
	 */
	int delete(Applicant applicant) throws SQLException ;
}
