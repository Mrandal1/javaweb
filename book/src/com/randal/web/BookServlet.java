package com.randal.web;

import com.randal.pojo.Book;
import com.randal.service.BookService;
import com.randal.service.impl.BookServiceImpl;
import com.randal.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.web
 * @data 2020/6/7 20:37
 */
public class BookServlet extends BaseServlet {
    public BookService bookService = new BookServiceImpl();

    /**
     * 添加图书模块
     *
     * @param req  req
     * @param resp resp
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        System.out.println(book);
        bookService.addBook(book);
        // 使用重定向防止表单重复提交
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    /**
     * 删除图书模块
     *
     * @param req  req
     * @param resp resp
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.deleteBookById(book.getId());
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    /**
     * 更新图书模块
     *
     * @param req  req
     * @param resp resp
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        book.setId(new Integer(req.getParameter("id")));
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    /**
     * 查询
     * @param req req
     * @param resp resp
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        req.setAttribute("book_info",bookService.queryBookById(book.getId()));
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    /**
     * 显示列表图书模块
     *
     * @param req  req
     * @param resp resp
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> lists = bookService.queryBooksAll();
        req.setAttribute("book_list", lists);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        super.doPost(req, resp);
    }


}
