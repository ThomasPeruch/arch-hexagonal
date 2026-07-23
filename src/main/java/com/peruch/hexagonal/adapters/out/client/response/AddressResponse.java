package com.peruch.hexagonal.adapters.out.client.response;

import lombok.Data;

@Data
public class AddressResponse {
    private String city;
    private String street;
    private String state;

}
