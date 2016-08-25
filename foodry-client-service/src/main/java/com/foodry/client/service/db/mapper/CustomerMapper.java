// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.db.mapper;

import com.foodry.client.service.model.Customer;
import org.apache.ibatis.annotations.Insert;

/**
 * MyBatis mapper for the {@link Customer}.
 */
public interface CustomerMapper {

    @Insert("INSERT INTO foodry.customer (id, email, name, phone, age, passwordhash, passwordsalt) VALUES (#{param1}, #{param2.email}, #{param2.name}, #{param2.phone}, #{param2.age}, #{param2.passwordHash}, #{param2.passwordSalt})")
    void persistCustomer(String id, Customer customers);
}
