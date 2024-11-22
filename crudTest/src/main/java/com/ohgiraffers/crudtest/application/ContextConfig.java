package com.ohgiraffers.crudtest.application;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.crudtest")
@MapperScan(basePackages = "com.ohgiraffers.crudtest", annotationClass = Mapper.class)
public class ContextConfig {
}
