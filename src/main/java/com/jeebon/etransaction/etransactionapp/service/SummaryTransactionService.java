package com.jeebon.etransaction.etransactionapp.service;

import com.jeebon.etransaction.etransactionapp.entity.SummaryTransaction;
import com.jeebon.etransaction.etransactionapp.repository.SummaryTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

public interface SummaryTransactionService {
    public List<SummaryTransaction> getAll();
    public List<SummaryTransaction> saveAll(List<SummaryTransaction> items);
}
