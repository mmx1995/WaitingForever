package com.mmxin.mapper;

import com.mmxin.pojo.Menu;

import java.util.List;

public interface MenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenuInUse();

    List<Menu> getMenuByPosition(String position);

}