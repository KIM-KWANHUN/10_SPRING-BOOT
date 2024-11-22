package com.ohgiraffers.crudtest.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<EmployeeDTO> employeelist();
}
