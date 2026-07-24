package com.korebit.content.shop;

import com.korebit.model.store.CarShop;
import com.korebit.model.store.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * These are examples whose sole purpose is to understand how the JUnit 5 testing framework works, so if some tests seem strange, they don't actually make sense.
 */
public class TestShop {

    /**
     * For example, this test will fail because if we check what the code says directly, the sums of what is expected versus what is actually not the same.
     */
    @Test
    public void testTotalPrice() {
        var carShop = new CarShop(List.of(
                new Product("Car A", 10000.0),
                new Product("Car B", 15000.0),
                new Product("Car C", 20000.0)
        ));

        //It works perfectly.
        assertNotNull(carShop);
        //This will fail because the total price of the products is 45000.0, not 10000.0.
        assertEquals(45000.0, carShop.getTotalPrice());
        assertEquals(454676D, carShop.getTotalPrice());
    }

    public void anyCarShop() {
        var carShop = new CarShop(List.of(
                new Product("Car A", 10000.0),
                new Product("Car B", 15000.0),
                new Product("Car C", 20000.0)
        ));

        assertAll(
                () -> assertNotNull(carShop),
                () -> assertEquals(carShop.getTotalPrice(), 10000.0),
                () -> assertEquals(454676D, carShop.getTotalPrice())
        );
    }

}