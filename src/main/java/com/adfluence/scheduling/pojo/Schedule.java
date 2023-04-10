package com.adfluence.scheduling.pojo;

import com.adfluence.resources.loader.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Schedule extends Resource{

    private String id;
    private Region region;

}
