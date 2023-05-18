package com.adfluence.services.likes.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Setter
@Getter
public class LikeRequest{
    private String customerId;
    private String influencerId;
}
