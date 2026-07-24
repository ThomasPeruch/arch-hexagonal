package com.peruch.hexagonal.application.ports.out;

import com.peruch.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> findByCustomerId(String id);
}
