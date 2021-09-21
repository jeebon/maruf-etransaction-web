package com.jeebon.etransaction.etransactionapp.controller.v1.api;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jeebon.etransaction.etransactionapp.entity.Portfolio;
import com.jeebon.etransaction.etransactionapp.entity.SummaryTransaction;
import com.jeebon.etransaction.etransactionapp.service.CommonServiceImpl;
import com.jeebon.etransaction.etransactionapp.service.DetailsTransactionServiceImpl;
import com.jeebon.etransaction.etransactionapp.service.SummaryTransactionServiceImpl;
import com.jeebon.etransaction.etransactionapp.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/summary-transaction")
public class SummaryTransactionController {

    @Autowired
    private SummaryTransactionServiceImpl summaryTransactionServiceImpl;

    @Autowired
    private CommonServiceImpl commonServiceImpl;

    @Autowired
    private DetailsTransactionServiceImpl detailsTransactionServiceImpl;

    @GetMapping("/import")
    public String importExcel() {
        String path = "uploads\\sample_20210606.xlsx";
        List<SummaryTransaction> list =  summaryTransactionServiceImpl.excelToDatabase(path);

        String date = CommonUtils.SummaryTransactionFilenameToStringDate(path);

        String dpath = "downloads\\export.csv";

        List<Portfolio> portfolios = commonServiceImpl.getPortfolios();

        detailsTransactionServiceImpl.detailsTransExportToCsv(dpath, date, portfolios, list);
        return "Success";
    }

    @GetMapping("/export")
    public void ExportCsv(HttpSession session, HttpServletResponse response) {

        String dpath = "downloads\\export.csv";
        try {
            CommonUtils.downloadAsCsv(session, response, dpath, "outputfile.csv");
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
