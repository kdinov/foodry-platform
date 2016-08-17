// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.service.model;

import java.util.Objects;

/**
 * A representation of an authenticated session.
 */
public class Session {
    
    private final String accountId;
    private final String token;
    
    public Session(String accountId, String token) {
        this.accountId = accountId;
        this.token = token;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getToken() {
        return token;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(accountId, token);
    }
    
    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Session)) {
            return false;
        }

        final Session other = (Session) obj;
        return Objects.equals(this.accountId, other.accountId) && Objects.equals(this.token, other.token);
    }
}
