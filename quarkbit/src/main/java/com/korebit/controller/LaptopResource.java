package com.korebit.controller;

import com.korebit.dto.LaptopAddRequest;
import com.korebit.model.Laptop;
import com.korebit.service.LaptopService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Transactional
@Path("/laptops")
public class LaptopResource {

    @Inject
    LaptopService laptopService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Laptop> findAll() {
        return laptopService.getLaptops();
    }

    @GET
    @Path("/{laptopId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Laptop getLaptop(@PathParam("laptopId") Long laptopId) {
        return laptopService.getLaptop(laptopId);
    }

    @DELETE
    @Path("/{laptopId}")
    public void deleteLaptop(@PathParam("laptopId") Long laptopId) {
        laptopService.deleteLaptop(laptopId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response createLaptop(LaptopAddRequest request) {
        return laptopService.saveLaptop(request);
    }
}
