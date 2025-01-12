package com.practice.programs;

import java.util.Arrays;

public class DynamicArray {
    int size = 0;
    int capacity = 10;
    Object[] data;

    public DynamicArray(){
        this.data = new Object[capacity];
    }

    public DynamicArray(int capacity){
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    public void add(Object o) {
        if (size >= capacity) {
            grow();
        }
        data[size] = o;
        size++;
    }

    public boolean remove(Object o){
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (data[i] == o) {
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }

                data[size - 1] = null;
                removed = true;
                break;
            }
        }
        if (removed) {
            size--;
            if (size <= (int) capacity / 3) {
                shrink();
            }
        }
        return removed;
    }

    public void insert(int index, Object o){
        if (size >= capacity) {
            grow();
        }

        for (int i = 0; i < size; i++) {
            if (i == index) {
                for (int j = size-1; j >= i; j--) {
                    data[j+1] = data[j];
                }
                break;
            }
        }
        data[index] = o;
        size++;
    }

    public int search(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i] == o) {
                return i + 1;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void grow(){
        int newCapacity = capacity * 2;
        resize(newCapacity);
    }

    private void shrink(){
        int newCapacity = (int) capacity / 3;
        resize(newCapacity);
    }

    private void resize(int newCapacity){
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    @Override
    public String toString(){
        String string = "";
        for (int i = 0; i < capacity; i++) {
            string = string + data[i] + ", ";
        }
        if (!string.equals("")) {
            string = "[" + string.substring(0, string.length()-2) + "]";
        } else {
            string = "[]";
        }
        return string;
    }

}
