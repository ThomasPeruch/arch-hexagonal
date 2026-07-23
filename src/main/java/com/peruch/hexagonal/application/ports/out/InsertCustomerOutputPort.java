package com.peruch.hexagonal.application.ports.out;

import com.peruch.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
