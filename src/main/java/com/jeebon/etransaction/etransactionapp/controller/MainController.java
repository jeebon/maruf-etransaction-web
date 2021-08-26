package com.jeebon.etransaction.etransactionapp.controller;

import com.jeebon.etransaction.etransactionapp.entity.SummaryTransaction;
import com.jeebon.etransaction.etransactionapp.service.SummaryTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin()
@RestController
public class MainController {
    @Autowired
    private SummaryTransactionServiceImpl summaryTransactionServiceImpl;

    @PostMapping("/api/summary-import")
    public String uploadCsv()
    {
        return "";
    }
}
