package pers.hdh.dao;


import org.apache.ibatis.annotations.Param;
import pers.hdh.model.Profession;

import java.util.List;

public interface ProfessionDao {

    List<Profession> findAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过主键id查询profession数据库中一记录
     * @param id
     * @return
     */
    Profession getById(@Param("id") Long id);
}
