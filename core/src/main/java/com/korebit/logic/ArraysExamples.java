package com.korebit.logic;

import java.util.Scanner;

public class ArraysExamples {

    private final Scanner sc = new Scanner(System.in);
    public void example() {
        String[] array;
        sc.nextLine();
        String input = sc.nextLine();

        array = input.split(" ");
        String n = sc.nextLine();

        boolean flag = false;
        for (String s : array) {
            if (s.equals(n)) {
                flag = true;
                break;
            }
        }

        System.out.println(flag);
        sc.close();
    }

    public void exampleTwo() {
        int[] arr = initArray();

        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        boolean found = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] == n && arr[i+1] == m) || (arr[i] == m && arr[i+1] == n)) {
                found = true;
                break;
            }
        }

        System.out.println(found);
        sc.close();
    }

    public void exampleThree() {
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        int[] arr = initArray();
        for(int num : arr){
            if(num > n){
                sum += num;
            }
        }
        System.out.println(sum);
        sc.close();
    }

    private int[] initArray() {
        int len = Integer.parseInt(sc.nextLine());
        String[] parts = sc.nextLine().split(" ");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }
}
