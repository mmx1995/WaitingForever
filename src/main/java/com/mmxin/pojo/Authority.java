package com.mmxin.pojo;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * @author : mmxin
 * @className : Authority
 * @date : 2018/9/5 15:52
 */
public class Authority implements GrantedAuthority,Serializable {

    /**
     * 权限管理列表编号
     * */
    private Long id;

    /**
     * 权限管理列表角色
     * */
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
