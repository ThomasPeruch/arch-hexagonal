package com.peruch.hexagonal.application.core.usecase;

import com.peruch.hexagonal.application.core.domain.Address;
import com.peruch.hexagonal.application.core.domain.Customer;
import com.peruch.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.peruch.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.peruch.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class CustomerUseCase implements InsertCustomerInputPort {
    public CustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
