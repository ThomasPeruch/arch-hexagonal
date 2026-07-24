package com.peruch.hexagonal.adapters.in.controller;

import com.peruch.hexagonal.adapters.in.controller.mapper.CustomerRequestMapper;
import com.peruch.hexagonal.adapters.in.controller.mapper.CustomerResponseMapper;
import com.peruch.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.peruch.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.peruch.hexagonal.application.core.domain.Customer;
import com.peruch.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.peruch.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    @Autowired
    private CustomerRequestMapper customerRequestMapper;
    @Autowired
    private CustomerResponseMapper customerResponseMapper;
    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insertCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerRequestMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> insertCustomer(@PathVariable("customerId") String customerId){
        Customer customer = findCustomerByIdInputPort.findByCustomerId(customerId);
        CustomerResponse customerResponse = customerResponseMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }
}
