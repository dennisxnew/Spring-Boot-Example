package com.dennisxnew.springjpa.dao.mysql.repo;

import com.dennisxnew.springjpa.model.mysql.CurAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dennis.Chen
 * @Date 20200427
 */
@Repository
public interface ICurAccountRepo extends CrudRepository<CurAccount, Long> {
}
