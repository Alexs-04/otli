package com.korebit.concurrence;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class ThreadPoolsExample {

    public void example() {
        try (var service = newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
            for (int i = 0; i < 10; i++) {
                service.submit(new falseTask(i));
            }
        } catch (Exception e) {
            System.err.println("Error occurred while executing tasks: " + e.getMessage());
        } finally {
            System.out.println("Thread pool closed.");
        }
    }

    static class falseTask implements Runnable {
        private final int id;

        public falseTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Task " + id + " is running on thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
