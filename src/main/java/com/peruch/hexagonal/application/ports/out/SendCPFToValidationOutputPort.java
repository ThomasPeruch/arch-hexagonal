package com.peruch.hexagonal.application.ports.out;

public interface SendCPFToValidationOutputPort {

    void send(String cpf);
}
