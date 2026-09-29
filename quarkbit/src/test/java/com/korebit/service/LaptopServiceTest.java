package com.korebit.service;

import com.korebit.dto.LaptopAddRequest;
import com.korebit.exception.ClimateNotFundException;
import com.korebit.model.enums.CPU;
import com.korebit.model.enums.Trademark;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class LaptopServiceTest {
    @Inject
    LaptopService laptopService;

    @Test
    void getLaptopInfo() throws ClimateNotFundException {
        var res = laptopService.saveLaptop(new LaptopAddRequest(
                "",
                Trademark.Asus,
                "",
                CPU.AMD,
                false,
                100D
        ));

        //assertThrowsExactly();
    }
}
