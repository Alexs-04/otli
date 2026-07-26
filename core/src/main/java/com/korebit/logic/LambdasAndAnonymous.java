package com.korebit.logic;

import java.util.function.Predicate;

public class LambdasAndAnonymous {

    public void Example() {
        // Anonymous class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from an anonymous class!");
            }
        };
        runnable.run();

        // Lambda expression
        Runnable lambdaRunnable = () -> System.out.println("Hello from a lambda expression!");
        lambdaRunnable.run();

        Predicate<Integer> predicate = x -> x > 5;
        Predicate<String> stringPredicate = str -> {
            String str2 = str.toLowerCase();
            return str2.equals(str);
        };
    }

}
