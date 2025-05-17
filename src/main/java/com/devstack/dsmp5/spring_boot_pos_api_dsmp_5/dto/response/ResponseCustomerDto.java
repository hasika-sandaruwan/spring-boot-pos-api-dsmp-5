package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCustomerDto {
    private String id;
    private String name;
    private String address;
    private String email;
    private double salary;
}
