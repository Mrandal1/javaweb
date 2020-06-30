package com.randal.dao;

import com.randal.pojo.OrderItem;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.dao
 * @data 2020/6/30 13:40
 */
public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    int saveOrderItem(OrderItem orderItem);
}
