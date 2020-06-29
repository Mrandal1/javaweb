package com.randal.web;

import com.randal.pojo.Book;
import com.randal.pojo.Page;
import com.randal.service.BookService;
import com.randal.service.impl.BookServiceImpl;
import com.randal.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.randal.utils.Constants.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.web
 * @data 2020/6/29 14:13
 */
public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    /**
     * 首页分页处理
     *
     * @param req  req
     * @param resp resp
     * @throws ServletException ServletException
     * @throws IOException      IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数 pageNo  pageSize
        Page<Book> pageBean = WebUtils.copyParamToBean(req.getParameterMap(), new Page<>());
        int pageNo = pageBean.getPageNo() != null ? pageBean.getPageNo() : 1;
        int pageSize = pageBean.getPageSize() != null ? pageBean.getPageSize() : DEFAULT_PAGE_SIZE;
        int min = pageBean.getMin() != null ? pageBean.getMin() : DEFAULT_PRICE_MIN;
        int max = pageBean.getMax() != null ? pageBean.getMax() : DEFAULT_PRICE_MAX;
        // 取得page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);
        page.setUrl("client/bookServlet?action=pageByPrice&min="+min+"&max="+max);
        // 保存至域中
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);


    }
}
