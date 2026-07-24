package com.peruch.hexagonal.adapters.in.controller.mapper;

import com.peruch.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.peruch.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {

    CustomerResponse toCustomerResponse(Customer customer);
}
