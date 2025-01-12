package com.practice.programs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockProgram {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void method1() {
        lock1.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquiring LOck1");
            Thread.sleep(200);
            lock2.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquiring lock2");
            } finally {
                lock2.unlock();
            }
        } catch (InterruptedException _) {

        } finally {
            lock1.unlock();
        }
    }

    public void method2() {
        lock1.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquiring LOck1");
            Thread.sleep(200);
            lock2.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquiring lock2");
            } finally {
                lock2.unlock();
            }
        } catch (InterruptedException _) {

        } finally {
            lock1.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadLockProgram lockProgram = new ThreadLockProgram();
        Thread thread1 = new Thread(lockProgram::method1, "ThreadA");
        Thread thread2 = new Thread(lockProgram::method2, "ThreadB");
        thread1.start();
        thread2.start();
    }

}
