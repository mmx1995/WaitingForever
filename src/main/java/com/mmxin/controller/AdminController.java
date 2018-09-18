package com.mmxin.controller;

import com.mmxin.pojo.User;
import com.mmxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author : mmxin
 * @className : AdminContrller
 * @date : 2018/9/12 9:57
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    UserService  userService ;

    @GetMapping
    public String index(){
        return "redirect:/admin/index";
    }

    /**
     * 用户管理
     * */
    public ModelAndView getAllUser(@RequestParam(value="async",required=false) boolean async,
                                   @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                                   @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
                                   @RequestParam(value="name",required=false,defaultValue="") String name,
                                   Model model){
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<User> page = userService.listUsersByUserNameLike(name, pageable);
        List<User> list = page.getContent();	// 当前所在页面数据列表
        model.addAttribute("page", page);
        model.addAttribute("userList", list);
        return new ModelAndView(async==true?"users/list :: #mainContainerRepleace":"admin/users", "userModel", model);
    }

}
