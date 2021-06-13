package com.example.MarvelAPIApp.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    DateUtils() {

    }

    public static String convertDateToString(Date conversionDate, String format) {
        String dateString = null;
        if (null != conversionDate) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dateString = sdf.format(conversionDate);
        }
        return dateString;
    }

    public static int compareDate(Date date1,Date date2){

        return date1.compareTo(date2);

    }

}
