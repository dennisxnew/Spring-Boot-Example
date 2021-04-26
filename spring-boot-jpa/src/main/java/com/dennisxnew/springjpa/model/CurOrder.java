package com.dennisxnew.springjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Dennis.Chen
 * @Date 20210425
 */
@Entity
@Table(name="CUR_ORDER")
public class CurOrder {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "ACCOUNT_ID")
    private int accountId;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "CREATE_TIME")
    private Date createTime;

    public CurOrder(int accountId, int price, Date createTime) {
        this.accountId = accountId;
        this.price = price;
        this.createTime = createTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
