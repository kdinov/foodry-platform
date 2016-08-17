// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.model;


/**
 * Base model for all types of accounts.
 */
public abstract class BaseAccount {
    
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final int age;
    private final String passwordHash;
    private final String passwordSalt;
    
    public BaseAccount(
                    String email, 
                    String firstName, 
                    String lastName, 
                    String phone, 
                    int age, 
                    String passwordHash, 
                    String passwordSalt) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
    }

    public String getEmail() {
        return email;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }
    
    public int getAge() {
        return age;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }
    
}
