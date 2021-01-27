package com.southwind.controller;

import com.southwind.entity.Employee;
import com.southwind.entity.EmployeeVO;
import com.southwind.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findByPage/{page}")
    @ApiOperation(("findByPage"))
    public EmployeeVO findByPage(@PathVariable("page") Integer page){
        return employeeService.findByPage(page);
    }

    @PostMapping("/save")
    @ApiOperation(("save"))
    public Integer save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/deleteById/{id}")
    @ApiOperation(("deleteById"))
    public void deleteById(@PathVariable("id") String id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(("findById"))
    public Employee findById(@PathVariable("id") String id){
        return employeeService.findById(id);
    }

    @PutMapping("/employeeUpdate")
    @ApiOperation(("employeeUpdate"))
    public Integer update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }
}
