package com.southwind.service;

import com.southwind.entity.Projects;
import com.southwind.entity.ProjectsVO;

public interface ProjectsService {
    public ProjectsVO findByPage(Integer page);
    public Integer save(Projects projects);
    public void deleteById(String id);
    public Projects findById(String id);
    public Integer update(Projects projects);
}
