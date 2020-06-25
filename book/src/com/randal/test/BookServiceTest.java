package com.randal.test;

import com.randal.pojo.Page;
import com.randal.service.BookService;
import com.randal.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.test
 * @data 2020/6/7 20:31
 */
public class BookServiceTest {
    private BookService bookService=new BookServiceImpl();

    @Test
    public void addBook() {

    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(2));
    }

    @Test
    public void queryBooksAll() {
        System.out.println(bookService.queryBooksAll());
    }
    @Test
    public void page(){
        System.out.println(bookService.page(1, 4));
    }
}