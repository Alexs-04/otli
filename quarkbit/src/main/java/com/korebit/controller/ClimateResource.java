package com.korebit.controller;

import com.korebit.dto.Climate;
import com.korebit.dto.Response;
import com.korebit.service.ClimateService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/climate")
public class ClimateResource {

    private final ClimateService climateService;

    @Inject
    public ClimateResource(ClimateService climateService) {
        this.climateService = climateService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Climate getClimate() {
        return climateService.getClimate();
    }

    @GET
    @Path(("/list"))
    @Produces(MediaType.APPLICATION_JSON)
    public List<Climate> getClimateList() {
        return climateService.getClimateList();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addClimate(Climate climate) {
        return climateService.addClimate(climate);
    }
}
