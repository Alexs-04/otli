package com.korebit.data.structure;

import com.korebit.model.Employee;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FunctionsSet {
    static Set<Employee> set = new HashSet<>();
    static Scanner read = new Scanner(System.in);

    public void ExampleSet() {
        set.add(new Employee("Alex", 20, 1));
        set.add(new Employee("Deni", 20, 2));
        set.add(new Employee("Roberto", 30, 3));
        set.add(new Employee("Roberto", 30, 3));
        set.forEach(employee -> System.out.println(employee.getName()));
        System.out.println("----------------------");
        System.out.print("INGRESA EL ID DEL EMPLEADO A ELIMINAR: ");
        int id = read.nextInt();
        System.out.println("TAMAÑO ANTES DE ELIMINAR: " + set.size());

        if (!set.isEmpty()) {
            if (search(id) != null) {
                set.remove(search(id));
                set.forEach(employee -> System.out.println(employee.getName()));
            } else {
                System.out.println("NO SE ENCONTRÓ EL EMPLEADO");
            }
            System.out.println("TAMAÑO DESPUÉS DE ELIMINAR: " + set.size());
        } else {
            System.out.println("EL SET ESTA VACÍO");
        }

    }

    @Nullable
    public static Employee search(int id) {
        for (Employee employee : set) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}