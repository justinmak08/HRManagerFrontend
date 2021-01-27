package com.southwind.service;

import com.southwind.entity.Teams;
import com.southwind.entity.TeamsVO;

public interface TeamsService {
    public Integer save(Teams teams);
    public void deleteById(String id);
    public Teams findById(String id);
    public Integer update(Teams teams);
    public TeamsVO findByPage(Integer page);
}
