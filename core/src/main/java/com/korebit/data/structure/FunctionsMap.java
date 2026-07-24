package com.korebit.data.structure;

import java.util.HashMap;
import java.util.Map;

public class FunctionsMap {
    private final Map<Integer, String> users = new HashMap<>();
    private int idCounter = 1;

    public void createUser(String name) {
        users.put(idCounter++, name);
        System.out.println("Usuario agregado: " + name);

    }

    public void readUsers() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("Lista de usuarios:");
        users.forEach((id, name) -> System.out.println(id + ": " + name));
    }

    public void updateUser(int id, String newName) {
        if (users.containsKey(id)) {
            users.put(id, newName);
            System.out.println("Usuario actualizado: " + newName);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void deleteUser(int id) {
        if (users.remove(id) != null) {
            System.out.println("Usuario eliminado con ID: " + id);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void example() {
        FunctionsMap crud = new FunctionsMap();

        crud.createUser("Ana");
        crud.createUser("Carlos");
        crud.createUser("Luis");

        crud.readUsers();

        crud.updateUser(2, "Carlos Pérez");

        crud.readUsers();

        crud.deleteUser(1);

        crud.readUsers();
    }
}
