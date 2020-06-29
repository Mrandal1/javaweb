package com.randal.test;

import com.randal.dao.BookDao;
import com.randal.dao.impl.BookDaoImpl;
import com.randal.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.test
 * @data 2020/6/6 20:49
 */
public class BookDaoTest {
private BookDao bookDao=new BookDaoImpl();
    @Test
    public void addBook() {
        Book book=new Book(null,"test_Book","author",new BigDecimal(999),99,19,null);
        bookDao.addBook(book);

    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(1);
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
       Book book=bookDao.queryBookById(2);
        System.out.println(book);
    }

    @Test
    public void queryBookAll() {
        List<Book> books=bookDao.queryBookAll();
        for (Book b:books) {
            System.out.println(b);
        }
    }
    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }
    @Test
    public void queryForPageItems(){
        List<Book> items=bookDao.queryForPageItems(88,4);
        for (Book b:items) {
            System.out.println(b);
        }
    }
    @Test
    public void queryForPageItemsByPrice(){
        List<Book> items=bookDao.queryForPageItemsByPrice(0,4,0,50);
        for (Book b:items) {
            System.out.println(b);
        }
    }
}