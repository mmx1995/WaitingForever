package com.mmxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : mmxin
 * @className : MainController
 * @date : 2018/9/5 16:22
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("register")
    public String register(){
        return register();
    }

}
