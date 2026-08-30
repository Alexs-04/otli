package com.korebit.controller;

import com.korebit.dto.LaptopAddRequest;
import com.korebit.model.Laptop;
import com.korebit.service.LaptopService;
import com.korebit.util.PaginatedResponse;
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
    public List<Laptop> findAll(@QueryParam("pageNumber") @DefaultValue("0") int pageNumber,
                                @QueryParam("pageSize") @DefaultValue("5") int pageSize) {
        return laptopService.getLaptops(pageNumber, pageSize).list();
    }

    @GET
    @Path("/paginated")
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedResponse<Laptop> findPaginated(@QueryParam("pageNumber") @DefaultValue("0") int pageNumber,
                                                   @QueryParam("pageSize") @DefaultValue("5") int pageSize) {
        return new PaginatedResponse<>(laptopService.getLaptops(pageNumber, pageSize));
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Laptop getLaptop(@QueryParam("laptopId") Long laptopId) {
        return laptopService.getLaptop(laptopId);
    }

    @DELETE
    @Path("/delete")
    public Response deleteLaptop(@QueryParam("laptopId") Long laptopId) {
        return laptopService.deleteLaptop(laptopId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response createLaptop(LaptopAddRequest request) {
        return laptopService.saveLaptop(request);
    }
}
