package com.peruch.hexagonal.application.core.usecase;

import com.peruch.hexagonal.application.core.domain.Customer;
import com.peruch.hexagonal.application.exception.ObjectNotFoundException;
import com.peruch.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.peruch.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    public FindCustomerByIdUseCase(
            FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    @Override
    public Customer findByCustomerId(String id) {
        return findCustomerByIdOutputPort.findByCustomerId(id).orElseThrow(
                () -> new ObjectNotFoundException(id)
        );
    }
}
