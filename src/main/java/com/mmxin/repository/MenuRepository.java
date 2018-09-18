package com.mmxin.repository;

import com.mmxin.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : mmxin
 * @className : MenuRepository
 * @date : 2018/9/12 11:11
 */
public interface MenuRepository extends JpaRepository<Menu, Long> {

   List<Menu> findByInUse(Boolean inuse);

}
