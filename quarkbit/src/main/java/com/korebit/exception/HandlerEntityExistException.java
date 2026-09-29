package com.korebit.exception;

import jakarta.persistence.EntityExistsException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class HandlerEntityExistException implements ExceptionMapper<EntityExistsException> {

    @Override
    public Response toResponse(EntityExistsException exception) {
        return Response.status(Response.Status.CONFLICT)
                .entity(exception.getMessage())
                .build();
    }
}
