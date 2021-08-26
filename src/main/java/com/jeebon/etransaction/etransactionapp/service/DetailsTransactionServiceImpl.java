package com.jeebon.etransaction.etransactionapp.service;

import com.jeebon.etransaction.etransactionapp.entity.DetailsTransaction;
import com.jeebon.etransaction.etransactionapp.helper.ExcelReaderWriter;
import com.jeebon.etransaction.etransactionapp.repository.DetailsTransactionRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class DetailsTransactionServiceImpl implements  DetailsTransactionService{
    @Autowired
    private DetailsTransactionRepository detailsTransactionRepository;



    public List<DetailsTransaction> getAll()
    {
        return detailsTransactionRepository.findAll();
    }

    public List<DetailsTransaction> saveAll(List<DetailsTransaction> items)
    {
        return detailsTransactionRepository.saveAll(items);
    }

}
