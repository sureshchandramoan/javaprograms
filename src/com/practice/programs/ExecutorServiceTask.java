package com.practice.programs;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTask {

    private static int total = 0;

    public int getNumber(){
        Random random = new Random();
        return random.nextInt(100);
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorServiceTask task = new ExecutorServiceTask();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            Future<Integer> submit = service.submit(task::getNumber);
            int value = submit.get();
          total = total + value;
            System.out.println("value = " + value + " " + total);
        }
        System.out.println(total);
        service.shutdown();
    }
}

