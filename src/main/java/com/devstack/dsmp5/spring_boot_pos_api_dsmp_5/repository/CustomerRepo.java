package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.repository;

import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.response.ResponseCustomerDto;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM customer WHERE name LIKE %?1% OR address LIKE %?1%", nativeQuery = true)
    Page<Customer> searchAll(String searchText, Pageable pageable);

}
