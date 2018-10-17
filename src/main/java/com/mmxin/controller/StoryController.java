package com.mmxin.controller;

import com.mmxin.pojo.Story;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : mmxin
 * @className : StoryController
 * @date : 2018/10/17 12:00
 * 故事的增删改查
 * 增和改使用相同的前端页面
 * 增加的时候返回空的Story对象，即new 一个新的对象
 * 改的时候返回
 */
@Controller
@RequestMapping("story")
public class StoryController {

    @GetMapping()
    public ModelAndView addStory(){
        return null;
    }

    /**
     * 新建故事，返回数据库保存之后的故事实体
     * */
    @PostMapping()
    public ModelAndView addStrory(Story story){
        return null;
    }

    /**
     * 更新故事
     * */
    @PutMapping
    public ModelAndView updateStory(Story story){
        return null;
    }

    /**
     * 删除故事，此处不做删除，只做状态更新，将状态更新为停用状态，此时故事对所有人不可见x
     * */
    @DeleteMapping
    public ModelAndView daleteStory(Story story){
        return null ;
    }
}
