package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.service;

import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.request.RequestCustomerDto;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.response.ResponseCustomerDto;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.response.paginate.PaginateCustomerDto;

public interface CustomerService {
    public void save(RequestCustomerDto dto);
    public void delete(String id);
    public ResponseCustomerDto findById(String id);
    public void updateById(RequestCustomerDto dto, String id);
    public PaginateCustomerDto search(String searchText, int page, int size);
}
