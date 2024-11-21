package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.model.dto.CategoryDTO;
import com.ohgiraffers.crud.model.dto.MenuDTO;
import com.ohgiraffers.crud.model.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu/*") //메뉴에 대한 요청을 받도록 처리
public class MenuController {

    private final MenuService menuService; // 생성자 의존성 주입으로 MenuService 클래스 이용

    public MenuController(MenuService menuService) {
        this.menuService = menuService; // 기본생성자에 MenuService 등록
    }

    @GetMapping("list")
    public String findMenuList(Model model) {

        // 전체 메뉴 조회는 MenuDTO 타입이 여러 개 이기 때문에
        // List
        List<MenuDTO> menuList = menuService.findAllMenus(); // 서비스에 findAllMenus 메소드 호출

        // 반복문을 통해 DB 조회 값이 잘 들어있는지 확인
        for(MenuDTO menu : menuList) {
            System.out.println("menu = " + menu);
        }

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    @GetMapping("regist")
    public void registPage() {

    }
    /* comment.
        json -> 자바스크립트 객체 표기법을 의미한다.
        값을 자바스크립트 안에 곳에 보내야 하므로 json 을 이용하면
        알아서 자바객체의 값을 자바스크립트 객체 표기법으로 값을 바꾸어준다.*/
    @GetMapping(value = "category", produces = "application/json; charset=UTF-8")
    /* comment.
    *   @ResponseBody 어노테이션은
    *   기존의 Controller 의 역활은 view 를 마지막에
    *   리턴하는 것이 의무이다. 하지만, @ResponseBody 는
    *   view 를 리턴하는 의무가 아닌, 데이터를 리턴할 수 있게 만든다. */
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {

        return menuService.findAllCategory();
    }

}
