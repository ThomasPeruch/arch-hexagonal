package com.peruch.hexagonal.adapters.in.consumer;

import com.peruch.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.peruch.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.peruch.hexagonal.application.core.domain.Customer;
import com.peruch.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidCPFConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "valid-cpf", groupId = "hexa-group-test")
    public void receive(CustomerMessage customerMessage) {
        Customer customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customerMessage.getZipCode(), customer);
    }
}
