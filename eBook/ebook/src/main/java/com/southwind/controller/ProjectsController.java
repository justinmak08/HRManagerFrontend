package com.southwind.controller;

import com.southwind.entity.Projects;
import com.southwind.entity.ProjectsVO;
import com.southwind.service.ProjectsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectsService projectsService;

    @GetMapping("/findByPage/{page}")
    @ApiOperation(("findByPage"))
    public ProjectsVO findByPage(@PathVariable("page") Integer page){
        return projectsService.findByPage(page);
    }


    @PostMapping("/save")
    @ApiOperation(("save"))
    public Integer save(@RequestBody Projects projects){
        return projectsService.save(projects);
    }

    @DeleteMapping("/deleteById/{id}")
    @ApiOperation(("deleteById"))
    public void deleteById(@PathVariable("id") String id){
        projectsService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(("findById"))
    public Projects findById(@PathVariable("id") String id){
        return projectsService.findById(id);
    }

    @PutMapping("/projectsUpdate")
    @ApiOperation(("projectsUpdate"))
    public Integer update(@RequestBody Projects projects){
        return projectsService.update(projects);
    }
}
