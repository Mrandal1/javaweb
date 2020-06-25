package com.randal.dao;

import com.randal.pojo.Book;

import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.dao
 * @data 2020/6/6 18:12
 */
public interface BookDao {
    /**
     * 单次添加图书
     *
     * @param book 要添加的图书
     * @return 成功保存返回 （1）
     */
    int addBook(Book book);

    /**
     * 根据图书id删除图书
     *
     * @param id 图书id
     * @return 成功删除返回删除数量 （1）
     */
    int deleteBookById(Integer id);

    /**
     * 更新图书信息
     *
     * @param book 更新目标图书
     * @return 成功跟新的图书数量 （1）
     */
    int updateBook(Book book);

    /**
     * 根据图书id查询图书信息
     *
     * @param id 图书id
     * @return 查询到的Book实体对象
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有图书信息
     *
     * @return 封装所有Book信息实体的List
     */
    List<Book> queryBookAll();

    /**
     * 查询总记录数
     *
     * @return
     */
    Integer queryForPageTotalCount();

    /**
     * 查询当前页记录
     * @param begin 开始记录
     * @param pageSize 页面容量
     * @return
     */
    List<Book> queryForPageItems(int begin, int pageSize);
}
