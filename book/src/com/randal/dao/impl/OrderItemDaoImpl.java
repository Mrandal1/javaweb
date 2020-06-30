package com.randal.dao.impl;

import com.randal.dao.OrderItemDao;
import com.randal.pojo.OrderItem;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.dao.impl
 * @data 2020/6/30 13:46
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql ="INSERT INTO t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) VALUES(?,?,?,?,?)";
        return  update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
