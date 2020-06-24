package com.randal.web;

import com.randal.pojo.User;
import com.randal.service.UserService;
import com.randal.service.impl.UserServiceImpl;
import com.randal.utils.MyFactory;
import com.randal.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.web
 * @data 2020/6/6 15:55
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    /**
     * 登录模块
     *
     * @param req  req
     * @param resp resp
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String username = req.getParameter("username");
        //String password = req.getParameter("password");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if (userService.login(user) == null) {
            //回显错误信息
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", user.getUsername());

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);

        }

    }

    /**
     * 注册模块
     *
     * @param req  req
     * @param resp resp
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String username = req.getParameter("username");
        //String password = req.getParameter("password");
        //String email = req.getParameter("email");
        String code = req.getParameter("code");
        //判断验证码
        String myCode = "abcde";
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if (myCode.equalsIgnoreCase(code)) {
            if (userService.isExistUsername(user.getUsername())) {
                System.out.println("用户名[" + user.getUsername() + "]已存在");
                //回显错误信息
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

            } else {
                userService.registerUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            //回显错误信息
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
