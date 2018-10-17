package com.mmxin.controller;

import com.mmxin.pojo.User;
import com.mmxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : mmxin
 * @className : UserController
 * @date : 2018/9/12 9:55
 * 用户控制器，主要是一些用户相关的一些页面
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService ;

    /**
     * 根据userId获取用户信息
     * */
    @GetMapping("/{userid}")
    public ModelAndView getUserById(@PathVariable("id")int userId){
        return null ;
    }

    /**
     * 更新用户信息,除密码之外
     * */
    public ModelAndView updateUser(User user){

        int i  = userService.updateUser(user);
        return null;
    }



}
