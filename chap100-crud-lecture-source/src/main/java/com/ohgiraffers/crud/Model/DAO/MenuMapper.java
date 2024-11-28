package com.ohgiraffers.crud.Model.DAO;

import com.ohgiraffers.crud.Model.DTO.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDTO> menuList();

    MenuDTO menuCode(int code);

    void registMenu(MenuDTO menuDTO);
}
