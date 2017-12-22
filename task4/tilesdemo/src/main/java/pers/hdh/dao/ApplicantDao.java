package pers.hdh.dao;

import org.apache.ibatis.annotations.Param;
import pers.hdh.model.Applicant;

import java.util.List;

/**
 * 学员的持久层
 * @author Chandler
 */
public interface ApplicantDao {

    /**
     * 查询applicant表部分记录
     * @param offset 从第几条记录开始查询
     * @param limit 限制查询多少条记录
     * @return 所有记录封装成的List
     */
    List<Applicant> findAll(@Param("offset") int offset, @Param("limit") int limit);
}
