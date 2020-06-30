package com.randal.web;

import com.randal.pojo.Cart;
import com.randal.pojo.User;
import com.randal.service.OrderService;
import com.randal.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.web
 * @data 2020/6/30 14:10
 */
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取 Cart 购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        // 获取Session域中的user对象
        User user = (User) req.getSession().getAttribute("user");

        //判断user对象是空
        if(user == null){
            //请求转发到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            //结束Servlet方法，不再执行下面的代码
            return;
        }

        //user对象不为空，获取userId
        Integer userId = user.getId();

        //调用 orderService.createOrder(Cart,UserId);生成订单
        String  orderId = orderService.createOrder(cart, userId);

        //将订单号保存到Session域中
        req.getSession().setAttribute("orderId",orderId);

        //跳到结算成功页面,使用重定向，防止表单被重复提交。
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
