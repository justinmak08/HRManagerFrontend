package com.southwind.repository;

import com.southwind.entity.Teams;
import com.southwind.entity.TeamsVO;

import java.util.List;

public interface TeamsRepository {
    public Integer save(Teams teams);
    public Integer count();
    public void deleteById(String id);
    public Teams findById(String id);
    public Integer update(Teams teams);
    public List<Teams> find(Integer index, Integer limit);
}