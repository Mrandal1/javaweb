package com.randal.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.pojo
 * @data 2020/6/29 19:30
 */
public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap<>();


    /**
     * 添加商品项
     *
     * @param cartItem 待添加商品
     */
    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());
        // 判断是否已添加
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            // 数量累加
            item.setCount(item.getCount() + 1);
            // 更新总金额
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));

        }

    }

    /**
     * 删除商品项
     *
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空商品项
     *
     * @return
     */
    public void clear() {
        items.clear();
    }

    /**
     * 修改商品数量
     *
     * @param id    id
     * @param count count
     */
    public void updateCount(Integer id, Integer count) {
        // 查看是否有此商品
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));

        }
    }


    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
