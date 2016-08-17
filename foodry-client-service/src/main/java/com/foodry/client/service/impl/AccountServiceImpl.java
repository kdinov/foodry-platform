// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.impl;

import com.foodry.client.service.AccountService;
import com.foodry.client.service.model.Customer;
import com.foodry.client.service.model.Shopper;

import java.util.UUID;

/**
 * An implementation of {@link AccountService}.
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public String registerCustomer(Customer customer, String password) {
        return UUID.randomUUID().toString();
    }

    @Override
    public String registerShopper(Shopper shopper, String password) {
        return UUID.randomUUID().toString();
    }

}
