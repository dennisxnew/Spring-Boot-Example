package com.dennisxnew.springjpa.model.mariadb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Dennis.Chen
 * @Date 20200427
 */
@Entity
@Table(name = "CUR_CONTRACT_INFO")
public class CurContractInfo {

    @Id
    @GeneratedValue
    @Column(name = "CONTRACT_ID")
    public int contractId;
    @Column(name = "CONTRACT_NAME")
    public String contractName;
    @Column(name = "CONTRACT_PRICE")
    public int contractPrice;
    @Column(name = "AVAILABLE_TIME")
    public Date availableTime;
    @Column(name = "DISABLE_TIME")
    public Date disableTime;
    @Column(name = "CREATE_DATE")
    public Date createDate;
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public int getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(int contractPrice) {
        this.contractPrice = contractPrice;
    }

    public Date getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(Date availableTime) {
        this.availableTime = availableTime;
    }

    public Date getDisableTime() {
        return disableTime;
    }

    public void setDisableTime(Date disableTime) {
        this.disableTime = disableTime;
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
