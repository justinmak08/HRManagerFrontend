package com.southwind.service.impl;

import com.southwind.entity.Teams;
import com.southwind.entity.TeamsVO;
import com.southwind.repository.TeamsRepository;
import com.southwind.service.TeamsService;
import com.southwind.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TeamsServiceImpl implements TeamsService {
    @Autowired
    private TeamsRepository teamsRepository;
    private Integer limit = 10;

    @Override
    public TeamsVO findByPage(Integer page) {
        Integer index = (page-1)*limit;
        TeamsVO employeeVO = new TeamsVO();
        employeeVO.setData(teamsRepository.find(index,limit));
        employeeVO.setTotal(teamsRepository.count());
        employeeVO.setPageSize(limit);
        return employeeVO;
    }

    @Override
    public Integer save(Teams teams) {
        String teamId = UUIDGenerator.getId();
        teams.setId(teamId);
        return teamsRepository.save(teams);
    }

    @Override
    public void deleteById(String id) {
        teamsRepository.deleteById(id);
    }

    @Override
    public Teams findById(String id) {
        return teamsRepository.findById(id);
    }

    @Override
    public Integer update(Teams teams) {
        return teamsRepository.update(teams);
    }
}
