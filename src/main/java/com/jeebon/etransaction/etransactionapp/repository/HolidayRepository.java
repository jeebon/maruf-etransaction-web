package com.jeebon.etransaction.etransactionapp.repository;

import com.jeebon.etransaction.etransactionapp.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
    List<Holiday> findByPresentDate(String presentDate);
}

