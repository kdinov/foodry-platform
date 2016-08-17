// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service;

import com.foodry.client.service.model.Customer;
import com.foodry.client.service.model.Session;
import com.foodry.client.service.model.Shopper;

/**
 * API for the account service.
 */
public interface AccountService {

    /**
     * Register a customer.
     * 
     * @param customer the customer details
     * @param password the customer password
     * @return a {@link Session} for that customer
     */
    Session registerCustomer(Customer customer, String password);
    
    /**
     * Register a shopper.
     * 
     * @param shopper the shopper details
     * @param password the shopper password
     * @return a {@link Session} for that shopper
     */
    Session registerShopper(Shopper shopper, String password);
}
