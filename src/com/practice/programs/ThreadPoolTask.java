package com.practice.programs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ThreadPoolTask {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("cores = " + cores);

        Consumer<String> consumer = (val) -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(val + (i+1));
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(() -> consumer.accept("A"));
        service.submit(() -> consumer.accept("B"));
        service.submit(() -> consumer.accept("C"));

        service.shutdown();
    }
}
