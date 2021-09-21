package com.jeebon.etransaction.etransactionapp.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class CommonUtils {
    public static String SummaryTransactionFilenameToStringDate(String filePath){
        File f = new File(filePath);
        String fileName = f.getName();
        List<String> names =   Arrays.asList(fileName.split("_").clone());
        if(names.size() > 1) {
            String first = names.get(1);
            List<String> fristNames =   Arrays.asList(first.split("20").clone());
            if(fristNames.size() > 1) {
                return "20" + fristNames.get(1);
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    public static void downloadAsCsv(HttpSession session, HttpServletResponse response, String sourceFile, String name ) throws Exception {
        try {

            File fileToDownload = new File(sourceFile);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename="+name);
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Boolean isFileExist(String Path, String initialFileName, String extension) {
        final File folder = new File(Path);
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                if(fileEntry.getName().contains(extension) && fileEntry.getName().contains(initialFileName)){
                    return true;
                }
            }
        }
        return false;
    }
}
