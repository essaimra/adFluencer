package com.adfluence.services.customer.request;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Request{

    private String customerName;
    private String category;
    private String budget;
    private RegionData regionData;

}
