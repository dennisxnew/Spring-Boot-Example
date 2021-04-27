package com.dennisxnew.springjpa.model.mariadb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Dennis.Chen
 * @Date
 */
@Entity
@Table(name = "CUR_USER_CONTRACT")
public class CurUserContract {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int id;
    @Column(name = "ACCOUNT_ID")
    public int accountId;
    @Column(name = "CONTRACT_ID")
    public int contractId;
    @Column(name = "AVAILABLE_TIME")
    public Date availableTime;
    @Column(name = "EXPIRE_TIME")
    public Date expireTime;
    @Column(name = "CREATE_DATE")
    public Date createDate;
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Date getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(Date availableTime) {
        this.availableTime = availableTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
