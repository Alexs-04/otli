package com.korebit.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class HandlerClimateNotFundException implements ExceptionMapper<ClimateNotFundException> {

    @Override
    public Response toResponse(ClimateNotFundException exception) {
        return Response.status(jakarta.ws.rs.core.Response.Status.NOT_FOUND)
                .entity("Climate not found: " + exception.getMessage())
                .build();
    }
}
