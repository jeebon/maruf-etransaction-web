package com.jeebon.etransaction.etransactionapp.service;


import com.jeebon.etransaction.etransactionapp.entity.Holiday;
import com.jeebon.etransaction.etransactionapp.entity.Portfolio;
import com.jeebon.etransaction.etransactionapp.repository.HolidayRepository;
import com.jeebon.etransaction.etransactionapp.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommonServiceImpl implements CommonService{
    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private PortfolioRepository portfolioRepository;

    public String getLastBusinessDateByCurrentDate(String currentDate)
    {
        if(currentDate.isEmpty()){
            return "";
        }
        try{
            List<Holiday> items = holidayRepository.findByPresentDate(currentDate);
            if(items.isEmpty()){
                return "";
            }
            return items.get(0).getBusinessDate();
        } catch (Exception e){
            return "";
        }
    }

    public List<Portfolio> getPortfolios()
    {
        try{
            return portfolioRepository.findAll();
        } catch (Exception e){
            return new ArrayList<>();
        }
    }

}
