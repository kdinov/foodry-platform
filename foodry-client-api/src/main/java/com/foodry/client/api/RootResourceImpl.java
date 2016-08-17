// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.api;

import com.foodry.client.api.model.DtoToBoFactory;
import com.foodry.client.api.model.dto.RegisterDto;
import com.foodry.client.api.model.dto.SessionTokenDto;
import com.foodry.client.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

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
@Path("/")
public class RootResourceImpl {

    @Autowired
    private AccountService accountService;

    /**
     * No-arg constructor required by Jersey.
     */
    public RootResourceImpl() {}

    @POST
    @Path("/account")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid RegisterDto registerDto) {
        System.out.println("Received request: " + registerDto.toString());

        String token = registerDto.getIsShopper() 
                        ? accountService.registerShopper(DtoToBoFactory.convertRegisterDtoToShopper(registerDto), registerDto.getPassword())
                        : accountService.registerCustomer(DtoToBoFactory.convertRegisterDtoToCustomer(registerDto), registerDto.getPassword());
                        
        return Response.ok(new SessionTokenDto(token)).build();
    }
}
