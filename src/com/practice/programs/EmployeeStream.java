package com.practice.programs;

import java.util.*;
import java.util.stream.Collectors;

record Student(int id, String name) {
}

public class EmployeeStream {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(11, "Suresh"),
                new Student(12, "Sundar"),
                new Student(13, "Raj")
        );

        Map<Character, Set<String>> collect = students.stream().collect(Collectors.groupingBy(s -> s.name().charAt(0), Collectors.mapping(Student::name, Collectors.toSet())));

        System.out.println("collect = " + collect);
    }
}
