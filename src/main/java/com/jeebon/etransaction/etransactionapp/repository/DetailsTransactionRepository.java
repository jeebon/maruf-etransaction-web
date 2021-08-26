package com.jeebon.etransaction.etransactionapp.repository;

import com.jeebon.etransaction.etransactionapp.entity.DetailsTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DetailsTransactionRepository extends JpaRepository<DetailsTransaction, Integer> {

}

