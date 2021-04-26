package com.dennisxnew.springjpa.dao;

import com.dennisxnew.springjpa.bean.po.OrderPO;

import java.util.List;

/**
 * @author Dennis.Chen
 * @Date 20210425
 */
public interface ICurOrderDao {

    public List<OrderPO> getOrderByAccountName(String name);

    public void addOrder();
}
