package com.randal.test;

import com.randal.dao.OrderItemDao;
import com.randal.dao.impl.OrderItemDaoImpl;
import com.randal.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.test
 * @data 2020/6/30 13:49
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDaoImpl orderItem = new OrderItemDaoImpl();
        orderItem.saveOrderItem(new OrderItem(null, "java从入门到精通", 1, new BigDecimal(20), new BigDecimal(20), "1234567891"));
        orderItem.saveOrderItem(new OrderItem(null, "javaScript从入门到精通", 2, new BigDecimal(100), new BigDecimal(200), "1234567891"));
        orderItem.saveOrderItem(new OrderItem(null, "Netty入门", 1, new BigDecimal(50), new BigDecimal(50), "1234567891"));
    }
}