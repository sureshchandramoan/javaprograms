package com.practice.programs;

import java.util.*;

public class QueueTask {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        /*queue.offer("Mark");
        queue.offer("Daniel");
        queue.offer("John");*/
        queue.push("Mark");
        queue.push("Daniel");
        queue.push("John");

        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add("String");
        list.add(5.0);
//        System.out.println("list = " + list);

        int[] intArray = new int[20];
        System.out.println(intArray.length);


        /*System.out.println("queue.peekFirst() = " + queue.peekFirst());
        System.out.println("queue.peekLast() = " + queue.peekLast());*/

        /*System.out.println("queue = " + queue);

        queue.poll();
        System.out.println("queue = " + queue);
        System.out.println(queue.peek());*/
       /* for(String name:queue) {
            System.out.println(name);
        } // wrong approach
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }*/
        Queue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer("Mark");
        priorityQueue.offer("Daniel");
        priorityQueue.offer("John");
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

        /*List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        System.out.println("list = " + list);

        list.add(2,"insert after 2");
        System.out.println("list = " + list);

        list.set(2, "Replace 3rd position");

        System.out.println("list = " + list);

        list.remove("4");
        System.out.println("list = " + list);
        list.remove(4);
        System.out.println("list = " + list);*/



    }
}
