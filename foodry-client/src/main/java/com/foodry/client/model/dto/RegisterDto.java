// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.model.dto;

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
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    private final String phone;
    @NotNull
    private final String age;

    /**
     * Main constructor.
     * 
     * @param email the user's email
     * @param password the user's password
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param phone the user's phone number
     * @param age the user's age
     */
    public RegisterDto(
                    @JsonProperty("email") String email, 
                    @JsonProperty("password") String password, 
                    @JsonProperty("firstName") String firstName, 
                    @JsonProperty("lastName") String lastName, 
                    @JsonProperty("phone") String phone, 
                    @JsonProperty("age") String age) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
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


    public String getAge() {
        return age;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(email, password, firstName, lastName, phone, age);
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
        return Objects.equals(this.email, other.email) && Objects.equals(this.password, other.password)
                        && Objects.equals(this.firstName, other.firstName) && Objects.equals(this.lastName, other.lastName)
                        && Objects.equals(this.phone, other.phone) && Objects.equals(this.age, other.age);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("email", email).append("password", password).append("firstName", firstName).append("lastName", lastName)
                        .append("phone", phone).append("age", age).toString();
    }
}
