package com.practice.programs;

import java.util.logging.Handler;

public class UserHashMap<K, V> {
    private Node<K,V>[] data;
    private int capacity = 16;
    private int size = 0;

    class Node<K,V> {
        K key;
        V val;
        Node<K,V> next;
        public Node(K key, V val, Node<K,V> next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public UserHashMap() {
        data = new Node[capacity];
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
        if (data[hash] == null) {
            data[hash] = newNode;
            size++;
            return;
        }
        Node<K,V> current = data[hash];
        while( current != null) {
            if(current.key.equals(key)) {
                current.val = val;
                return;
            }

            if(current.next == null) {
                current.next = newNode;
                size++;
                return;
            }
            current = current.next;
        }
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            Node<K,V> current = data[i];
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
         Node<K, V> current = data[hash];
         while (current != null) {
             if (current.key.equals(key)) {
                 return current.val;
             }
             current = current.next;
         }
         return null;
     }

     public boolean remove(K key) {
        if (key == null) {
            return false;
        }

        int hash = hash(key);
        Node<K,V> current = data[hash];
        Node<K,V> previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    data[hash] = data[hash].next;
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

     public int size() {
        return size;
     }

    public static void main(String[] args) {
        UserHashMap<String, String> userHashMap = new UserHashMap();
        userHashMap.put("101", "A");
        userHashMap.put("102", "B");
        userHashMap.put("102", "Updated");
        userHashMap.put("103", "C");
        userHashMap.put("104", "D");
        userHashMap.put("103", "updated");

        userHashMap.display();
        System.out.println(userHashMap.size);
        System.out.println(userHashMap.remove("102"));
        userHashMap.display();
        System.out.println(userHashMap.size);
        System.out.println(userHashMap.get("103"));

    }

}