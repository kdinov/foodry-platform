// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.api;

import com.foodry.client.api.model.dto.RegisterDto;
import com.foodry.client.api.model.dto.SessionTokenDto;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.UUID;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Main API.
 */
@Component
@Path("/user")
public class RootResourceImpl {

    @POST
    @Path("/account")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid RegisterDto registerDto) {
        System.out.println("Received request: " + registerDto.toString());

        return Response.created(URI.create("/user/account/" + UUID.randomUUID().toString()))
                        .entity(new SessionTokenDto("YOU RECEIVED A TOKEN!"))
                        .build();
    }
}
