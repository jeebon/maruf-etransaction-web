package com.jeebon.etransaction.etransactionapp.service;

import com.jeebon.etransaction.etransactionapp.entity.DetailsTransaction;
import com.jeebon.etransaction.etransactionapp.repository.DetailsTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DetailsTransactionService {
    public List<DetailsTransaction> getAll();
    public List<DetailsTransaction> saveAll(List<DetailsTransaction> items);
}
