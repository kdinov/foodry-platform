// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

import javax.validation.constraints.NotNull;

/**
 * Registration information DTO.
 */
public class RegisterDto {

    @NotNull
    private final String email;
    
    @NotNull
    private final String password;
    
    @NotNull
    private final String name;
    
    @NotNull
    private final String phone;
    
    @NotNull
    private final String age;
    
    @NotNull
    private final Boolean isShopper;

    /**
     * Main constructor.
     * 
     * @param email the user's email
     * @param password the user's password
     * @param name the user's names
     * @param phone the user's phone number
     * @param age the user's age
     * @param isShopper shows if the registration is for a shopper or a customer
     */
    public RegisterDto(
                    @JsonProperty("email") String email, 
                    @JsonProperty("password") String password, 
                    @JsonProperty("username") String name, 
                    @JsonProperty("phone") String phone, 
                    @JsonProperty("age") String age,
                    @JsonProperty("isShopper") Boolean isShopper) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.isShopper = isShopper;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAge() {
        return age;
    }
    
    public Boolean getIsShopper() {
        return isShopper;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(email, password, name, phone, age, isShopper);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof RegisterDto)) {
            return false;
        }

        final RegisterDto other = (RegisterDto) obj;
        return Objects.equals(this.email, other.email) 
                        && Objects.equals(this.password, other.password)
                        && Objects.equals(this.name, other.name)
                        && Objects.equals(this.phone, other.phone) 
                        && Objects.equals(this.age, other.age)
                        && Objects.equals(this.isShopper, other.isShopper);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                        .append("email", email)
                        .append("password", password)
                        .append("name", name)
                        .append("phone", phone)
                        .append("age", age)
                        .append("isShopper", isShopper)
                        .toString();
    }
}
