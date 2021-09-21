package com.jeebon.etransaction.etransactionapp.repository;

import com.jeebon.etransaction.etransactionapp.entity.Holiday;
import com.jeebon.etransaction.etransactionapp.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
    List<Portfolio> findByCode(String code);
}

