package com.korebit.content;

import com.korebit.model.Animal;

import java.util.ArrayList;

public class ConfusedSum {
    public static void example() {
        System.out.println(1 + 2 + "3" + 4 + 5);

        var arr = new int[5];
        ArrayList<? extends Animal> a = new ArrayList<>();
        System.out.println(sum(arr));
    }

    static int sum(int... a) {
        int total = 0;
        for (int j : a) {
            total += j;
        }

        return total;
    }
}
