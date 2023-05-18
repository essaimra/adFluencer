package com.adfluence.services.recommend.request;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class RegionData{

    private String regionName;
    private double latitude;
    private double longitude;
    private int resolution;

}
