package com.korebit.logic;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestingTest {
    @Nested
    class A {
        @Test
        public void methodA() {
            System.out.println("Method A");
        }
    }

    @Nested
    class B {
        @Test
        public void methodB() {
            System.out.println("Method B");
        }

        @Test
        public void methodC() {
            System.out.println("Method C");
        }
    }
}
