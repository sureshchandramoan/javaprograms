package com.practice.programs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class DeadlockProgram {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void method1() {
        try {
            if (lock1.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " acquiring lock1");

                    Thread.sleep(100);
                    if (lock2.tryLock(2, TimeUnit.SECONDS)) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " acquiring lock2");
                        } finally {
                            lock2.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " Unable to lock2");
                    }
                } finally {
                    lock1.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Unable to lock1");
            }
        } catch (InterruptedException _) {
        }
    }

    public void method2() {
        try {
            if (lock1.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " acquiring lock1");
                    Thread.sleep(100);
                    if (lock2.tryLock(2, TimeUnit.SECONDS)) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " acquiring lock1");
                        } finally {
                            lock2.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " Unable to lock2");

                    }
                } finally {
                    lock1.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Unable to lock1");
            }
        } catch (InterruptedException _) {

        }
    }

    public static void main(String[] args) {
        DeadlockProgram deadlockProgram = new DeadlockProgram();
        Thread thread1 = new Thread(deadlockProgram::method1, "ThreadA");
        Thread thread2 = new Thread(deadlockProgram::method2, "ThreadB");

        thread1.start();
        thread2.start();

    }
}