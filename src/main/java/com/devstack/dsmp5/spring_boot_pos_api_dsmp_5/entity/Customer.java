package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="customer")
@Builder
public class Customer {
    @Id
    @Column(name="customer_id", length = 80)
    private String id;
    @Column(name="customer_name", length = 50)
    private String name;
    @Column(name="customer_email", length = 100, unique = true)
    private String email;
    @Column(name="customer_address", length = 50)
    private String address;
    @Column(name="customer_salary")
    private double salary;
}
