package com.korebit;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hola desde Quarkus";
    }

    @GET
    @Path("/good-morning")
    @Produces(MediaType.TEXT_PLAIN)
    public String goodMorning() {
        return "Buenos días";
    }

    @GET
    @Path("/good-night")
    @Produces(MediaType.APPLICATION_JSON)
    public String goodNight() {
        return "Buenas noches";
    }
}