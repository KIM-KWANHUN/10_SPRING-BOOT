package com.ohgiraffers.crudtest.controller;

import com.ohgiraffers.crudtest.model.EmployeeDTO;
import com.ohgiraffers.crudtest.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("list")
    public String employeelist(Model model) {

        List<EmployeeDTO> employeelist = employeeService.employeelist();

        for(EmployeeDTO employeeDTO : employeelist) {
            System.out.println("employeeDTO = " + employeeDTO);

        }

        return "employee/list";
    }
}
