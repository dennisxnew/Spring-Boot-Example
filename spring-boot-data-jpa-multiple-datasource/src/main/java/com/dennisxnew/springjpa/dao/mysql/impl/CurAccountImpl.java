package com.dennisxnew.springjpa.dao.mysql.impl;

import com.dennisxnew.springjpa.dao.mysql.ICurAccount;
import com.dennisxnew.springjpa.model.mysql.CurAccount;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Dennis.Chen
 * @Date 20210427
 */
@Service
public class CurAccountImpl implements ICurAccount {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CurAccount> getAllAccount() {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ACCOUNT_ID accountId,     ");
        sb.append("       ACCOUNT_NAME accountName, ");
        sb.append("       GENDER gender,            ");
        sb.append("       BIRTHDAY birthday         ");
        sb.append("FROM CUR_ACCOUNT                 ");


        return entityManager.createNativeQuery(sb.toString())
                .unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.aliasToBean(CurAccount.class))
                .list();
    }
}
