package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCustomerDto {
    private String name;
    private String email;
    private String address;
    private double salary;
}
