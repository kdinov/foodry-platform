// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.impl;

import com.foodry.client.service.AccountService;
import com.foodry.client.service.db.PlatformDataAccess;
import com.foodry.client.service.model.Customer;
import com.foodry.client.service.model.Session;
import com.foodry.client.service.model.Shopper;

import java.util.UUID;

/**
 * An implementation of {@link AccountService}.
 */
public class AccountServiceImpl implements AccountService {

    private final PlatformDataAccess dataAccess;
    
    public AccountServiceImpl(PlatformDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    @Override
    public Session registerCustomer(Customer customer, String password) {
        customer.setPasswordHash("passwordHash");
        customer.setPasswordSalt("passwordSalt");
        dataAccess.persistCustomer(customer);
        return new Session(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

    @Override
    public Session registerShopper(Shopper shopper, String password) {
        return  new Session(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

}
