package com.practice.programs;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.copyOf;

public class StreamPractice {
    public static void main(String[] args) {
        int[] intArray = {4,1,13,90,16,2,0};

        // Min val
//        System.out.println(IntStream.of(intArray).max().getAsInt());

        // or
//        System.out.println(IntStream.of(intArray).count());

        int[] secondCopy = copyOf(intArray, intArray.length);

        // sort
        Arrays.sort(intArray);
//        System.out.println(Arrays.toString(intArray));

        int sum = IntStream.of(intArray)
                .distinct()
                .sorted()
                .limit(3)
                .sum();
//        System.out.println("sum = " + sum);

        // Crate IntStream for 1....100
//        IntStream.rangeClosed(1,100).forEach(System.out::println);

        IntStream.rangeClosed(1,100).boxed().collect(Collectors.toSet()).forEach(System.out::println);


    }


}
