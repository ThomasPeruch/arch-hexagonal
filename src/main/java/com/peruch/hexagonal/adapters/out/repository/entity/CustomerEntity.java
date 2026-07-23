package com.peruch.hexagonal.adapters.out.repository.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@Data
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private AddressEntity address;
    private Boolean isValidCpf;
    private String cpf;
}
