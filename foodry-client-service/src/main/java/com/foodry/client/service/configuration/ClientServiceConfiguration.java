// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.configuration;

import com.foodry.client.service.AccountService;
import com.foodry.client.service.impl.AccountServiceImpl;
import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;

/**
 * Spring configuration of the Client Service module.
 */
@Configuration
@PropertySource({"classpath:postgres.properties"})
public class ClientServiceConfiguration {

    @Value("${SERVER_URL:${serverUrl}}")
    private String serverUrl;

    @Value("${datasourceName}")
    private String datasourceName;
    
    @Value("${database}")
    private String database;
    
    @Value("${username}")
    private String username;
    
    @Value("${password}")
    private String password;
    
    @Value("${MAX_CONNECTIONS:${maxConnections}}")
    private String maxConnections;
    
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    /**
     * Create {@link DataSource} configuration for the PostgresDB.
     * 
     * @return a {@link DataSource} instance
     */
    @Bean
    public DataSource createDataSourceConfiguration() {
        PGPoolingDataSource pgDataSource = new PGPoolingDataSource();
        pgDataSource.setDataSourceName(datasourceName);
        pgDataSource.setServerName(serverUrl);
        pgDataSource.setDatabaseName(database);
        pgDataSource.setUser(username);
        pgDataSource.setPassword(password);
        pgDataSource.setMaxConnections(Integer.valueOf(maxConnections));
        return pgDataSource;
    }
    
    @Bean
    public AccountService createAccountService() {
        return new AccountServiceImpl();
    }
}
