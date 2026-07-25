package com.peruch.hexagonal.config;

import com.peruch.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.peruch.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.peruch.hexagonal.adapters.out.InsertCustomerAdapter;
import com.peruch.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.peruch.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.peruch.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(
                findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
