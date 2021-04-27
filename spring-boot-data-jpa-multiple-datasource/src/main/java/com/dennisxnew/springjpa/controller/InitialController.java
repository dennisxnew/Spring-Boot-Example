package com.dennisxnew.springjpa.controller;

import com.dennisxnew.springjpa.dao.mariadb.repo.ICurContractInfo;
import com.dennisxnew.springjpa.dao.mysql.ICurAccount;
import com.dennisxnew.springjpa.dao.mysql.repo.ICurAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dennis.Chen
 * @Date 20200427
 */
@RestController
@RequestMapping("/init")
public class InitialController {

    @Autowired
    ICurAccountRepo curAccountRepo;

    @Autowired
    ICurContractInfo curContractInfo;

    @Autowired
    ICurAccount curAccount;

    @RequestMapping("/getAccountInfo")
    public Object getAccountInfo(){
        return curAccountRepo.findById(1L);
    }

    @RequestMapping("/getContractInfo")
    public Object getContractInfo(){
        return curContractInfo.findById(1);
    }

    @RequestMapping("/getAllAccount")
    public Object getAllAccount(){
        return curAccount.getAllAccount();
    }
}
