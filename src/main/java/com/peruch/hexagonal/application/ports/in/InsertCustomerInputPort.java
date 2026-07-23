package com.peruch.hexagonal.application.ports.in;

import com.peruch.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
