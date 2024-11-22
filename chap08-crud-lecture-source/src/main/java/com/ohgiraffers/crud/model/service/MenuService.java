package com.ohgiraffers.crud.model.service;

import com.ohgiraffers.crud.model.dao.MenuMapper;
import com.ohgiraffers.crud.model.dto.CategoryDTO;
import com.ohgiraffers.crud.model.dto.MenuAndCategoryDTO;
import com.ohgiraffers.crud.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;
    // DAO를 쓰기위해 생성자 방식으로 주입
    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenus() {
        // DAO 랑 연관 되이었다.
        return menuMapper.findAllMenus();
    }

    public List<CategoryDTO> findAllCategory() {

        return menuMapper.findAllCategory();
    }

    /* comment.
    *   스프링 프레임 워크에서 제공하는 트랜젝션 관리 어노테이션으로
    *   데이터베이스의 상태를 변화시키는 작업(DML) 을 하나의 단위로
    *   묶는 것을 의미한다. 따라서 데이터베이스 조작에 관련된 일이
    *   일어날 때 메소드의 실행이 정상적으로 완료되면 COMMIT,
    *   예외가 발생하면 ROLLBACK 을 수행하여
    *   데이터의 일관성을 유지한다.
    *   내부적으로 AOP 기능을 가지고 있다. */
    @Transactional
    public void registMenu(MenuDTO newMenu) {

        menuMapper.registNewMenu(newMenu);
    }

    public MenuDTO selectMenuCode(String code) {

        return menuMapper.selectMenuCode(code);
    }

    public List<MenuAndCategoryDTO> findAllMenuAndCategory() {

        return menuMapper.findAllMenuAndCategory();
    }
    @Transactional
    //추가, 수정, 삭제 할때는 위에 Transactional 을 붙여주는게 좋다.
    public void updateMenu(MenuDTO updateMenu) {

        menuMapper.menuUpdate(updateMenu);

    }
    @Transactional
    public void deleteMenu(MenuDTO code) {

        menuMapper.menuDelete(code);
    }
}
