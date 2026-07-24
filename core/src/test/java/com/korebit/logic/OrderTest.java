package com.korebit.logic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * In this case we will test the order of execution of the tests, since by default the order of execution is not guaranteed, we can use the @TestMethodOrder annotation to specify the order of execution of the tests.
 * <p>
 * There are several ways to order the tests, one of them is to use the @Order annotation,
 * which allows us to specify the order of execution of the tests, the lower the number, the earlier it will be executed.
 * Another way is to use the @TestMethodOrder annotation with the MethodOrderer.OrderAnnotation class, which allows us to specify the order of execution of the tests using the @Order annotation.
 * </p>
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.Random.class)
public class OrderTest {

    @Test
    @Order(2)
    public void testOrder() {
        System.out.println("Test Order");
    }

    @Test
    @Order(1)
    public void testMethod() {
        System.out.println("Test Method");
    }

    @Test
    @Order(3)
    public void testClassMethod() {
        System.out.println("Test ClassMethod");
    }
}
