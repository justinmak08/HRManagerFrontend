package com.southwind.service.impl;

import com.southwind.entity.Employee;
import com.southwind.entity.EmployeeVO;
import com.southwind.repository.EmployeeRepository;
import com.southwind.service.EmployeeService;
import com.southwind.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    private Integer limit = 10;

    @Override
    public EmployeeVO findByPage(Integer page) {
        Integer index = (page-1)*limit;
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setData(employeeRepository.find(index,limit));
        employeeVO.setTotal(employeeRepository.count());
        employeeVO.setPageSize(limit);
        return employeeVO;
    }

    @Override
    public Integer save(Employee employee) {
        String employeeId = UUIDGenerator.getId();
        employee.setId(employeeId);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Integer update(Employee employee) {
        return employeeRepository.update(employee);
    }
}
