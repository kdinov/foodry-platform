// Copyright (c) 2015 Travelex Ltd

package com.foodry.client.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

import javax.validation.constraints.NotNull;

/**
 * DTO that represents the authentication token.
 */
@ApiModel(value = "Session token", description = "Representation of an authenticated token.")
public class SessionTokenDto {

    @NotNull
    private final String token;

    /**
     * Main Constructor.
     */
    public SessionTokenDto(@JsonProperty("token") String token) {
        this.token = token;
    }

    /**
     * Get authentication token.
     * 
     * @return token
     */
    @ApiModelProperty("Authentication token")
    public String getToken() {
        return token;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.token);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionTokenDto)) {
            return false;
        }
        SessionTokenDto sessionTokenDto = (SessionTokenDto) obj;
        return Objects.equals(this.token, sessionTokenDto.token);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("token", token).toString();
    }

}
