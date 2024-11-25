package com.ohgiraffers.crud.Model.Service;

import com.ohgiraffers.crud.Model.DAO.MenuDAO;
import com.ohgiraffers.crud.Model.DTO.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuDAO menuDAO;
    @Autowired
    public MenuService(MenuDAO menuDAO) {

        this.menuDAO = menuDAO;
    }


    public List<MenuDTO> menuAll() {

        return menuDAO.menuAll();
    }


    public MenuDTO menuCode(int menuByCode) {

        return menuDAO.menuCode(menuByCode);
    }
}
