package com.korebit.logic;

import org.junit.jupiter.api.*;

/**
 * In this case, we will test several annotations that run before, after, and during the test.
 */
public class LifecycleTest {

    @Test
    public void testOne() {
        System.out.println("Test One");
    }

    @Test
    public void testTwo() {
        System.out.println("Test Two");
    }

    //AfterAll it is executed after all the tests, so it can be used to clean up resources that were used during the test.
    @AfterAll
    public static void afterTest() {
        System.out.println("After Test");
    }

    //BeforeAll it is executed before all the tests, so it can be used to initialize variables that will be used throughout the test.
    @BeforeAll
    public static void beforeTest() {
        System.out.println("Before Test");
    }

    //This is executed before each of the tests so it is not useful if we need to clean a static variable or global resource that needs to be cleaned
    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Before Each Test");
    }

    //This is executed at the end of each of the tests, so it can be used to clean global variables that are used during the test
    @AfterEach
    public void afterEachTest() {
        System.out.println("After Each Test");
    }
}
