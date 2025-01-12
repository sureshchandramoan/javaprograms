package com.practice.programs;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearchTest {

    private static int[] input = new int[100];

    public static void main(String[] args) {
        int target = 30;

        generateInput();
        int low = 0;
        int high = input.length;
        int result = binarySearch(input, target, low, high);

        System.out.println(result);

    }

    private static int binarySearch(int[] input, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2 ;
        int middleValue = input[middle];

        if (middleValue < target) {
            return binarySearch(input, target, middle + 1, high);
        } else if (middleValue > target) {
            return binarySearch(input, target, low, middle - 1 );
        } else {
            return target;
        }
    }

    private static void generateInput() {
        input = IntStream.range(1,100).toArray();
    }
}
