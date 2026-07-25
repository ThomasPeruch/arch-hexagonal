package com.peruch.hexagonal.adapters.out;

import com.peruch.hexagonal.adapters.out.repository.CustomerRepository;
import com.peruch.hexagonal.application.ports.out.DeleteCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerOutputPort {

    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
