package com.peruch.hexagonal.application.core.domain;

public class Customer {

    private String id;
    private String name;
    private Address address;
    private Boolean isValidCpf;
    private String cpf;

    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(String id, String name, Address address, Boolean isValidCpf, String cpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isValidCpf = isValidCpf;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Boolean getIsValidCpf() {
        return isValidCpf;
    }

    public void setIsValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
