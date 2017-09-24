package person.dh.service.impl;

import java.sql.SQLException;

import person.dh.dao.ApplicantDao;
import person.dh.dao.impl.ApplicantDaoImpl;
import person.dh.domain.Applicant;
import person.dh.service.ApplicantService;

public class ApplicantServiceImpl implements ApplicantService {

	/**
	 * 增
	 * @throws SQLException 
	 */
	public int add(Applicant applicant) throws SQLException {
		ApplicantDao dao = new ApplicantDaoImpl();
		return applicant==null?
				0 : dao.add(applicant);
	}
	/**
	 * 查
	 * @throws SQLException 
	 */
	public Applicant getApplicant(Integer id) throws SQLException {
		ApplicantDao dao = new ApplicantDaoImpl();
		return id==null?
				null : dao.getApplicant(id);
	}
	/**
	 * 改
	 * @throws SQLException 
	 */
	public int update(Applicant applicant) throws SQLException {
		ApplicantDao dao = new ApplicantDaoImpl();
		return applicant==null? 
				0 : dao.update(applicant);
	}
	/**
	 * 删
	 * @throws SQLException 
	 */
	public int delete(Applicant applicant) throws SQLException {
		ApplicantDao dao = new ApplicantDaoImpl();
		return applicant==null?
				0 : dao.delete(applicant.getId());
	}

}
