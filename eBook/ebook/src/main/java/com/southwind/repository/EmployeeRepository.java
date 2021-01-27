package com.southwind.repository;

import com.southwind.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> find(Integer index, Integer limit);
    public Integer count();
    public Integer save(Employee employee);
    public boolean deleteById(String id);
    public Employee findById(String id);
    public Integer update(Employee employee);
}