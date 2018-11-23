package com.mmxin.service;

import com.mmxin.pojo.Story;

import java.util.List;

public interface StoryService {

    /**
     * 最近一个周最多浏览
     * */
    List<Story> getMorePopular();

    /**
     * 获取最近一周最有用的故事
     * */
    List<Story> getMoreUseful();

    /**
     * 获取最近一周最多赞同的
     * */
    List<Story> getMoreConsent();

    /**
     * 获取最近一周最多评论的
     * */
    List<Story> getMoreComment();

    /**
     * 获取主页面中放置的故事的列表
     * */
    List<Story> getIndex();

}
