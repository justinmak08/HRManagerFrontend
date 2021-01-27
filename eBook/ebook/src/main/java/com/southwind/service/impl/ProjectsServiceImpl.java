package com.southwind.service.impl;

import com.southwind.entity.Projects;
import com.southwind.entity.ProjectsVO;
import com.southwind.repository.ProjectsRepository;
import com.southwind.service.ProjectsService;
import com.southwind.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsServiceImpl implements ProjectsService {
    @Autowired
    private ProjectsRepository projectsRepository;
    private Integer limit = 10;

    @Override
    public ProjectsVO findByPage(Integer page) {
        Integer index = (page-1)*limit;
        ProjectsVO employeeVO = new ProjectsVO();
        employeeVO.setData(projectsRepository.find(index,limit));
        employeeVO.setTotal(projectsRepository.count());
        employeeVO.setPageSize(limit);
        return employeeVO;
    }

    @Override
    public Integer save(Projects projects) {
        String projectId = UUIDGenerator.getId();
        projects.setId(projectId);
        return projectsRepository.save(projects);
    }

    @Override
    public void deleteById(String id) {
        projectsRepository.deleteById(id);
    }

    @Override
    public Projects findById(String id) {
        return projectsRepository.findById(id);
    }

    @Override
    public Integer update(Projects projects) {
        return projectsRepository.update(projects);
    }
}
