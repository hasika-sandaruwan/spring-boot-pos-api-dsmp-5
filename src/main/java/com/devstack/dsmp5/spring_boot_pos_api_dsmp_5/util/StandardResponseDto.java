package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.util;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardResponseDto {
    private String message;
    private int code;
    private Object data;
}
