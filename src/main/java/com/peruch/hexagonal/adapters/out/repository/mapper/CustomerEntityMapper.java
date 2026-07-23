package com.peruch.hexagonal.adapters.out.repository.mapper;

import com.peruch.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.peruch.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
