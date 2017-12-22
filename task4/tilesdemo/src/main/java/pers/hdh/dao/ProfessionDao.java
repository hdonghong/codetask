package pers.hdh.dao;


import org.apache.ibatis.annotations.Param;
import pers.hdh.model.Profession;

import java.util.List;

public interface ProfessionDao {

    List<Profession> findAll(@Param("offset") int offset, @Param("limit") int limit);
}
