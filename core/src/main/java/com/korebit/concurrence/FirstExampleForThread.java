package com.korebit.concurrence;

import java.time.Duration;

public class FirstExampleForThread {
    public void run() throws InterruptedException {
        Thread thread2 = new Thread(() -> {
            System.out.println("Ejecutando el hilo 2");
            try {
                Thread.sleep(Duration.ofSeconds(3));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Hilo 2 terminado");
        });

        thread2.start();
        Thread.sleep(100);

        while (thread2.isAlive()) {
            System.out.println("Esperando a que el hilo 2 termine");
            try {
                thread2.join(500);
            } catch (InterruptedException e) {
                System.out.println("Error al esperar el hilo 2");
            }

            System.out.println("fin");
        }
    }
}
