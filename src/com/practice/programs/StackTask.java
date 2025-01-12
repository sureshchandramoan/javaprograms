package com.practice.programs;

import java.util.Stack;

public class StackTask {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("Mark");
        stack.push("Daniel");
        stack.push("John");
        /*System.out.println("stack = " + stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println("stack = " + stack);
        System.out.println(stack.search("T"));
        System.out.println(stack.size());*/
        for(String name: stack) {
            System.out.println("name = " + name);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
