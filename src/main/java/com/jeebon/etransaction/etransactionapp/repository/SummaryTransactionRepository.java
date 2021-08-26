package com.jeebon.etransaction.etransactionapp.repository;

import com.jeebon.etransaction.etransactionapp.entity.SummaryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SummaryTransactionRepository extends JpaRepository<SummaryTransaction, Integer> {

}