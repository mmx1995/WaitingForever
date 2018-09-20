package com.mmxin.service.impl;

import com.mmxin.mapper.MenuMapper;
import com.mmxin.pojo.Menu;
import com.mmxin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author : mmxin
 * @className : MenuServiceImpl
 * @date : 2018/9/12 11:16
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper ;

    @Override
    public List<Menu> getInUseMenu() {
        List<Menu> list = menuMapper.getMenuInUse();
        return list;
    }

    @Override
    public List<Menu> getByPosition(String position) {
        return menuMapper.getMenuByPosition(position);
    }
}
