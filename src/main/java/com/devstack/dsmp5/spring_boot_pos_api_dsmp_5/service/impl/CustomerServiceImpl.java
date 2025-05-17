package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.service.impl;

import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.request.RequestCustomerDto;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.response.ResponseCustomerDto;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.response.paginate.PaginateCustomerDto;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.entity.Customer;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.exception.EntryNotFoundException;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.repository.CustomerRepo;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    @Override
    public void save(RequestCustomerDto dto) {
        customerRepo.save(toCustomer(dto));
    }

    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
    }

    @Override
    public ResponseCustomerDto findById(String id) {
        return toResponseCustomerDto(customerRepo.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Customer Not Found")));
    }

    @Override
    public void updateById(RequestCustomerDto dto, String id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new EntryNotFoundException("Customer Not Found"));
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setAddress(dto.getAddress());
        customer.setSalary(dto.getSalary());
        customerRepo.save(customer);
    }

    @Override
    public PaginateCustomerDto search(String searchText, int page, int size) {
        Page<Customer> customerList =
                customerRepo.searchAll(searchText, PageRequest.of(page, size));
        //List<ResponseCustomerDto> dtos = new ArrayList<>();
       /* for(Customer c: customerList){
            ResponseCustomerDto responseCustomerDto = toResponseCustomerDto(c);
            dtos.add(responseCustomerDto);
        }
        return PaginateCustomerDto.builder()
                .dataList(
                        dtos
                )
                .count(
                        customerList.getTotalElements()
                )
                .build();*/
        return PaginateCustomerDto.builder()
                .dataList(customerList.stream().map(this::toResponseCustomerDto).toList())
                .count(customerList.getTotalElements())
                .build();
    }

    private Customer toCustomer(RequestCustomerDto dto) {
        if (dto == null) return null;
        return Customer.builder()
                .id(UUID.randomUUID().toString())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .name(dto.getName())
                .salary(dto.getSalary())
                .build();
    }

    private ResponseCustomerDto toResponseCustomerDto(Customer customer) {
        if (customer == null) return null;
        return ResponseCustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .salary(customer.getSalary())
                .build();
    }

}
