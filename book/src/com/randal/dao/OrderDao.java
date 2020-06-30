package com.randal.dao;

import com.randal.pojo.Order;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.dao
 * @data 2020/6/30 13:39
 */
public interface OrderDao {
    /**
     * 保存订单
     * @param order
     * @return int
     */
     int saveOrder(Order order);
}
