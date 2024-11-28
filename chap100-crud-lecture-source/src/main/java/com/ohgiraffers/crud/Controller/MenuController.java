package com.ohgiraffers.crud.Controller;

import com.ohgiraffers.crud.Model.DTO.MenuDTO;
import com.ohgiraffers.crud.Model.Service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu/*")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("list")
    public String menuList(Model model) {

        List<MenuDTO> menuDTO = menuService.menuList();
        
        model.addAttribute("menuDTO", menuDTO);
        
        for(MenuDTO menu: menuDTO) {
            System.out.println("menu = " + menu);
        }

        return "/menu/list";
    }

    @GetMapping("code")
    public void menuCode1(){}

    @PostMapping("code")
    public String menuCode(@RequestParam int code, Model model) {

        MenuDTO menuCode = menuService.menuCode(code);

        model.addAttribute("menuCode", menuCode);

        System.out.println("menuCode = " + menuCode);

        return "/menu/codeByMenu";
    }

    @GetMapping("regist")
    public void menuRegist(){}

    @PostMapping("regist")
    public String registMenu(@ModelAttribute MenuDTO menuDTO){
        MenuDTO a;
        a= menuService.registMenu(menuDTO);

        return "redirect:/menu/list";
    }

}
