package pers.hdh.service;

import pers.hdh.model.Profession;

import java.util.List;

public interface ProfessionService {

    List<Profession> findAll(int offset, int limit);
}
