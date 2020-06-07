package com.randal.service;

import com.randal.pojo.Book;

import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.service
 * @data 2020/6/7 20:20
 */
public interface BookService {
    /**
     * 增加图书
     *
     * @param book 增加图书实体
     */
    void addBook(Book book);

    /**
     * 根据id删除图书
     *
     * @param id 图书的id
     */
    void deleteBookById(Integer id);

    /**
     * 更新图书信息
     *
     * @param book 图更新书实体
     */
    void updateBook(Book book);

    /**
     * 根据id查询图书
     *
     * @param id 图书的id
     * @return Book Bean对象
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有图书信息
     *
     * @return List<Book>
     */
    List<Book> queryBooksAll();
}
