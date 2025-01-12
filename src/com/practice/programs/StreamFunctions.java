package com.practice.programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamFunctions {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Mark1", 30, 10000, "Manager", 100);
        Employee emp2 = new Employee(102, "Mark2", 35, 5000, "Engineer", 100);
        Employee emp3 = new Employee(103, "Mark3", 36, 6000, "Engineer", 106);
        Employee emp4 = new Employee(104, "Mark4", 40, 3000, "Engineer", 107);
        Employee emp5 = new Employee(105, "Mark3", 25, 4000, "Engineer", 108);
        Employee emp6 = new Employee(106, "Mark6", 23, 10000, "Manager", 101);
        Employee emp7 = new Employee(107, "Mark7", 28, 6000, "Manager", 101);
        Employee emp8 = new Employee(108, "Mark8", 32, 15000, "Manager", 101);
        Employee emp9 = new Employee(109, "Mark9", 33, 8000, "Engineer", 101);
        Employee emp10 = new Employee(110, "Mark10", 38, 5000, "Manager", 101);
        Employee emp11 = new Employee(111, "Mark11", 45, 6000, "Engineer", 114);
        Employee emp12 = new Employee(112, "Mark12", 60, 20000, "Engineer", 114);
        Employee emp13 = new Employee(113, "Mark13", 50, 20000, "Engineer", 114);
        Employee emp14 = new Employee(114, "Mark14", 43, 1000, "Manager", 101);
        List<Employee> employees = List.of(emp2,emp4,emp3,emp1,emp7,emp6,emp5,emp8,emp9,emp10,emp11,emp12,emp13,emp14);
        // 1. sort employee based on name
//            employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
        // 2. sort employee based on salary
//            employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
        // 3. show only manager
//            employees.stream().filter(emp -> emp.getDesignation().equals("Manager")).forEach(System.out::println);
        // 4. show only junior employees
//        employees.stream().filter(emp -> !emp.getDesignation().equals("Manager")).forEach(System.out::println);
        // 5. show sum of salary of manager employees
//        System.out.println(employees.stream().filter(emp -> emp.getDesignation().equals("Manager")).map( emp -> emp.getSalary()).reduce(0.0, Double::sum));
        // 6. show count of junior employees
//        System.out.println(employees.stream().filter(emp -> emp.getDesignation().equals("Engineer")).count());
        // 7. show 3rd highest earning employee
//        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(2).findFirst().get());
        // 8. Total number of employees
//        System.out.println(employees.size());
        // 9. show only email id of managers in sorting order
//        employees.stream().filter(emp -> emp.getDesignation().equals("Manager")).map(emp -> emp.getEmail()).sorted().forEach(System.out::println);
        // 10. store manager with their employees in hashmap
//        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getManagerId, Collectors.filtering(emp -> emp.getAge() > 30 && emp.getAge() <= 40, Collectors.toList()))));
        // 11. show min salary on each manager group
//        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getManagerId, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)))));
        // 12. count of each manager group
//        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getManagerId, Collectors.counting())));
        // 13. show manager who does not have manager
        
        /*Map<Integer, Long> mapEmployee = employees.stream().collect(Collectors.groupingBy(Employee::getManagerId, Collectors.counting()));
        Set<Integer> ids = employees.stream().filter(emp -> emp.getDesignation().equals("Manager")).map(emp -> emp.getId()).collect(Collectors.toSet());

        for(Integer id :  ids) {
            System.out.println(id + " = " + mapEmployee.getOrDefault(id, 0L) );
        }*/

        // 14. Partition by Manager and employee
        /* Map<Boolean, List<Employee>> manager = employees.stream().collect(Collectors.partitioningBy(emp -> emp.getDesignation().equals("Manager")));
                                manager.get(false).stream().forEach(System.out::println);*/

        // 15. Flattern all the contact numbers for all employees
//        employees.stream().flatMap( emp -> emp.getContacts().stream()).forEach(System.out::println);

        // 16. Sum of all the salaries per month
//        System.out.println(employees.stream().map(emp -> emp.getName()).reduce("{", String::concat));

        // 17. Print the name in the middle of the execution
//        employees.stream().map(e -> e.getName()).peek(System.out::println).map(String::toUpperCase).peek(System.out::println).collect(Collectors.toList());
//         employees.stream().map(e -> e.getName()).peek(e -> System. out. println("Filtered value: " + e)).map(String::toUpperCase).peek(e -> System. out. println("Mapped value: " + e))     .collect(Collectors. toList());
    // 18. Convert list into hashmap with key as id and value as employee
        Map<Integer, Employee> collect = employees.stream().collect(Collectors.toMap( Employee::getId, Function.identity()));
    // 19. Find duplicate employee names
        // style - 1
        /*Set<String> uniqueEmployees = new HashSet<>();
        employees.stream().filter( emp -> !uniqueEmployees.add(emp.getName())).forEach(System.out::println);*/
        // style - 2
        /*Map<String, Long> employeeCounting = employees.stream().collect(Collectors.groupingBy(emp -> emp.getName(), Collectors.counting()));
       employeeCounting.entrySet().stream().filter( entry -> entry.getValue() > 1).forEach(entry -> System.out.println("entry = " + entry.getKey()));*/

        // style - 3
        /*List<String> names = employees.stream().map(Employee::getName).toList();
        Set<Employee> collect = employees.stream().filter(emp -> Collections.frequency(names, emp.getName()) > 1).collect(Collectors.toSet());
        System.out.println("collect = " + collect);*/

//        Map<String, Double> collect = employees.stream().collect(Collectors.teeing(Collectors.minBy(Comparator.comparing(Employee::getSalary)), Collectors.maxBy(Comparator.comparing(Employee::getSalary)), (min, max) -> Map.of("Min", min.get().getSalary(), "Max", max.get().getSalary())));

        System.out.println("collect = " + collect);


    }
}

class Employee{
    private int id;
    private String name;
    private int age;
    private double salary;
    private String designation;
    private int managerId;

    public Employee(int id, String name, int age, double salary, String designation, int managerId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
        this.managerId = managerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public int getManagerId() {
        return managerId;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", managerId=" + managerId +
                "}";
    }
}
