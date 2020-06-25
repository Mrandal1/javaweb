package com.randal.dao.impl;

import com.randal.dao.BookDao;
import com.randal.pojo.Book;

import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.dao.impl
 * @data 2020/6/6 18:19
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values( ? , ? , ? , ? , ? , ? )";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id= ? ";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book SET `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where `id`=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` from t_book where `id`=?";
        return queryForOne(sql, Book.class, id);
    }

    @Override
    public List<Book> queryBookAll() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` from t_book ";
        return queryForList(sql, Book.class);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number num = (Number) queryForSingleValue(sql);
        return num.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock` from t_book limit ? , ?";
        return queryForList(sql, Book.class, begin, pageSize);
    }
}
