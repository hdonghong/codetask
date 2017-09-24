package person.dh.service;

import person.dh.domain.Applicant;

public interface ApplicantService {
	/**
	 * insert a new record
	 * @param applicant
	 */
	void add(Applicant applicant);
	/**
	 * select and get a record by id
	 * @param id
	 * @return 
	 */
	Applicant getApplicant(Integer id);
	/**
	 * update a record
	 * @return
	 */
	void update(Applicant applicant);
	/**
	 * delete a record
	 */
	void delete(Applicant applicant);
}
