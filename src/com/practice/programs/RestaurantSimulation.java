package com.practice.programs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

class Shelf {
    private final int capacity;
    private final BlockingQueue<String> meals = new LinkedBlockingQueue<>();
    public Shelf(int capacity) {
        this.capacity = capacity;
    }

    public void prepareMeal(String meal) throws InterruptedException {
/*
        while (meals.size() == capacity) {
            System.out.println("Shelf is full. Chef is waiting to prepare meal");
            wait();
        }
*/

    meals.put(meal);
    System.out.println("Chef prepared = " + meal);
//    notify();
    }

    public void serveMeal() throws InterruptedException {
/*
        while(meals.isEmpty()) {
            System.out.println("Shelf is empty. Waitress is waiting for meal");
            wait();
        }
*/
        String meal = meals.take();
        System.out.println("Waitress served = " + meal);
//        notify();
    }
}

class Chef implements Runnable {
    private final Shelf shelf;
    private final String[] meals;
    public Chef(Shelf shelf, String[] meals){
        this.shelf = shelf;
        this.meals = meals;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (i < meals.length) {
                shelf.prepareMeal(meals[i]);
                i++;
                Thread.sleep(100);
            }
        } catch (InterruptedException _) {
        }
    }
}

class Waitress implements Runnable {
    private final Shelf shelf;
    private final int totalMeals;
    private int servedMeals = 0;
    public Waitress(Shelf shelf, int totalMeals) {
        this.shelf = shelf;
        this.totalMeals = totalMeals;
    }

    @Override
    public void run(){
        try {
            while (totalMeals > servedMeals) {
                shelf.serveMeal();
                servedMeals++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException _){
        }
    }
}

public class RestaurantSimulation {
    public static void main(String[] args) throws InterruptedException {
        String[] meals = {"Soup",  "Starter", "Main meals", "Drinks", "desert"};
        Shelf shelf = new Shelf(3);
        System.out.println("Welcome");
        Thread chefThread = new Thread(new Chef(shelf, meals ), "Chef");
        Thread waitressThread = new Thread(new Waitress(shelf, meals.length), "Waitress");
        chefThread.start();
        waitressThread.start();

        chefThread.join();
        waitressThread.join();
        System.out.println("Thank you!!!");


    }
}