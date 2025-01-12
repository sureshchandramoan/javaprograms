package com.practice.programs;

import java.util.stream.IntStream;

public class BinarySearch {
    public static void main(String[] args) {
        int[] values = IntStream.range(0,99).toArray();
        int target = 30;
        int index = binarySearch(values, target, 0, values.length);
        System.out.println("index = " + index);
    }

    private static int binarySearch(int[] input, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low ) / 2;

        if (middle > target) {
            return binarySearch(input, target, low, middle - 1 );
        } else if (middle < target) {
            return binarySearch(input, target, middle + 1, high);
        } else {
            return middle;
        }

    }
}
