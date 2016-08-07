// Copyright (c) 2016 Foodry Ltd

package com.foodry.client.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Main API.
 */
@Path("/user")
public class ClientResourceImpl {
    
    @POST
    @Path("/account")
    public Response register() {
        return Response.accepted().build();
    }
}
