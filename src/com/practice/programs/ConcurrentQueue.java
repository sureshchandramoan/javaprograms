package com.practice.programs;

import java.util.LinkedList;

public class ConcurrentQueue<T> {
    private final int capacity;
    private final LinkedList<T> queue = new LinkedList<>();
    ConcurrentQueue(int capacity){
        this.capacity = capacity;
    }

    public synchronized void enqueue(T t) throws InterruptedException {
        if (queue.size() == capacity) {
            wait();
        }
        queue.add(t);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        if (queue.isEmpty()) {
            wait();
        }
        T t = queue.removeFirst();
        notifyAll();
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentQueue queue = new ConcurrentQueue(10);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.enqueue(i);
                    System.out.println(" Produced = " +i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    int item = (int) queue.dequeue();
                    System.out.println("Consumed = " +item);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
