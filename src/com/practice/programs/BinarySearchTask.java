package com.practice.programs;

public class BinarySearchTask {
    public static void main(String[] args) {
        int[] input = new int[100];
        int target = 52;
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }

        int index = binarySearch(input, target);
        System.out.println("index = " + index);
    }

    private static int binarySearch(int[] input, int target) {
        int low = 0;
        int high = input.length - 1;
        return binarySearchRecursion(input, target, low, high);
    }

    private static int binarySearchRecursion(int[] input, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2; 
        int value = input[middle];

        if (value < target) {
            return binarySearchRecursion(input, target, middle + 1, high);
        } else if (value > target) {
            return binarySearchRecursion(input, target, low, middle - 1);
        } else {
            return middle;
        }
    }
}
