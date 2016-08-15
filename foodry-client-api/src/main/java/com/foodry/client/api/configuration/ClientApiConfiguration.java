// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.api.configuration;

import com.foodry.client.api.RootResourceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration of the Client API module.
 */
@Configuration
public class ClientApiConfiguration {

    /**
     * The root resource of the API.
     * 
     * @return a {@link RootResourceImpl} instance
     */
    @Bean
    public RootResourceImpl createRootResource() {
        return new RootResourceImpl();
    }
}
