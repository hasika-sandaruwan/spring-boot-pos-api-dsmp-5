package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.response.paginate;

import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.response.ResponseCustomerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginateCustomerDto {
    private long count;
    private List<ResponseCustomerDto> dataList;
}
