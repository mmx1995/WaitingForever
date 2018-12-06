package com.mmxin;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

    @Test
    public void DateTest(){
        Date date = new Date();
        String fromDateString =  new java.sql.Date(date.getTime()).toString().replace("-","");
        System.out.println(fromDateString);
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        Date toDate = calendar.getTime();
        String toDateString  = new java.sql.Date(toDate.getTime()).toString().replace("-","");
        System.out.println(toDateString);
    }

}
