package com.peruch.hexagonal.application.core.usecase;

import com.peruch.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.peruch.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.peruch.hexagonal.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    public DeleteCustomerUseCase(
            DeleteCustomerOutputPort deleteCustomerOutputPort,
            FindCustomerByIdInputPort findCustomerByIdInputPort) {
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Override
    public void delete(String customerId){
        findCustomerByIdInputPort.findByCustomerId(customerId);
        deleteCustomerOutputPort.delete(customerId);
    }
}
