// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.model;


/**
 * Base model for all types of accounts.
 */
public abstract class BaseAccount {
    
    private final String email;
    private final String name;
    private final String phone;
    private final int age;
    private final String passwordHash;
    private final String passwordSalt;
    
    public BaseAccount(
                    String email, 
                    String name, 
                    String phone, 
                    int age, 
                    String passwordHash, 
                    String passwordSalt) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
    }

    public String getEmail() {
        return email;
    }
    
    public String getName() {
        return name;
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
