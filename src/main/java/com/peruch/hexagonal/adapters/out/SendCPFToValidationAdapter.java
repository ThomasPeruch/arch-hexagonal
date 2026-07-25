package com.peruch.hexagonal.adapters.out;

import com.peruch.hexagonal.application.ports.out.SendCPFToValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCPFToValidationAdapter implements SendCPFToValidationOutputPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("cpf-validation", cpf);
    }
}
