package com.korebit.service;

import com.korebit.dto.Climate;
import com.korebit.exception.ClimateNotFundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class ClimateService {
    private final List<Climate> climates = new ArrayList<>();

    public Response addClimate(Climate climate) {
        climates.add(climate);
        return Response.ok().build();
    }

    @Deprecated
    public List<Climate> getClimateList() {
        return Collections.unmodifiableList(climates);
    }

    public Climate getClimate() {
        if (climates.isEmpty()) {
            return new Climate(25.0, 60.0, 1013.0, "None");
        }
        return climates.getLast();
    }

    public void clearClimates() {
        climates.clear();
    }

    public Response getClimates() {
        if (climates.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No climate data available").build();
        } else {
            return Response.ok(climates)
                    .header("Cache-Control", "no-cache, no-store, must-revalidate")
                    .header("Pragma", "no-cache")
                    .header("Expires", "0")
                    .build();
        }
    }

    public Climate findByLocation(String location) {
        return climates.stream()
                .filter(climate -> climate.location().equalsIgnoreCase(location))
                .findFirst()
                .orElseThrow(() -> new ClimateNotFundException("Climate data not found for location: " + location));
    }
}
