package com.southwind.service;

import com.southwind.entity.Employee;
import com.southwind.entity.EmployeeVO;

public interface EmployeeService {
    public Integer save(Employee employee);
    public EmployeeVO findByPage(Integer page);
    public void deleteById(String id);
    public Employee findById(String id);
    public Integer update(Employee teams);
}
