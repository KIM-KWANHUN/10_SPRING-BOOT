package com.ohgiraffers.crud.Model.Service;

import com.ohgiraffers.crud.Model.DAO.MenuMapper;
import com.ohgiraffers.crud.Model.DTO.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> menuList() {

        return menuMapper.menuList();
    }

    public MenuDTO menuCode(int code) {

        return menuMapper.menuCode(code);
    }
    @Transactional
    public MenuDTO registMenu(MenuDTO menuDTO) {

         menuMapper.registMenu(menuDTO);

         return menuDTO;
    }
}
