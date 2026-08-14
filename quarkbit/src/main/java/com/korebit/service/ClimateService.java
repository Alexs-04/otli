package com.korebit.service;

import com.korebit.dto.Climate;
import com.korebit.dto.Response;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class ClimateService {
    private final List<Climate> climates = new ArrayList<>();

    public Response addClimate(Climate climate) {
        climates.add(climate);
        return Response.ok();
    }

    public List<Climate> getClimateList() {
        return Collections.unmodifiableList(climates);
    }

    public Climate getClimate() {
        if (climates.isEmpty()) {
            return new Climate(25.0, 60.0, 1013.0, "None");
        }
        return climates.getLast();
    }
}
