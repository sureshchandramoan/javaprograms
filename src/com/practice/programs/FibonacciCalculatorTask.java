package com.practice.programs;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FibonacciCalculatorTask  extends RecursiveTask<Integer> {

    private final int n;
    FibonacciCalculatorTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FibonacciCalculatorTask f1 = new FibonacciCalculatorTask(n - 1);
        f1.fork();
        FibonacciCalculatorTask f2 = new FibonacciCalculatorTask( n - 2 );
        return f2.compute() + f1.join();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int n = 5;
        Integer result = pool.invoke(new FibonacciCalculatorTask(n));
        System.out.println("result = " + result);
    }
}
