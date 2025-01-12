package com.practice.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CustomHashMapEntry<K,V> {

    private Node<K, V>[] node;
    private int capacity = 4;
    private int size = 0;

    class Node<K, V> {
        K key;
        V val;
        Node<K, V> next;

        public Node(K key, V val, Node<K, V> next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public CustomHashMapEntry() {
        node = new Node[capacity];
    }

    public CustomHashMapEntry(int capacity) {
        this.capacity = capacity;
        node = new Node[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V val) {
        if (key == null) {
            return;
        }
        int hash = hash(key);
        Node<K, V> newNode = new Node(key, val, null);

        if (node[hash] == null) {
            node[hash] = newNode;
        } else {
            Node<K, V> previous = null;
            Node<K, V> current = node[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        newNode.next = current.next;
                        node[hash] = newNode;
                        return;
                    } else {
                        newNode.next = current.next;
                        previous.next = newNode;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            if (previous != null)
                previous.next = newNode;
        }
        size++;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hash = hash(key);
        Node<K, V> temp = node[hash];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.val;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean remove(K key) {
        int hash = hash(key);
        if (key == null) {
            return false;
        }

        Node<K,V> previous = null;
        Node<K,V> current = node[hash];

        while(current != null) {
            if (current.key.equals(key)){
                if (previous == null){
                    node[hash] = node[hash].next;
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

    public void display(){
        for (int i = 0; i < capacity; i++) {
            if (node[i] != null) {
                Node<K,V> node = this.node[i];
                while(node != null){
                    System.out.println(node.key + ":" + node.val);
                    node = node.next;
                }
            }
        }
    }

    public Set<K> keys(){
        Set<K> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if(node[i] != null) {
                Node<K,V> temp = node[i];
                while(temp != null){
                    set.add(temp.key);
                    temp = temp.next;
                }
            }
        }
        return set;
    }

    public Set<V> values(){
        Set<V> set = new HashSet<V>();
        for (int i = 0; i < capacity; i++) {
            if(node[i] != null) {
                Node<K,V> temp = node[i];
                while(temp != null){
                    set.add(temp.val);
                    temp = temp.next;
                }
            }
        }
        return set;
    }

    public boolean containsKey(K key){
       return get(key) != null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}

public class CustomHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        CustomHashMapEntry<String, String> hashmap = new CustomHashMapEntry<>();
        hashmap.put("1", "Val1");
        hashmap.put("2", "Val2");
        hashmap.put("3", "Val3");
        hashmap.put("4", "Val4");
        hashmap.put("5", "Val5");
        /*hashmap.put("6", "Val6");
        hashmap.put("7", "Val7");
        hashmap.put("8", "Val8");
        hashmap.put("9", "Val9");
        hashmap.put("10", "Val10");
        hashmap.put("11", "Val11");
        hashmap.put("12", "Val12");
        hashmap.put("13", "Val13");
        hashmap.put("14", "Val14");
        hashmap.put("15", "Val15");
        hashmap.put("16", "Val16");
        hashmap.put("17", "Val17");
        hashmap.put("18", "Val18");
        hashmap.put("19", "Val19");
        hashmap.put("20", "Val20");*/

        System.out.println(hashmap.remove("3"));

        hashmap.display();
        /*
        System.out.println(hashmap.get("2"));
        System.out.println(hashmap.remove("3"));
        System.out.println(hashmap.size());*/
    }
}
