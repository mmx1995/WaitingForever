package com.mmxin.mapper;

import com.mmxin.pojo.Story;

import java.util.List;

public interface StoryMapper {
    int deleteByPrimaryKey(Integer storyid);

    int insert(Story record);

    int insertSelective(Story record);

    Story selectByPrimaryKey(Integer storyid);

    int updateByPrimaryKeySelective(Story record);

    int updateByPrimaryKeyWithBLOBs(Story record);

    int updateByPrimaryKey(Story record);

    List<Story> selectAll();

    /**
     * 分页查询
     * */
    List<Story> selectStory(int form, int to);
}