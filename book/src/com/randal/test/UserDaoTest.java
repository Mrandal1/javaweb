package com.randal.test;

import com.randal.dao.UserDao;
import com.randal.dao.impl.UserDaoImpl;
import com.randal.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.test
 * @data 2020/5/30 17:02
 */
public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        User user = userDao.queryUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void saveUser() {
        int count = userDao.saveUser(new User(null,"116070", "116070", "116070@163.com"));
        System.out.println(count);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        System.out.println(user);
    }
}