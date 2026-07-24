package com.korebit.data.structure;

import com.korebit.data.structure.queue.Queue;
import com.korebit.data.structure.stack.Stack;

import javax.swing.JOptionPane;

public class Example {
    public static void exampleForStack(){
        int op = 0, nodo;
        Stack stack = new Stack();
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        MENU
                        (1)INSERTAR
                        (2)EXTRAER
                        (3)MOSTRAR CONTENIDO
                        (4)SALIR
                        """));
                switch (op) {
                    case 1 -> {
                        nodo = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE EL VALOR"));
                        stack.insertNode(nodo);
                    }
                    case 2 -> {
                        if (!stack.isEmptyForStack()) {
                            JOptionPane.showMessageDialog(null, "SE HA ELIMINADO: " + stack.endValue());
                            stack.removeNode();
                        } else {
                            JOptionPane.showMessageDialog(null, "LA PILA ESTA VACÍA");
                        }
                    }
                    case 3 -> {
                        if (stack.isEmptyForStack()) {
                            JOptionPane.showMessageDialog(null, "LA PILA ESTA VACÍA");
                        } else {
                            JOptionPane.showMessageDialog(null, "LA PILA NO ESTA VACÍA");
                        }
                    }
                    case 4 -> {
                        if (!stack.isEmptyForStack()) {
                            JOptionPane.showMessageDialog(null, "EL ULTIMO VALOR INGRESADO ES: " + stack.endValue());
                        } else {
                            JOptionPane.showMessageDialog(null, "LA PILA ESTA VACÍA");
                        }
                    }
                    case 5 -> JOptionPane.showMessageDialog(null, "LA PILA CONTIENE: " + stack.size() + " NODOS");
                    case 6 -> {
                        if (!stack.isEmptyForStack()) {
                            stack.clear();
                            JOptionPane.showMessageDialog(null, "LA PILA SE HA VACÍADO");
                        } else {
                            JOptionPane.showMessageDialog(null, "LA PILA ESTA VACÍA");
                        }
                    }
                    case 7 -> stack.show();
                    default -> JOptionPane.showMessageDialog(null, "ERROR NO SE ENCONTRÓ LA OPCIÓN");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e);
            }
        } while (op != 8);
    }

    public static void exampleForQueue(){
        int op = 0, nodo;
        Queue queue = new Queue();
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        MENU
                        (1)INSERTAR
                        (2)EXTRAER
                        (3)MOSTRAR CONTENIDO
                        (4)SALIR
                        """));
                switch (op) {
                    case 1 -> {
                        nodo = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESA EL VALOR: "));
                        queue.insert(nodo);
                    }
                    case 2 -> {
                        if (!queue.isEmptyForHeap()) {
                            JOptionPane.showMessageDialog(null, "SE EXTRAJO EL VALOR: " + queue.extract());

                        } else {
                            JOptionPane.showMessageDialog(null, "LA COLA ESTA VACÍA");
                        }
                    }
                    case 3 -> queue.show();
                    default -> JOptionPane.showMessageDialog(null, "NO SE ENCONTRÓ LA OPCIÓN!!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "SE ENCONTRÓ UN ERROR: " + e);
            }
        } while (op != 4);
    }
}
