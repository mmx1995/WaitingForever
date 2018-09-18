package com.mmxin.controller;

import com.mmxin.pojo.Authority;
import com.mmxin.pojo.User;
import com.mmxin.service.AuthorityService;
import com.mmxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : mmxin
 * @className : MainController
 * @date : 2018/9/5 16:22
 */
@Controller
public class MainController {

    private static final Long ROLE_USER_AUTHORITY_ID = 2L;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("register")
    public String register(){
        return "register";
    }

    @PostMapping("register")
    public String addUser(User user){
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

}
