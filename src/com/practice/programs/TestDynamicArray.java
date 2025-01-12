package com.practice.programs;

public class TestDynamicArray {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(7);
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.insert(1,"X");

        dynamicArray.remove("B");
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");

        dynamicArray.remove("A");
        dynamicArray.remove("A");
        dynamicArray.remove("A");
        dynamicArray.remove("A");
        dynamicArray.remove("B");
        dynamicArray.remove("B");
        dynamicArray.remove("B");
        dynamicArray.remove("C");
        dynamicArray.remove("C");

        /*dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");*/


        System.out.println("dynamicArray = " + dynamicArray);
        System.out.println("size = " + dynamicArray.size);
        System.out.println("capacity = " + dynamicArray.capacity);
        System.out.println("isEmpty = " + dynamicArray.isEmpty());
        System.out.println("Search = " + dynamicArray.search("A"));
    }
}
