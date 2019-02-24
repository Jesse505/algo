package com.example.github.algo.day04;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 * 维护一个双向链表用于存放缓存数据，越接近链表尾部的数据表示越少被使用到。
 * put()
 * 放入一个数据时，如果数据已存在则将其移动到链表头部，并更新Key所对应的Value值，如果不存在，则：
 *    1. 如果缓存容量已达到最大值，则将链表尾部节点删除掉，将新的数据放入链表头部；
 *    2.如果缓存容量未达到最大值，则直接将新的数据放入链表头部；
 * get()
 * 查询一个数据时，遍历整个链表，如果能查询到对应的数据，则将其移动到链表头部；如果查询不到则返回null；
 *    注意：由于遍历链表的时间复杂度为O(n)，我们可以使用散列表HashMap来记录每个Key所对应的Node节点，将时间复杂度降为O(1)
 * @param <K>
 * @param <V>
 */
public class LRUCache<K,V> {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<K, Node> nodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>(capacity);
    }

    /**
     * Get Key
     *
     * @param key
     * @return
     */
    public V get(K key) {
        Node existNode = nodeMap.get(key);
        if (existNode == null) {
            return null;
        }
        remove(existNode);
        addFirst(existNode);
        return existNode.value;
    }

    /**
     * Add Key-Value
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Node existNode = nodeMap.get(key);
        if (existNode == null) {
            Node newNode = new Node(key, value);
            if (nodeMap.size() >= capacity) {
                removeLast();
            }
            addFirst(newNode);
        }
        else {
            // update the value
            existNode.value = value;
            remove(existNode);
            addFirst(existNode);
        }
    }

    /**
     * remove node
     *
     * @param node
     */
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }
        nodeMap.remove(node.key);
    }

    /**
     * add first node
     *
     * @param node
     */
    private void addFirst(Node node) {
        node.prev = null;
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        nodeMap.put(node.key, node);
    }

    /**
     * remove last
     */
    private void removeLast() {
        if (tail == null) {
            return;
        }
        // remove key from map
        nodeMap.remove(tail.key);
        // remove node from linked list
        Node prev = tail.prev;
        if (prev != null) {
            prev.next = null;
            tail = prev;
        } else {
            head = tail = null;
        }
    }

    private class Node {

        private K key;
        private V value;
        private Node prev;
        private Node next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
