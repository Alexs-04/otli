package com.korebit.dto;

import com.korebit.model.enums.CPU;
import com.korebit.model.enums.Trademark;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record LaptopAddRequest(
        @NotBlank String name,
        Trademark trademark,
        String model,
        CPU cpu,
        Boolean isTouchScreen,
        @Positive @Min(0) Double price
) {}
