package pers.hdh.service;

import pers.hdh.model.Applicant;

import java.util.List;

/**
 * 业务接口：站在“使用者”角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型(return 类型/异常)
 * 学员的业务逻辑层
 * @author Chandler
 */
public interface ApplicantService {

    /**
     * 查询所有学员
     * @param offset
     * @param limit
     * @return
     */
    List<Applicant> findAll(int offset, int limit);
}
