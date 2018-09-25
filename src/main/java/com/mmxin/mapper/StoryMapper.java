package com.mmxin.mapper;

import com.mmxin.pojo.Story;

public interface StoryMapper {
    int deleteByPrimaryKey(Integer storyid);

    int insert(Story record);

    int insertSelective(Story record);

    Story selectByPrimaryKey(Integer storyid);

    int updateByPrimaryKeySelective(Story record);

    int updateByPrimaryKeyWithBLOBs(Story record);

    int updateByPrimaryKey(Story record);
}