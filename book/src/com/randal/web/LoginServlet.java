package com.randal.web;

import com.randal.pojo.User;
import com.randal.service.UserService;
import com.randal.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.web
 * @data 2020/5/30 21:33
 */
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST乱码
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (userService.login(new User(null,username,password,null))==null){
            System.out.println(username+"登陆失败");
            System.out.println(req.getCharacterEncoding());
            req.getRequestDispatcher("pages/user/login.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("pages/user/login_success.html").forward(req,resp);

        }



    }


}
