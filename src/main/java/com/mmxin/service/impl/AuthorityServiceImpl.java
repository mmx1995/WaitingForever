package com.mmxin.service.impl;


import com.mmxin.mapper.AuthorityMapper;
import com.mmxin.pojo.Authority;
import com.mmxin.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : mmxin
 * @className : AuthorityServiceImpl
 * @date : 2018/8/24 11:37
 */
@Service
public class AuthorityServiceImpl  implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityMapper.selectByPrimaryKey(id);
    }

}
