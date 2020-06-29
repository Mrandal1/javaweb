package com.randal.web;

import com.randal.pojo.Book;
import com.randal.pojo.Cart;
import com.randal.pojo.CartItem;
import com.randal.service.BookService;
import com.randal.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.web
 * @data 2020/6/29 20:08
 */
public class CartServlet extends BaseServlet {
    BookService bookService=new BookServiceImpl();
    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = bookService.queryBookById(new Integer(req.getParameter("id")));
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart=(Cart)req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
             req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        // 重定向会源地址
        resp.sendRedirect(req.getHeader("Referer"));
        req.getSession().setAttribute("last_name",cartItem.getName());
    }

    /**
     * 删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.deleteItem(new Integer(req.getParameter("id")));
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 跟新数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.updateCount(new Integer(req.getParameter("id")),new Integer(req.getParameter("count")));
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
