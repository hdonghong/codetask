package pers.hdh.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.dao.ProfessionDao;
import pers.hdh.model.Profession;
import pers.hdh.service.ProfessionService;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProfessionDao professionDao;

    @Override
    public List<Profession> findAll(int offset, int limit) {
        return professionDao.findAll(offset, limit);
    }
}
