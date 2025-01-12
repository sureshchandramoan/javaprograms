package com.practice.programs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntratLockTask {

    public static Lock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    public static void method1() {
        try {
            lock.lock();
            System.out.println("11");
            System.out.println("12");
            condition.await();
            System.out.println("13");
            System.out.println("14");
            System.out.println("15");
        } catch (InterruptedException _) {

        } finally {
            lock.unlock();
        }
    }

    public static void method2() {
        try {
            lock.lock();
//            condition.signal();
            System.out.println("21");
            System.out.println("22");
            System.out.println("23");

            System.out.println("24");
            System.out.println("25");

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
            Thread t1 = new Thread(ReEntratLockTask::method1);
            t1.start();
            Thread t2 = new Thread(ReEntratLockTask::method2);
            t2.start();
            t1.join();
            t2.join();

    }
}
