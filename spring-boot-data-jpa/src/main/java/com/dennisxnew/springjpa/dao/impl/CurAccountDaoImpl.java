package com.dennisxnew.springjpa.dao.impl;

import com.dennisxnew.springjpa.bean.po.OrderPO;
import com.dennisxnew.springjpa.dao.ICurAccountDao;
import com.dennisxnew.springjpa.model.CurAccount;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dennis.Chen
 * @Date 20210424
 */

@Repository
@Transactional
public class CurAccountDaoImpl implements ICurAccountDao {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List getAllAccount() {

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ACCOUNT_ID accountId,     ");
        sb.append("       ACCOUNT_NAME accountName, ");
        sb.append("       GENDER gender,            ");
        sb.append("       BIRTHDAY birthday         ");
        sb.append("FROM CUR_ACCOUNT                 ");


        return sessionFactory.getCurrentSession().createNativeQuery(sb.toString())
                                                 .addScalar("accountId", IntegerType.INSTANCE)
                                                 .addScalar("accountName", StringType.INSTANCE)
                                                 .addScalar("gender", StringType.INSTANCE)
                                                 .addScalar("birthday", DateType.INSTANCE)
                                                 .unwrap(NativeQueryImpl.class)
                                                 .setResultTransformer(Transformers.aliasToBean(CurAccount.class))
                                                 .list();

    }
}
