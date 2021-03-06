package com.mmxin.controller;

import com.mmxin.pojo.User;
import com.mmxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/{userId}")
    public ModelAndView getUserById(@PathVariable("userId")Long userId, Model model){
        User user = this.userService.getUserById(userId);
        model.addAttribute("user",user);
        return new ModelAndView("users/userInfo","userModel",model);
    }

    /**
     * 更新用户信息,除密码之外
     * */
    @PostMapping("/userId")
    public ModelAndView updateUser(User user){
        int i  = userService.updateUser(user);
        return null;
    }

    @PostMapping("/updatePassword")
    public ModelAndView updatePassword(Long userId,String oldPasswrod, String newPassword){
        User user = userService.getUserById(userId);
        String nowPassword = user.getPassword();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        if (nowPassword.equals(encoder.encode(oldPasswrod))){

        }
        return null ;
    }


}
