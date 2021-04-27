package com.dennisxnew.springjpa.dao.impl;

import com.dennisxnew.springjpa.bean.po.OrderPO;
import com.dennisxnew.springjpa.dao.ICurOrderDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dennis.Chen
 * @Date 20210425
 */
@Repository
@Transactional
public class CurOrderDaoImpl implements ICurOrderDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List getOrderByAccountName(String name) {

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT co.ORDER_ID orderId,         ");
        sb.append("       ca.ACCOUNT_ID accountId,     ");
        sb.append("       ca.ACCOUNT_NAME accountName, ");
        sb.append("       co.CREATE_TIME createTime,   ");
        sb.append("       co.PRICE price               ");
        sb.append("FROM cur_account ca, cur_order co   ");
        sb.append("WHERE ca.ACCOUNT_ID = co.ACCOUNT_ID ");
        sb.append("AND ca.ACCOUNT_NAME IN (:name)      ");

        return sessionFactory.getCurrentSession().createNativeQuery(sb.toString())
                                                      .addScalar("orderId", IntegerType.INSTANCE)
                                                      .addScalar("accountId", IntegerType.INSTANCE)
                                                      .addScalar("accountName", StringType.INSTANCE)
                                                      .addScalar("price", IntegerType.INSTANCE)
                                                      .setParameter("name", Arrays.asList("Dennis", "Danny"))
                                                      .unwrap(NativeQueryImpl.class)
                                                      .setResultTransformer(Transformers.aliasToBean(OrderPO.class))
                                                      .list();
    }

    @Override
    public void addOrder() {
    }


}
