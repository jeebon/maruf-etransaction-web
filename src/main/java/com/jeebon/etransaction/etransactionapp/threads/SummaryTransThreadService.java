package com.jeebon.etransaction.etransactionapp.threads;

import com.jeebon.etransaction.etransactionapp.entity.Portfolio;
import com.jeebon.etransaction.etransactionapp.entity.SummaryTransaction;
import com.jeebon.etransaction.etransactionapp.service.CommonServiceImpl;
import com.jeebon.etransaction.etransactionapp.service.DetailsTransactionServiceImpl;
import com.jeebon.etransaction.etransactionapp.service.SummaryTransactionServiceImpl;
import com.jeebon.etransaction.etransactionapp.util.CommonUtils;
import com.jeebon.etransaction.etransactionapp.util.DateUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

@Service
public class SummaryTransThreadService {
    SummaryTransactionServiceImpl summaryTransactionServiceImpl;
    CommonServiceImpl commonServiceImpl;
    DetailsTransactionServiceImpl detailsTransactionServiceImpl;

    SummaryTransThreadService(
            SummaryTransactionServiceImpl summaryTransactionServiceImpl,
            CommonServiceImpl commonServiceImpl,
            DetailsTransactionServiceImpl detailsTransactionServiceImpl
    ){
        this.summaryTransactionServiceImpl = summaryTransactionServiceImpl;
        this.commonServiceImpl = commonServiceImpl;
        this.detailsTransactionServiceImpl = detailsTransactionServiceImpl;
    }

    @Async
    public void init() throws InterruptedException {
        try {
            String uploadFileDir = "uploads";
            String movedFileDir = "downloads";
            String csvEportPath = "downloads\\" + DateUtils.formattedDateTime("yyyyMMdd")+".csv";
            String csvEportPath2 = "downloads\\" + DateUtils.formattedDateTime("yyyyMMdd")+"_2nd.csv";
            String fileExtension = ".xlsx";
            String uploadFileUri = "";
            String movedFileUri= "";
            String fileName;
            Boolean doContinue = true;
            try {
                while (doContinue) {
                    //fileName = "sample_" + DateUtils.formattedDateTime("yyyyMMdd");
                    fileName = "FILE_Name202106_NAME20210709_111931";


                    Boolean exist = CommonUtils.isFileExist(uploadFileDir, fileName, ".xlsx");

                    if(exist) {
                        uploadFileUri = uploadFileDir + "\\" + fileName + fileExtension;
                        movedFileUri = movedFileDir + "\\" + fileName + fileExtension;
                        doContinue = false;
                    } else {
                        Thread.sleep(10 * 1000);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Error-Init-1:");
                System.out.println(e);
            }
            System.out.println("File: " + uploadFileUri);
            System.out.println("Importing file: " + DateUtils.today().getTime());
            List<SummaryTransaction> list =  summaryTransactionServiceImpl.excelToDatabase(uploadFileUri);
            //            Path temp = Files.move(Paths.get(uploadFileUri), Paths.get(movedFileUri));
            //            if(temp != null) {
            //                System.out.println("File renamed and moved successfully");
            //            } else {
            //                System.out.println("Failed to move the file");
            //            }


            String shortDate = CommonUtils.SummaryTransactionFilenameToStringDate(uploadFileUri);
            System.out.println("shortDate: ");
            System.out.println(shortDate);

            System.out.println("uploadFileUri: ");
            System.out.println(uploadFileUri);


            String date = "";
            if(shortDate.isEmpty()){
                date = DateUtils.lastDateOfMonth(DateUtils.today(), "MM/dd/yyyy");
            } else {
                String fileDate = shortDate.substring(0,4) + "-" + shortDate.substring(4) + "-01";
                date = DateUtils.lastDateOfMonth(DateUtils.stringToDate("yyyy-MM-dd", fileDate), "MM/dd/yyyy");
            }
            System.out.println("date: ");
            System.out.println(date);

            List<Portfolio> portfolios = commonServiceImpl.getPortfolios();
            detailsTransactionServiceImpl.detailsTransExportToCsv(csvEportPath, date, portfolios, list);
            detailsTransactionServiceImpl.detailsTransExtendedExportToCsv(csvEportPath2, date, portfolios, list);
        } catch (Exception e){
            System.out.println("Error-Init:");
            System.out.println(e);
        }

    }
}
