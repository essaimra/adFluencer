package com.adfluence.customer.request;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Request{

    private String category;
    private String budget;
    private RegionData regionData;
}
