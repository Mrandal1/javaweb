package com.randal.service.impl;

import com.randal.dao.BookDao;
import com.randal.dao.impl.BookDaoImpl;
import com.randal.pojo.Book;
import com.randal.service.BookService;

import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.service.impl
 * @data 2020/6/7 20:28
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
       return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooksAll() {
      return   bookDao.queryBookAll();
    }
}
