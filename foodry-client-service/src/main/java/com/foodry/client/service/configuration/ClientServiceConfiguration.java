// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.configuration;

import com.foodry.client.service.AccountService;
import com.foodry.client.service.db.PlatformDataAccess;
import com.foodry.client.service.impl.AccountServiceImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

/**
 * Spring configuration of the Client Service module.
 */
@Configuration
@PropertySource({"classpath:postgres.properties"})
@MapperScan("com.foodry.client.service.db.mapper")
public class ClientServiceConfiguration {

    @Value("${SERVER_URL:${serverUrl}}")
    private String serverUrl;

    @Value("${datasourceName}")
    private String datasourceName;
    
    @Value("${driverClass}")
    private String driverClass;
    
    @Value("${username}")
    private String username;
    
    @Value("${password}")
    private String password;
    
    @Value("${MAX_CONNECTIONS:${maxConnections}}")
    private int maxConnections;
    
    @Value("${maxStatements}")
    private int maxStatements;
    
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
    public DataSource createDataSourceConfiguration() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(serverUrl);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setMaxPoolSize(maxConnections);
        dataSource.setMaxStatements(maxStatements);
        dataSource.setTestConnectionOnCheckout(true);
        dataSource.setDataSourceName(datasourceName);

        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory createSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(createDataSourceConfiguration());
        
        return factoryBean.getObject();
    }
    
    @Bean
    public AccountService createAccountService() throws Exception {
        return new AccountServiceImpl(createDataAccess());
    }
    
    @Bean 
    public PlatformDataAccess createDataAccess() throws Exception {
        return new PlatformDataAccess(createSqlSessionFactory());
    }
}
