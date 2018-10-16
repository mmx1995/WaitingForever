package com.mmxin.mapper;

import com.mmxin.pojo.StoryHistory;
import com.mmxin.pojo.StoryHistoryKey;

public interface StoryHistoryMapper {
    int deleteByPrimaryKey(StoryHistoryKey key);

    int insert(StoryHistory record);

    int insertSelective(StoryHistory record);

    StoryHistory selectByPrimaryKey(StoryHistoryKey key);

    int updateByPrimaryKeySelective(StoryHistory record);

    int updateByPrimaryKeyWithBLOBs(StoryHistory record);

    int updateByPrimaryKey(StoryHistory record);
}