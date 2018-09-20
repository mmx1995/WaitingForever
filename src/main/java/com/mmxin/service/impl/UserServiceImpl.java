package com.mmxin.service.impl;

import com.mmxin.mapper.UserMapper;
import com.mmxin.pojo.User;
import com.mmxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : mmxin
 * @className : UserServiceImpl
 * @date : 2018/8/17 18:11
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public int saveUser(User user) {
        String password = user.getPassword();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        password = encoder.encode(password);
        user.setPassword(password);
        return userMapper.insert(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * todo : 未实现的，批量删除用户
     * */
    @Override
    public void removeUsersInBatch(List<User> users) {

    }

    @Transactional
    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> listUsers() {
        return userMapper.getAll();
    }

    /**
     * 实现UserDetailsService 接口的方法
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.getUserByUserName(username);
    }
}
