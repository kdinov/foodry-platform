// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.api.model;

import com.foodry.client.api.model.dto.RegisterDto;
import com.foodry.client.service.model.Customer;
import com.foodry.client.service.model.Shopper;

/**
 * Factory to convert DTOs to BOs.
 */
public class DtoToBoFactory {

    public static Customer convertRegisterDtoToCustomer(RegisterDto dto) {
        return null;
    }

    public static Shopper convertRegisterDtoToShopper(RegisterDto dto) {
        return new Shopper(dto.getEmail(), dto.getFirstName(), dto.getLastName(), dto.getPhone(), Integer.valueOf(dto.getAge()));
    }
}
