package com.peruch.hexagonal.application.ports.out;

import com.peruch.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
