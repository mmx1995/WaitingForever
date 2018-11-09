package com.mmxin.service;


import com.mmxin.pojo.User;

import java.util.List;

/**
 * 用户服务接口
 * @author : mmxin
 * @className : UserService
 * @date : 2018/8/17 17:51
 */
public interface UserService {
    /**
     * 保存用户
     * @param user
     * @return
     */
    int saveUser(User user) throws Exception;

    /**
     * 删除用户
     * @param id
     * @return
     */
    void removeUser(Long id);

    /**
     * 删除列表里面的用户
     * @param users
     * @return
     */
    void removeUsersInBatch(List<User> users);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> listUsers();

    /**
     * 根据用户名进行分页模糊查询
     * @param userName
     * @return
     */
    /*Page<User> listUsersByUserNameLike(String userName, Pageable pageable);*/

    /**
     * 更新用户密码
     * */
    int updatePassword(Long userId, String password);
}
