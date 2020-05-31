package com.randal.dao.impl;

import com.randal.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.dao.impl
 * @data 2020/5/30 15:20
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();


    /**
     * 更新操作
     *
     * @param sql   update_sql语句
     * @param param update_sql参数
     * @return -1表示操作失败
     */
    public int update(String sql, Object... param) {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.update(con, sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return -1;

    }

    /**
     * 将结果集中的第一行数据封装到一个对应的JavaBean实例中
     *
     * @param sql   query_sql语句
     * @param type  目标Bean类型
     * @param param query_sql参数
     * @param <T>   Bean类型
     * @return 结果为null表示查询失败
     */
    public <T> T queryForOne(String sql, Class<T> type, Object... param) {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con,sql, new BeanHandler<>(type), param);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    /**
     * 结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里
     *
     * @param sql   query_sql语句
     * @param type  目标Bean类型
     * @param param query_sql参数
     * @param <T>   Bean类型
     * @return 结果为null表示查询失败
     */
    public <T> List<T> queryForList(String sql, Class<T> type, Object... param) {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<>(type), param);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    /**
     * 返回指定列的一个值或返回一个统计函数的值
     *
     * @param sql   query_sql语句
     * @param param query_sql参数
     * @return 结果为null表示查询失败
     */
    public Object queryForSingleValue(String sql, Object... param) {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new ScalarHandler(), param);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return null;
    }


}
