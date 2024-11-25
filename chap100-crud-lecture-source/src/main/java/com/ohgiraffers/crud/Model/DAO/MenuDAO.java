package com.ohgiraffers.crud.Model.DAO;

import com.ohgiraffers.crud.Model.DTO.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDAO {

    List<MenuDTO> menuAll();


    MenuDTO menuCode(int menuByCode);
}
