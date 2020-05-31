package com.randal.dao;


import com.randal.pojo.User;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.dao
 * @data 2020/5/30 16:30
 */
public interface UserDao {
    /**
     * 根据username用户名查询用户
     * @param username 用户名
     * @return 结果为null表示无此用户
     */
        User queryUserByUsername(String username);

    /**
     * 保存用户数据
     * @return 成功保存的用户数目
     * @param user 用户对象
     */
    int saveUser(User user);

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 结果为null表示无此用户
     */
    User queryUserByUsernameAndPassword(String username,String password);
}
