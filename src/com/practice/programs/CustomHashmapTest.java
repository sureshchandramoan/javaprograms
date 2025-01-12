package com.practice.programs;

public class CustomHashmapTest<K, V> {
    private final Node<K,V>[] table;
    private int capacity = 5;
    private int size = 0;


    static class Node<K,V> {
        K key;
        V val;
        Node<K,V> next;
        public Node(K key, V val, Node<K,V> next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public CustomHashmapTest () {
        table = new Node[capacity];
    }

    public int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V val) {
        if (key == null) {
            return;
        }

        int hash = hash(key);
        Node<K,V> newNode = new Node(key, val, null);
        if (table[hash] == null) {
            table[hash] = newNode;
            size++;
            return;
        }

        Node<K,V> current = table[hash];
        while(current != null) {
            if (current.key.equals(key)) {
                current.val = val;
                return;
            }

            if (current.next == null) {
                current.next = newNode;
                size++;
                return;
            }

            current = current.next;
        }
    }

    public void display(){
        for (int i = 0; i < capacity; i++) {
            Node<K,V> current = table[i];
            while(current != null) {
                System.out.println(current.key + ":" + current.val);
                current = current.next;
            }

        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int hash = hash(key);
        Node<K,V> current = table[hash];
        while(current != null) {
            if(current.key.equals(key)) {
                return current.val;
            }
            current = current.next;
        }
        return null;
    }

    public boolean remove(K key){
        if (key == null) {
            return false;
        }
        int hash = hash(key);
        Node<K,V> current = table[hash];
        Node<K,V> previous = null;
        while(current != null) {
            if (current.key.equals(key)) {
                if(previous == null) {
                    table[hash] = table[hash].next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }


    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        CustomHashmapTest<String, String> customHashmapTest = new CustomHashmapTest<>();
        customHashmapTest.put("A", "101");
        customHashmapTest.put("B", "102");
        customHashmapTest.put("C", "103");
        customHashmapTest.put("D", "104");
        customHashmapTest.put("E", "105");

        System.out.println(customHashmapTest.size());
        customHashmapTest.display();
        System.out.println(customHashmapTest.get("D"));
        System.out.println(" ");
        System.out.println(customHashmapTest.remove("B"));
        customHashmapTest.display();
        System.out.println(customHashmapTest.size);
        System.out.println(customHashmapTest.get("A"));


    }
}
