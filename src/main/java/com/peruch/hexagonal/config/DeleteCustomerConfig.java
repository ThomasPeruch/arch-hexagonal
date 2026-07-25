package com.peruch.hexagonal.config;

import com.peruch.hexagonal.adapters.out.DeleteCustomerAdapter;
import com.peruch.hexagonal.application.core.usecase.DeleteCustomerUseCase;
import com.peruch.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(
            DeleteCustomerAdapter deleteCustomerAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase
    ) {
        return new DeleteCustomerUseCase(deleteCustomerAdapter, findCustomerByIdUseCase);
    }
}
