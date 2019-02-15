package com.example.github.algo.day02.queue;

/**
 * 链表实现的链式队列
 */
public class LinkedQueue {

    private Node head;
    private Node tail;

    public static class Node {
        public String value;
        public Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void enqueue(String item) {
        if (null == tail) {
            head = new Node(item, head);
        }
        tail = new Node(item, tail);
    }

    public String dequeue() {
        if (null == head) {
            return null;
        } else {
            String value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return value;
        }
    }


}
