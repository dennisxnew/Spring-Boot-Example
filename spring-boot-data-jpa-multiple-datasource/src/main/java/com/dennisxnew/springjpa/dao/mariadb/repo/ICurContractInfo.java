package com.dennisxnew.springjpa.dao.mariadb.repo;

import com.dennisxnew.springjpa.model.mariadb.CurContractInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dennis.Chen
 * @Date 20200427
 */
@Repository
public interface ICurContractInfo extends CrudRepository<CurContractInfo, Integer> {
}
