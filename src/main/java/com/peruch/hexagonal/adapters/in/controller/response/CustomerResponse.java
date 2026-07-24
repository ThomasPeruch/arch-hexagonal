package com.peruch.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String name;
    private AddressResponse address;
    private Boolean isValidCpf;
    private String cpf;
}
