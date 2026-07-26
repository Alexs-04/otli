package com.korebit.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateAndFunctional {

    public void example() {
        //Function<String, Integer> f = String::length;
        Predicate<Integer> isTwoSequence = x -> x % 2 == 0;
        Function<Integer, Integer> f = x -> x * 2;

        int n = 3;

        if (isTwoSequence.test(n)) {
            n = f.apply(n);
        }
        System.out.println(n);

        // List<Integer[]> list = new ArrayList<>();
    }

    public Optional<ArrayList<Integer>> exampleForOptional() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            list.add(i);
        }

        List<Integer> Processlist = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .toList();

        Scanner read = new Scanner(System.in);
        int prompt = read.nextInt();

        boolean flag = Processlist.contains(prompt);

        if (flag) {
            return Optional.of(new ArrayList<>(Processlist));
        } else {
            return Optional.empty();
        }
    }

    public void useExampleForOptional() {
        Optional<ArrayList<Integer>> optional = exampleForOptional();

        if (optional.isEmpty()) {
            System.out.println("La lista esta vacía");
        } else {
            System.out.println("La lista no esta vacía");
        }

        optional.ifPresentOrElse(
                list -> System.out.println("La lista contiene: " + list),
                () -> System.out.println("La lista no contiene elementos")
        );

        optional.ifPresent(list -> {
            System.out.println("La lista contiene: " + list);
        });

        var list1 = optional.orElse(new ArrayList<>());
    }
}
