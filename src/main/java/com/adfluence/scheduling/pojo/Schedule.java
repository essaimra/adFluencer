package com.adfluence.scheduling.pojo;

import com.adfluence.resources.loader.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Schedule extends Resource{

    private String id;
    private Region region;

}
