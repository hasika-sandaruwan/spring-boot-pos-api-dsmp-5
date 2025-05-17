package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.api;

import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public void create(){}
    public void findById(){}
    public void updateById(){}
    public void deleteById(){}
    public void searchAll(){}

}
