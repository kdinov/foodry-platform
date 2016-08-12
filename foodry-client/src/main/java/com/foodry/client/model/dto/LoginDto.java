// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

import javax.validation.constraints.NotNull;

/**
 * Login credentials.
 */
public class LoginDto {
    
    @NotNull
    private final String email;
    
    @NotNull
    private final String password;
    
    @NotNull
    private final Boolean isShopper;

    /**
     * Main constructor.
     * 
     * @param email the user's email
     * @param password the user's password
     * @param isShopper shows if the credentials are for a shopper or a customer
     */
    public LoginDto(@JsonProperty("email") String email,
                    @JsonProperty("password") String password, 
                    @JsonProperty("isShopper") Boolean isShopper) {
        this.email = email;
        this.password = password;
        this.isShopper = isShopper;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public Boolean getIsShopper() {
        return isShopper;
    }
    
    @Override
    public final int hashCode() {
        return Objects.hash(email, password, isShopper);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof LoginDto)) {
            return false;
        }

        final LoginDto other = (LoginDto) obj;
        return Objects.equals(this.email, other.email) 
                        && Objects.equals(this.password, other.password) 
                        && Objects.equals(this.isShopper, other.isShopper);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                        .append("email", email)
                        .append("password", password)
                        .append("isShopper", isShopper)
                        .toString();
    }
}
