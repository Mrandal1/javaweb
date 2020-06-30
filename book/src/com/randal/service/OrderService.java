package com.randal.service;

import com.randal.pojo.Cart;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.service
 * @data 2020/6/30 13:57
 */
public interface OrderService {
    /**
     * 创建订单
     * @param cart
     * @param userId
     * @return
     */
    String createOrder(Cart cart,Integer userId);
}
