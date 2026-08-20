package com.korebit.exception;

import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class HandlerLaptopException implements ExceptionMapper<LaptopNotFundException> {
    @Override
    public Response toResponse(LaptopNotFundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Laptop not found: " + exception.getMessage())
                .build();
    }
}
