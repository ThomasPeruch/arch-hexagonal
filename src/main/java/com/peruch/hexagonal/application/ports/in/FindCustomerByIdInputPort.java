package com.peruch.hexagonal.application.ports.in;

import com.peruch.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer findByCustomerId(String id);
}
