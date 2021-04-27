package com.dennisxnew.springjpa.dao.mysql;

import com.dennisxnew.springjpa.model.mysql.CurAccount;

import java.util.List;

/**
 * @author Dennis.Chen
 * @Date 20200427
 */
public interface ICurAccount {

    public List<CurAccount> getAllAccount();
}
