package com.randal.web;

import com.randal.pojo.User;
import com.randal.service.UserService;
import com.randal.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.web
 * @data 2020/5/30 19:18
 */
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST乱码
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //判断验证码
        String myCode = "abcde";
        if (myCode.equalsIgnoreCase(code)) {
            if (userService.isExistUsername(username)){
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            }
            userService.registerUser(new User(null,username,password,email));
            req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            return;
        } else {
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }
    }
}
