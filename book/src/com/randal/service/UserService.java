package com.randal.service;

import com.randal.pojo.User;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.service
 * @data 2020/5/30 17:43
 */
public interface UserService {
    /**
     * 注册用户
     *
     * @param user 注册的用户对象
     */
    void registerUser(User user);

    /**
     * 登陆
     * @param user 登陆的用户对象
     * @return
     */
    User login(User user);

    /**
     * 根据用户名判断用户是否存在
     * @param username 用户名
     * @return true表示用户存在，否则表示不存在
     */
    boolean isExistUsername(String username);



}
