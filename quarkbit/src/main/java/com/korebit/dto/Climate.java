package com.korebit.dto;

public record Climate(
        double temperature,
        double humidity,
        double pressure,
        String location
) {}
