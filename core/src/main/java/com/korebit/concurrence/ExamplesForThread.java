package com.korebit.concurrence;

public class ExamplesForThread {

    static {
        System.out.println("Ejecutando el bloque estático");
    }

    public void runExample() throws InterruptedException {
        var ring = new Ring();
        Thread thread1 = new Thread(new Person(ring));
        Thread thread2 = new Thread(new Person(ring));

        thread2.start();
        thread1.start();
        thread1.join();
        thread2.join();
    }

    static class Ring {
        public synchronized void action() {
            System.out.println("Ding...");
            try {
                Thread.sleep(2000);
                System.out.println("Dong...");
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

        public void actionTwo() {
            System.out.println("Persona Actuando");
            synchronized (this) {
                System.out.println("Ding...");
                try {
                    Thread.sleep(100);
                    System.out.println("Dong...");
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    static class Person implements Runnable {
        private final Ring ring;

        public Person(Ring ring) {
            this.ring = ring;
        }

        @Override
        public void run() {
            // ring.action();
            ring.actionTwo();
        }
    }
}
