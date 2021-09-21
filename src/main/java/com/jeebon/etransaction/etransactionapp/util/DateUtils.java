package com.jeebon.etransaction.etransactionapp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat sdfCreate(String format){
        return new SimpleDateFormat(format);
    }
    /**
     * Returns today's date as java.util.Date object
     *
     * @return today's date as java.util.Date object
     */
    public static Date today() {
        return new Date();
    }

    /**
     * Returns today's date as yyyy-MM-dd format
     *
     * @return today's date as yyyy-MM-dd format
     */
    public static String todayStr(String df) {
        if(df != null){
            return sdfCreate(df).format(today());
        }
        return sdf.format(today());
    }

    /**
     * Returns the formatted String date for the passed java.util.Date object
     *
     * @param date
     * @return
     */
    public static String formattedDate(Date date, String df) {
        if(df != null){
            return date != null ? sdfCreate(df).format(date) : todayStr(null);
        }
        return date != null ? sdf.format(date) : todayStr(null);
    }

    public static String formattedDateTime(String df){
        return sdfCreate(df).format(Calendar.getInstance().getTime());
    }

    public static String lastDateOfMonth(Date date, String df){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int lastDate = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DATE, lastDate);
        return sdfCreate(df).format(calendar.getTime());
    }

    public static Date stringToDate(String df, String dateStr){
        try {
            DateFormat formatter = new SimpleDateFormat(df);
            return formatter.parse(dateStr);
        } catch (Exception e){
            return null;
        }

    }

}
