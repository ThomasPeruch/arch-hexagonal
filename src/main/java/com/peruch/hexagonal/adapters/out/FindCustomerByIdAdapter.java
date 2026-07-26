package com.peruch.hexagonal.adapters.out;

import com.peruch.hexagonal.adapters.out.repository.CustomerRepository;
import com.peruch.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.peruch.hexagonal.application.core.domain.Customer;
import com.peruch.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> findByCustomerId(String id) {
        return customerRepository.findById(id).map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
