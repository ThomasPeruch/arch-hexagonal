package com.peruch.hexagonal.adapters.out;

import com.peruch.hexagonal.adapters.out.repository.CustomerRepository;
import com.peruch.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.peruch.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.peruch.hexagonal.application.core.domain.Customer;
import com.peruch.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.insert(customerEntity);
    }
}
