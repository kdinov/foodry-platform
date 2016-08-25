// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.api.resource;

import com.foodry.client.api.model.DtoToBoFactory;
import com.foodry.client.api.model.dto.RegisterDto;
import com.foodry.client.api.model.dto.SessionTokenDto;
import com.foodry.client.service.AccountService;
import com.foodry.client.service.model.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;

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
    
    private static final Logger LOGGER = LogManager.getLogger(RootResourceImpl.class);

    private static final String PATH = "/foodry";
    private static final String ACCOUNT = "/account";
    
    @Autowired
    private AccountService accountService;

    /**
     * No-arg constructor required by Jersey.
     */
    public RootResourceImpl() {}

    @POST
    @Path(ACCOUNT)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid RegisterDto registerDto) {
        LOGGER.debug("Received request: {}", registerDto);

        Session session = registerDto.getIsShopper() 
                        ? accountService.registerShopper(DtoToBoFactory.convertRegisterDtoToShopper(registerDto), registerDto.getPassword())
                        : accountService.registerCustomer(DtoToBoFactory.convertRegisterDtoToCustomer(registerDto), registerDto.getPassword());
                        
        return Response.created(URI.create((PATH + ACCOUNT + "/" + session.getAccountId()))).entity(new SessionTokenDto(session.getToken())).build();
    }
}
