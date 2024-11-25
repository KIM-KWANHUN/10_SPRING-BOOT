package com.ohgiraffers.crudtest.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeDTO {

    private String empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private int salary;
    private int bonus;
    private String managerId;
    private Date hireDate;
    private Date entDate;
    private String entYn;
}
