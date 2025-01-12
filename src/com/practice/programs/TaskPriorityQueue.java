package com.practice.programs;

import java.util.PriorityQueue;
import java.util.Comparator;

public class TaskPriorityQueue {
    private final PriorityQueue<Task> queue;

    public TaskPriorityQueue() {
        queue = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority).reversed());
    }

    public void enqueue(String name, int priority) {
        queue.add(new Task(name, priority));
    }

    public String dequeue() {
        Task task = queue.poll();
        return task != null ? task.getName() : null;
    }

    private static class Task {
        private final String name;
        private final int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }
    }

    public static void main(String[] args) {
        TaskPriorityQueue pq = new TaskPriorityQueue();
        pq.enqueue("Low priority task", 1);
        pq.enqueue("High priority task", 2);
        System.out.println(pq.dequeue()); // Should print "High priority task"
    }
}
