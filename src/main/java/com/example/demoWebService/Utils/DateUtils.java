package com.example.demoWebService.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date getDate(String dateString) throws ParseException {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = simpleDateFormat.parse(dateString);
        System.out.print(date);

        return date;

    }

    public static boolean isWithinRange(Date start, Date end, Date date) {

        return !(date.before(start) || date.after(end));

    }

}
