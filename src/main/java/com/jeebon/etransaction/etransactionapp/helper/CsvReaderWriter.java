package com.jeebon.etransaction.etransactionapp.helper;
import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvReaderWriter {

    public static Boolean writeCsv(String path, String[] header, List<String[]> rows) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter( path));
        try (final CSVWriter cSVWriter = new CSVWriter(writer)) {
            cSVWriter.writeNext(header);
            rows.forEach(row -> {
                cSVWriter.writeNext(row);
            });
            cSVWriter.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
