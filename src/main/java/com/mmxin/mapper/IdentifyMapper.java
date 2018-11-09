package com.mmxin.mapper;

import com.mmxin.pojo.Identify;

public interface IdentifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Identify record);

    int insertSelective(Identify record);

    Identify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Identify record);

    int updateByPrimaryKey(Identify record);

    Identify selectByEmail(String email);
}