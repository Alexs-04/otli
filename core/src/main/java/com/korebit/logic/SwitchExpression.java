package com.korebit.logic;

import java.util.Random;

public class SwitchExpression {

    public void ExampleSwitchExpression() {

        int number = new Random().nextInt(4);
        // Generates a random number between 0 and 3
        System.out.println(number);

        String result = switch (number) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            default -> "Unknown";
        };
        System.out.println(result);

        // Using a block in a switch expression
        String resultWithBlock = switch (number) {
            case 1 -> {
                System.out.println("Processing case 1");
                yield "One";
            }
            case 2 -> {
                System.out.println("Processing case 2");
                yield "Two";
            }
            default -> {
                System.out.println("Processing default case");
                yield "Unknown";
            }
        };
        System.out.println(resultWithBlock);
    }
}