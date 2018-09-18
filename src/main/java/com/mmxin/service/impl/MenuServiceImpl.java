package com.mmxin.service.impl;

import com.mmxin.pojo.Menu;
import com.mmxin.repository.MenuRepository;
import com.mmxin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : mmxin
 * @className : MenuServiceImpl
 * @date : 2018/9/12 11:16
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository ;

    @Override
    public List<Menu> getInUseMenu() {
        List<Menu> list = menuRepository.findByInUse(true);
        return list;
    }
}
