package com.korebit.concurrence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLockCondition {

    static class DataBox {
        private String data;
        private boolean hasData = false;

        private final Lock lock = new ReentrantLock();
        private final Condition dataProduced = lock.newCondition();
        private final Condition dataConsumed = lock.newCondition();

        public void produce(String value) {
            lock.lock();
            try {
                while (hasData) {
                    dataConsumed.await();
                }

                this.data = value;
                hasData = true;
                System.out.println("Productor produjo: " + value);

                dataProduced.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }

        public void consume() {
            lock.lock();
            try {
                while (!hasData) {
                    dataProduced.await();
                }

                hasData = false;
                System.out.println("Consumidor consumió: " + data);

                dataConsumed.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void example() {
        DataBox box = new DataBox();

        Thread producer = new Thread(() -> {
            String[] values = {"🔧", "⚙️", "🪛", "🛠️"};
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
