package com.ohgiraffers.crud.Controller;

import com.ohgiraffers.crud.Model.DTO.MenuDTO;
import com.ohgiraffers.crud.Model.Service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/menu/*")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {

        this.menuService = menuService;

    }

    @GetMapping("list")
    public String menuAll(Model model) {

        List<MenuDTO> menu = menuService.menuAll();

        model.addAttribute("menu", menu);

        return "menu/list";
    }

    @GetMapping("code")
    public void menuCode() { }

    @PostMapping("code")
    public String menuCode(int menuByCode, Model model) {
        
        MenuDTO menu = menuService.menuCode(menuByCode);


        model.addAttribute("menu", menu);

        System.out.println("menu = " + menu);


        return "menu/codeResult";
    }
}
