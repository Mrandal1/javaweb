package com.randal.service.impl;

import com.randal.dao.UserDao;
import com.randal.dao.impl.UserDaoImpl;
import com.randal.pojo.User;
import com.randal.service.UserService;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.service.impl
 * @data 2020/5/30 17:51
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean isExistUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
