package com.jeebon.etransaction.etransactionapp.helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelReaderWriter {

    /*public static void main(String[] args)
    {
        ExcelReader rc=new ExcelReader();
        String vOutput=rc.GetXlxsCellData(2, 2);
        System.out.println(vOutput);
    }*/

    public static Sheet XlxsReadFirstSheet(String path)
    {
        String value=null; //variable for storing the cell value
        Workbook wb=null; //initialize Workbook null
        try {
            FileInputStream fis=new FileInputStream(path);
            wb=new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            return sheet;
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static String XlxsReadCellData(int vRow, int vColumn)
    {
        String value=null; //variable for storing the cell value
        Workbook wb=null; //initialize Workbook null
        try {
            //reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("C:\\demo\\EmployeeData.xlsx");
            //constructs an XSSFWorkbook object, by buffering the whole stream into the memory
            wb=new XSSFWorkbook(fis);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e1) {
            e1.printStackTrace();
        }
        Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index
        Row row=sheet.getRow(vRow); //returns the logical row
        Cell cell = row.getCell(vColumn); //getting the cell representing the given column
        value = cell.getStringCellValue();    //getting cell value
        return value;               //returns the cell value
    }


    public static XSSFSheet XlxsReadFirstXssSheet (String path)
    {
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            return sheet;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Float getForceFloatValue(Row row, int column){
        Cell cell = row.getCell(column);
        if(cell == null){
            return (float)0;
        }
        System.out.println("cell.getCellType()");
        System.out.println(cell.getCellType());
        switch (cell.getCellType()) {
            case STRING:
                return Float.valueOf(cell.getStringCellValue());
            case NUMERIC:
                return (float) cell.getNumericCellValue();
            case FORMULA:
                System.out.println("cell.getCachedFormulaResultType()");
                System.out.println(cell.getCachedFormulaResultType());
                switch (cell.getCachedFormulaResultType()) {
                    case STRING:
                        return Float.valueOf(cell.getStringCellValue());
                    case NUMERIC:
                        return (float) cell.getNumericCellValue();
                    default:
                        return (float)0;
                }
            default:
                return (float)0;
        }
    }

    public static String getForceStringValue(Row row, int column){
        Cell cell = row.getCell(column);

        if(cell == null){
            return "";
        }

        System.out.println("2: cell.getCellType()");
        System.out.println(cell.getCellType());
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case FORMULA:
                System.out.println("2: cell.getCachedFormulaResultType()");
                System.out.println(cell.getCachedFormulaResultType());
                switch (cell.getCachedFormulaResultType()) {
                    case STRING:
                        return cell.getStringCellValue();
                    case NUMERIC:
                        return String.valueOf(cell.getNumericCellValue());
                    default:
                        return "";
                }
            default:
                return "";
        }
    }

    public static void XlxsReadFirstSheetExample ()
    {
        try {
            File file = new File("C:\\demo\\employee.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:    //field that represents string cell type
                            System.out.print(cell.getStringCellValue() + "\t\t\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t\t");
                            break;
                        default:
                    }
                }
                System.out.println("");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}

