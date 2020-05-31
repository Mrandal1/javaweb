package com.randal.test;

import com.randal.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.test
 * @data 2020/5/30 15:08
 */
public class JdbcUtilsTest {

    /**
     * 测试数据库连接池的连接与关闭
     */
    @Test
    public void testJdbcUtils(){
        int count=100;
        for (int i=0;i<count;i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(i+""+connection);
            JdbcUtils.close(connection);
        }
    }
}
