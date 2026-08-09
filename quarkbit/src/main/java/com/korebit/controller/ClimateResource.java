package com.korebit.controller;

import com.korebit.dto.Climate;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/climate")
public class ClimateResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Climate getClimate() {
        return new Climate(25.0, 60.0, 1013.0);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(("/list"))
    public List<Climate> getClimateList() {
        List<Climate> climates = new ArrayList<Climate>();
        climates.add(new Climate(25.0, 60.0, 1013.0));
        climates.add(new Climate(26.0, 65.0, 1014.0));
        return climates;
    }
}
