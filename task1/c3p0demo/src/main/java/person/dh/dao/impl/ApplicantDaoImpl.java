package person.dh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import person.dh.dao.ApplicantDao;
import person.dh.domain.Applicant;
import person.dh.utils.DataSourceUtils;

public class ApplicantDaoImpl implements ApplicantDao {

	public int add(Applicant applicant) throws SQLException {
		Connection conn = DataSourceUtils.getConnection();
		String sql = "insert into applicant (name, qq) values (?, ?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		//pst.setInt(1, 22);
		pst.setString(1, applicant.getName());
		pst.setString(2, applicant.getQq());
		int flag = pst.executeUpdate();
		DataSourceUtils.closeResource(conn, pst, null);
		return flag;
	}

	public Applicant getApplicant(Integer id) throws SQLException {
		Connection conn = DataSourceUtils.getConnection();
		String sql = "select * from applicant where id = ? limit 1";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				return new Applicant(rs.getInt("id"), rs.getString("name"), rs.getString("qq"));
			}
		}
		return null;
	}

	public int update(Applicant applicant) throws SQLException {
		Connection conn = DataSourceUtils.getConnection();
		String sql = "update applicant set name=?, qq=? where id = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, applicant.getName());
		pst.setString(2, applicant.getQq());
		pst.setInt(3, applicant.getId());
		int flag = pst.executeUpdate();
		DataSourceUtils.closeResource(conn, pst, null);
		return flag;
	}

	public int delete(int id) throws SQLException {
		Connection conn = DataSourceUtils.getConnection();
		String sql = "delete from applicant where id=? ";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		int flag = pst.executeUpdate();
		DataSourceUtils.closeResource(conn, pst, null);
		return flag;
	}

}
