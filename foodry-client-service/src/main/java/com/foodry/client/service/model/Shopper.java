// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.model;


/**
 * A shopper representation.
 */
public class Shopper extends BaseAccount {

    /**
     * Constructor that sets all fields.
     * 
     * @param email the shopper's email
     * @param firstName the shopper's first name
     * @param lastName the shopper's last name
     * @param phone the shopper's phone
     * @param age the shopper's age
     * @param passwordHash the shopper's password hash
     * @param passwordSalt the shopper's password salt
     */
    public Shopper(String email, String firstName, String lastName, String phone, int age, String passwordHash, String passwordSalt) {
        super(email, firstName, lastName, phone, age, passwordHash, passwordSalt);
    }
    
    /**
     * Constructor that sets all fields without the password.
     * 
     * @param email the shopper's email
     * @param firstName the shopper's first name
     * @param lastName the shopper's last name
     * @param phone the shopper's phone
     * @param age the shopper's age
     */
    public Shopper(String email, String firstName, String lastName, String phone, int age) {
        this(email, firstName, lastName, phone, age, null, null);
    }
}
