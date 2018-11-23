package com.mmxin.controller;

import com.mmxin.configure.ReturnCodeEnum;
import com.mmxin.pojo.Authority;
import com.mmxin.pojo.Identify;
import com.mmxin.pojo.Story;
import com.mmxin.pojo.User;
import com.mmxin.service.AuthorityService;
import com.mmxin.service.IdentifiedService;
import com.mmxin.service.StoryService;
import com.mmxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private IdentifiedService identifiedService ;

    @Autowired
    private StoryService storyService;

    /**
     * 主页
     * todo: 之后有时间分析一下为啥不能拦截
     * */
    @GetMapping("")
    public ModelAndView getNull(Model model){
        return new ModelAndView("index","index",model);
    }

    /**
     * 主页面
     * 1、应当包含的内容放置的故事的类型
     * */
    @GetMapping("index")
    public ModelAndView index(Model model){
        List<Story> list = this.storyService.getIndex();
        model.addAttribute("indexStory",list);
        return new ModelAndView("index","index",model);
    }

    /**
     * 注册
     * */
    @GetMapping("register")
    public String register(){
        return "register";
    }

    /**
     * 注册
     * */
    @PostMapping("register")
    public @ResponseBody String addUser(@RequestParam("phoneNum")String phoneNum,
            @RequestParam("userName")String userName,
            @RequestParam("email")String email,
            @RequestParam("password")String password,
            @RequestParam("sex")String sex,
            @RequestParam("identify") String identify){
        //验证码判断
        Identify identify1 = this.identifiedService.getByEmail(email);
        Date createTime = identify1.getCreatetime();
        //判断是否超时
        if (System.currentTimeMillis() - createTime.getTime() >= 5 * 60 * 1000){
            return ReturnCodeEnum.register_overTime;
        }
        System.out.println(identify);
        //判断验证码是否正确
        if (!identify.equals(identify1.getCode())){
            return ReturnCodeEnum.register_wrongIdentify;
        }
        User user = new User();
        user.setPhoneNum(phoneNum);
        user.setPassword(password);
        user.setEmail(email);
        user.setUserName(userName);
        user.setSex(sex);
        List<Authority> authorities = new ArrayList<>();
        //权限增加
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ReturnCodeEnum.register_success;
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

}
