package com.peruch.hexagonal.application.core.domain;

import org.apache.kafka.common.protocol.types.Field;

public class Customer {

    private String name;
    private Address address;
    private Boolean isValidCpf;
    private String cpf;

    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(String name, Address address, Boolean isValidCpf, String cpf) {
        this.name = name;
        this.address = address;
        this.isValidCpf = isValidCpf;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
