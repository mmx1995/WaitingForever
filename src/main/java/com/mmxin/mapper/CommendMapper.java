package com.mmxin.mapper;

import com.mmxin.pojo.Commend;
import com.mmxin.pojo.CommendKey;

public interface CommendMapper {
    int deleteByPrimaryKey(CommendKey key);

    int insert(Commend record);

    int insertSelective(Commend record);

    Commend selectByPrimaryKey(CommendKey key);

    int updateByPrimaryKeySelective(Commend record);

    int updateByPrimaryKey(Commend record);
}