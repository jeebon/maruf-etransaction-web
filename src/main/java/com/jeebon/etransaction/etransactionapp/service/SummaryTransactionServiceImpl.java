package com.jeebon.etransaction.etransactionapp.service;

import com.jeebon.etransaction.etransactionapp.entity.SummaryTransaction;
import com.jeebon.etransaction.etransactionapp.helper.ExcelReaderWriter;
import com.jeebon.etransaction.etransactionapp.repository.SummaryTransactionRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SummaryTransactionServiceImpl implements SummaryTransactionService{

    @Autowired
    private SummaryTransactionRepository summaryTransactionRepository;

    public List<SummaryTransaction> getAll()
    {
        return summaryTransactionRepository.findAll();
    }

    public List<SummaryTransaction> saveAll(List<SummaryTransaction> items)
    {
        return summaryTransactionRepository.saveAll(items);
    }

    public List<SummaryTransaction> excelToDatabase(String path)
    {
        List<SummaryTransaction> items = new ArrayList<SummaryTransaction>();
        XSSFSheet sheet = ExcelReaderWriter.XlxsReadFirstXssSheet(path);
        Iterator<Row> itr = sheet.iterator();
        if(itr.hasNext()){
            itr.next(); //Skipp title
        }
        while (itr.hasNext()) {
            SummaryTransaction summaryTransaction = new SummaryTransaction();
            Row row = itr.next();
            summaryTransaction.setFundCode(ExcelReaderWriter.getForceStringValue(row, 0));
            summaryTransaction.setAmount(ExcelReaderWriter.getForceFloatValue(row, 1));
            summaryTransaction.setMarketValue (ExcelReaderWriter.getForceFloatValue(row, 2));
            summaryTransaction.setMarketValue( ExcelReaderWriter.getForceFloatValue(row, 3));
            summaryTransaction.setAccrued( ExcelReaderWriter.getForceFloatValue(row, 4));
            summaryTransaction.setSettlementCash( ExcelReaderWriter.getForceFloatValue(row, 5));
            summaryTransaction.setReceivable( ExcelReaderWriter.getForceFloatValue(row, 6));
            summaryTransaction.setPayable( ExcelReaderWriter.getForceFloatValue(row, 7));
            summaryTransaction.setUnapplied( ExcelReaderWriter.getForceFloatValue(row, 8));
            summaryTransaction.setValuationMargin( ExcelReaderWriter.getForceFloatValue(row, 9));
            summaryTransaction.setOffBalance( ExcelReaderWriter.getForceFloatValue(row, 10));
            summaryTransaction.setNav( ExcelReaderWriter.getForceFloatValue(row, 11));
            items.add(summaryTransaction);
        }
        return summaryTransactionRepository.saveAll(items);
    }
}
