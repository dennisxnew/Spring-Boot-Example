package com.dennisxnew.springjpa.controllers;

import com.dennisxnew.springjpa.dao.ICurAccountDao;
import com.dennisxnew.springjpa.dao.ICurOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author Dennis.Chen
 * @Date 20210424
 */
@RestController
@RequestMapping("/init")
public class InitialController {

    @Autowired
    ICurAccountDao curAccountDao;

    @Autowired
    ICurOrderDao curOrderDao;

    @RequestMapping("/getOrderByName")
    public Object getOrderByName(){
        return curOrderDao.getOrderByAccountName("Dennis");
    }

    @RequestMapping("/getAllAccount")
    public Object getAllAccount(){
        return curAccountDao.getAllAccount();
    }
}
