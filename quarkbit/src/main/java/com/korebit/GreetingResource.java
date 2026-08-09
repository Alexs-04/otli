package com.korebit;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

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

    @GET
    @Path("/personalized")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") String name) {
        return Optional.ofNullable(name).orElse("No estoy seguro de que me hayas hablado");
    }

    @GET
    @Path("/{say-hello}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@PathParam("say-hello") String name) {
        return "Hello, " + name + "!";
    }
}