package com.randal.test;

import com.randal.pojo.User;
import com.randal.service.UserService;
import com.randal.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.test
 * @data 2020/5/30 18:59
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"1234567", "1234567", "123457@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin", "admin", null)));
    }

    @Test
    public void isExistUsername() {
        System.out.println(userService.isExistUsername("admin"));
    }
}