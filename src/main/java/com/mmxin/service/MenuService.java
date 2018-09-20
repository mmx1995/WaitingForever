package com.mmxin.service;

import com.mmxin.pojo.Menu;

import java.util.List;

/**
 * @author : mmxin
 * @className : MenuService
 * @date : 2018/9/12 11:15
 */
public interface MenuService {

    public List<Menu> getInUseMenu();

    public List<Menu> getByPosition(String position);

}
