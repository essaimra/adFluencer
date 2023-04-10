package com.adfluence.scheduling.pojo;

import com.adfluence.resources.loader.Resource;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Schedule extends Resource{

    private String id;
    private Region region;

}
