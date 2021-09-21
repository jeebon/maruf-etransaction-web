package com.jeebon.etransaction.etransactionapp.service;

import com.jeebon.etransaction.etransactionapp.entity.DetailsTransaction;
import com.jeebon.etransaction.etransactionapp.entity.Portfolio;
import com.jeebon.etransaction.etransactionapp.entity.SummaryTransaction;
import com.jeebon.etransaction.etransactionapp.helper.CsvReaderWriter;
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


    public Boolean detailsTransExportToCsv(String path, String fileDate, List<Portfolio> portfolios, List<SummaryTransaction> list )
    {
        String[] header = new String[]{"DATE", "PORTFOLIO", "VALUE", "CURRENCY", "DATATYPE" , "DATA_ASOF_DATE" , "DATASOURCE"};

        List<String[]> items = new ArrayList<>();
        list.forEach(item -> {
            String portfolioValue = "";
            for(int i=0; i < portfolios.size(); i++){
                if(portfolios.get(i).getCode() == item.getFundCode()){
                    portfolioValue = portfolios.get(i).getValue();
                    break;
                }
            }

            items.add(new String[]{
                    fileDate,
                    portfolioValue,
                    String.valueOf(item.getNav()),
                    "JYP",
                    "NAV_OVR",
                    "JYP",
                    fileDate + " 20:11:16",
                    "POJ",
            });
        });


        try {
            CsvReaderWriter.writeCsv(path, header, items);
            return true;
        } catch (Exception e){
            return false;
        }

    }


    public Boolean detailsTransExtendedExportToCsv(String path, String fileDate, List<Portfolio> portfolios, List<SummaryTransaction> list )
    {
        String[] dataTypes = new String[]{"FA_AI", "FA_CB", "FA_CC", "FA_DISTR", "FA_DIV", "FA_EXP", "FA_FSRP", "FA_FUTMAR", "FA_LEV", "FA_MV", "FA_OAL", "FA_OTHTAX", "FA_RCLM", "FA_SLR", "FA_SWEEP", "FA_SWPMAR", "FA_UPS", "FA_WHT",};


        String[] header = new String[]{"DATE", "PORTFOLIO", "VALUE", "CURRENCY", "DATATYPE" , "DATA_ASOF_DATE" , "DATASOURCE"};

        List<String[]> items = new ArrayList<>();
        list.forEach(item -> {
            String portfolioValue = "";
            for(int i=0; i < portfolios.size(); i++){
                if(portfolios.get(i).getCode() == item.getFundCode()){
                    portfolioValue = portfolios.get(i).getValue();
                    break;
                }
            }
            String dataType = "";
            String value = "";
            for (int i = 0; i < dataTypes.length; i++) {
                dataType = dataTypes[i];
                if(dataType == "FA_AI"){
                    value = String.valueOf(item.getAccrued());
                } else if(dataType == "FA_CB"){
                    value = String.valueOf(item.getSettlementCash());
                } else if(dataType == "FA_MV"){
                    value = String.valueOf(item.getMarketValue());
                } else if(dataType == "FA_OTHTAX" || dataType == "FA_RCLM" || dataType == "FA_WHT"){
                    value = String.valueOf(item.getTax());
                } else {
                    value = "";
                }

                items.add(new String[]{
                        fileDate,
                        portfolioValue + " (" + item.getFundCode() + ")",
                        value,
                        "JYP",
                        dataType,
                        "JYP",
                        fileDate + " 20:11:16",
                        "POJ",
                });
            }

        });

        try {
            CsvReaderWriter.writeCsv(path, header, items);
            return true;
        } catch (Exception e){
            return false;
        }

    }

}
