package com.peruch.hexagonal.application.core.usecase;

import com.peruch.hexagonal.application.core.domain.Address;
import com.peruch.hexagonal.application.core.domain.Customer;
import com.peruch.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.peruch.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.peruch.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.peruch.hexagonal.application.ports.out.SendCPFToValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCPFToValidationOutputPort sendCPFToValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCPFToValidationOutputPort = sendCPFToValidationOutputPort;
    }

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCPFToValidationOutputPort sendCPFToValidationOutputPort;

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCPFToValidationOutputPort.send(customer.getCpf());
    }
}
