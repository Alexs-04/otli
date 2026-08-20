package com.korebit.dto;

import com.korebit.model.enums.CPU;
import com.korebit.model.enums.Trademark;

public record LaptopAddRequest(
        String name,
        Trademark trademark,
        String model,
        CPU cpu,
        Boolean isTouchScreen
) { }
