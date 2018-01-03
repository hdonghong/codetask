package pers.hdh.service;

import pers.hdh.model.Profession;

import java.util.List;

public interface ProfessionService {

    /**
     * 查询多个用户
     * @param offset
     * @param limit
     * @return
     */
    List<Profession> findAll(int offset, int limit);

    /**
     * 通过用户id查找一个用户
     * @param id
     * @return
     */
    Profession getById(Long id);
}
