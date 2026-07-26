package com.korebit.concurrence;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    static class SharedCache {
        private final Map<String, String> cache = new HashMap<>();
        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        public void put(String key, String value) {
            writeLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " escribiendo: " + key + " => " + value);
                cache.put(key, value);
                Thread.sleep(1000); // Simula trabajo pesado
                System.out.println(Thread.currentThread().getName() + " terminó de escribir: " + key);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                writeLock.unlock();
            }
        }

        public String get(String key) {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " leyendo: " + key);
                Thread.sleep(500);
                return cache.get(key);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            } finally {
                readLock.unlock();
            }
        }
    }

    public static void example() {
        SharedCache cache = new SharedCache();

        Thread writer = new Thread(() -> {
            cache.put("nombre", "Java");
            cache.put("versión", "21");
        }, "Escritor");

        Runnable readerTask = () -> {
            for (int i = 0; i < 3; i++) {
                String value = cache.get("nombre");
                System.out.println(Thread.currentThread().getName() + " leyó: " + value);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread reader1 = new Thread(readerTask, "Lector-1");
        Thread reader2 = new Thread(readerTask, "Lector-2");

        writer.start();
        reader1.start();
        reader2.start();
    }
}

