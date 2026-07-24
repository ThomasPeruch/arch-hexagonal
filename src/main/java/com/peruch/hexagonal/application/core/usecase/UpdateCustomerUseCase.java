package com.peruch.hexagonal.application.core.usecase;

import com.peruch.hexagonal.application.core.domain.Address;
import com.peruch.hexagonal.application.core.domain.Customer;
import com.peruch.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.peruch.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.peruch.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.peruch.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import com.peruch.hexagonal.application.ports.out.UpdateCustomerOutputPort;

import java.util.Optional;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    @Override
    public void update(String zipCode, Customer customer) {
        Customer optionalCustomer = findCustomerByIdInputPort.findByCustomerId(customer.getId());
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        optionalCustomer.setAddress(address);
        updateCustomerOutputPort.update(optionalCustomer);
    }

}
