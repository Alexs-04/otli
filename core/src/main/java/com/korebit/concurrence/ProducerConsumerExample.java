package com.korebit.concurrence;

public class ProducerConsumerExample {

    static class DataBox {

        private String data;
        private volatile boolean hasData = false;

        public synchronized void produce(String value) {
            while (hasData) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            this.data = value;
            hasData = true;
            System.out.println("Productor produjo: " + value);
            notify();
        }

        public synchronized void consume() {
            while (!hasData) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            hasData = false;
            System.out.println("Consumidor consumió: " + data);
            notify();
        }
    }

    public void example() {
        DataBox box = new DataBox();

        Thread producer = new Thread(() -> {
            String[] values = {"Manzana", "Plátano", "Cereza", "Uva"};
            for (String value : values) {
                box.produce(value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                box.consume();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
