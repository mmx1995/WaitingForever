package com.mmxin.service.impl;

import com.mmxin.mapper.UserAuthorityMapper;
import com.mmxin.mapper.UserMapper;
import com.mmxin.pojo.Authority;
import com.mmxin.pojo.User;
import com.mmxin.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAuthorityMapper userAuthorityMapper ;

    @Override
    @Transactional
    public int saveUser(User user) {
            String password = user.getPassword();
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            password = encoder.encode(password);
            user.setPassword(password);
            userMapper.insert(user);
            for (Authority a: user.getAuthoritiesList()){
                userAuthorityMapper.insert(user.getId() , a.getId());
            }
            return 1;
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

    @Override
    public int updatePassword(Long userId, String password) {
        int i = userMapper.updatePassword(userId,password);
        return 0;
    }

    /**
     * 实现UserDetailsService 接口的方法
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.getUserByUserName(username);
    }
}
