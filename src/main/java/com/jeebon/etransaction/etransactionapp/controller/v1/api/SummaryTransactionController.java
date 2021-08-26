package com.jeebon.etransaction.etransactionapp.controller.v1.api;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.jeebon.etransaction.etransactionapp.service.SummaryTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/summary-transaction")
public class SummaryTransactionController {

    @Autowired
    private SummaryTransactionServiceImpl summaryTransactionServiceImpl;

    @GetMapping("/import")
    public String importExcel() {
        String path = "C:\\ServerSpaces\\Java-Project\\etransactionapp\\uploads\\sumtrans.xlsx";
        summaryTransactionServiceImpl.excelToDatabase(path);
        return "Success";
    }
}
