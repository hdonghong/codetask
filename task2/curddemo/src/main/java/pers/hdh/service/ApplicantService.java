package pers.hdh.service;


import org.springframework.stereotype.Service;
import pers.hdh.bean.Applicant;

import java.util.List;

@Service
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
	 * select all applicants
	 * @return
	 */
	List<Applicant> getApplicants();
	/**
	 * update a record
	 * @return
	 */
	void update(Applicant applicant);
	/**
	 * delete a record
	 */
	void delete(Integer id);
}
