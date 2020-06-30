package com.randal.dao.impl;

import com.randal.dao.OrderDao;
import com.randal.pojo.Order;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.dao.impl
 * @data 2020/6/30 13:42
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) VALUES(?,?,?,?,?)";
        return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
