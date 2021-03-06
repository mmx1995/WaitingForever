package com.mmxin.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mmxin.pojo.Menu;
import com.mmxin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import com.alibaba.fastjson.JSON;
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

    /**
     *
     * */
    @GetMapping(produces = "application/json")
    public @ResponseBody String getMenu(@RequestParam(value = "position",required = false) String position){
        if(position == null || position.equals("")){

            return JSON.toJSONString(menuService.getInUseMenu())  ;
        }else{
            return JSON.toJSONString(menuService.getByPosition(position));
        }

    }



}
