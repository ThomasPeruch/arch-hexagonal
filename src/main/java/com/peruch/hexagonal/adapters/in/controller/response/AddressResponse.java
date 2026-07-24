package com.peruch.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class AddressResponse {
    private String city;
    private String street;
    private String state;
}
