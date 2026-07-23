package com.peruch.hexagonal.application.ports.out;

import com.peruch.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    public Address find(String zipCode);

}
