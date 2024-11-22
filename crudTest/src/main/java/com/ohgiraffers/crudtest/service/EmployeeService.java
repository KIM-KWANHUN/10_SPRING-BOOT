package com.ohgiraffers.crudtest.service;

import com.ohgiraffers.crudtest.model.EmployeeDTO;
import com.ohgiraffers.crudtest.model.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper) {

        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> employeelist() {

        List<EmployeeDTO> employee =  employeeMapper.employeelist();

        System.out.println("employee = " + employee);
        return employee;
    }
}
