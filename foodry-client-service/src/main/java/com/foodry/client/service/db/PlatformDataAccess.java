// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.db;

import com.foodry.client.service.db.mapper.CustomerMapper;
import com.foodry.client.service.model.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.UUID;

/**
 * A class that manages the db interactions.
 */
public class PlatformDataAccess {

    private final SqlSessionFactory sessionFactory;
    
    public PlatformDataAccess(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void persistCustomer(Customer customer) {
        try(SqlSession session = sessionFactory.openSession();) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            mapper.persistCustomer(UUID.randomUUID().toString(), customer);
        }
        
    }

}