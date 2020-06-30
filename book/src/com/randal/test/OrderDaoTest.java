package com.randal.test;

import com.randal.dao.OrderDao;
import com.randal.dao.impl.OrderDaoImpl;
import com.randal.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.test
 * @data 2020/6/30 13:47
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao=new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567891", new Date(), new BigDecimal(20), 0, 1));
    }
}