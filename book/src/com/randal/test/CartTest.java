package com.randal.test;

import com.randal.pojo.Cart;
import com.randal.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.test
 * @data 2020/6/29 19:51
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"c++",1,new BigDecimal(199),new BigDecimal(190)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateCount() {
    }
}