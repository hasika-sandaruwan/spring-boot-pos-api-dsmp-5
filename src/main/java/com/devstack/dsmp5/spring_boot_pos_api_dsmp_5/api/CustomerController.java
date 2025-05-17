package com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.api;

import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.dto.request.RequestCustomerDto;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.service.CustomerService;
import com.devstack.dsmp5.spring_boot_pos_api_dsmp_5.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// http://localhost:5050/api/v1/customers/create-customer
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create-customer")
    public ResponseEntity<StandardResponseDto> create(
            @RequestBody RequestCustomerDto dto
    ){
       customerService.save(dto);
       return new ResponseEntity<>(
               new StandardResponseDto(
                       "customer saved",201,null
               ), HttpStatus.CREATED
       );
    }

    @GetMapping("/find-customer/{id}")
    public ResponseEntity<StandardResponseDto> findById(
            @PathVariable String id
    ){

        return new ResponseEntity<>(
                new StandardResponseDto(
                        "customer found",200,customerService.findById(id)
                ), HttpStatus.OK
        );
    }
    @PutMapping("update-customer/{id}")
    public ResponseEntity<StandardResponseDto> updateById(
            @PathVariable String id,
            @RequestBody RequestCustomerDto dto
    ){
        customerService.updateById(dto, id);
        return new ResponseEntity<>(
                new StandardResponseDto(
                        "customer updated",201,null
                ), HttpStatus.CREATED
        );
    }
    @DeleteMapping("/delete-customer/{id}")
    public ResponseEntity<StandardResponseDto> deleteById(
            @PathVariable String id
    ){
        customerService.delete(id);
        return new ResponseEntity<>(
                new StandardResponseDto(
                        "customer deleted",204,null
                ), HttpStatus.NO_CONTENT
        );
    }
    @GetMapping("search-customers")
    public ResponseEntity<StandardResponseDto> searchAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponseDto(
                        "customer list",200,customerService.search(searchText, page, size)
                ), HttpStatus.OK
        );
    }
}
