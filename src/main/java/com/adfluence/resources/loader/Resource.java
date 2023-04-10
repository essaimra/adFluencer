package com.adfluence.resources.loader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Resource{

    protected String startTime;

    public String getStartTime() {
        return startTime;
    }

    public Date getDate(){
        final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_PATTERN);
        Date date = null;
        try {
            date = dateFormat.parse(startTime);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
