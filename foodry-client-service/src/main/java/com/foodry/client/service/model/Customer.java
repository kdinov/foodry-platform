// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.model;


/**
 * A customer representation.
 */
public class Customer extends BaseAccount {

    /**
     * Constructor that sets all fields.
     * 
     * @param email the customer's email
     * @param name the customer's name
     * @param phone the customer's phone
     * @param age the customer's age
     * @param passwordHash the customer's password hash
     * @param passwordSalt the customer's password salt
     */
    public Customer(String email, String name, String phone, int age, String passwordHash, String passwordSalt) {
        super(email, name, phone, age, passwordHash, passwordSalt);
    }

    /**
     * Constructor that sets all fields.
     * 
     * @param email the customer's email
     * @param name the customer's name
     * @param phone the customer's phone
     * @param age the customer's age
     */
    public Customer(String email, String name, String phone, int age) {
        this(email, name, phone, age, null, null);
    }
}
