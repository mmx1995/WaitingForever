package com.mmxin.controller;

import com.mmxin.pojo.Menu;
import com.mmxin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * @author : mmxin
 * @className : MenuController
 * @date : 2018/9/12 11:06
 */

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping
    public @ResponseBody List<Menu> getMenu(){
        return menuService.getInUseMenu() ;
    }

}
