package person.dh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import person.dh.domain.Applicant;

public class ApplicantMapper implements RowMapper<Applicant> {
	/**
	 * 封装数据
	 */
	public Applicant mapRow(ResultSet rs, int rowNum) throws SQLException {
		Applicant applicant = new Applicant();
		applicant.setId(rs.getInt("id"));
		applicant.setName(rs.getString("name"));
		applicant.setQq(rs.getString("qq"));
		return applicant;
	}
}
