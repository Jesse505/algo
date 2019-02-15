package com.example.github.algo.day02.stack;

/**
 * 链表实现的链式栈
 */
public class LinkedStack {

    private Node top;

    public static class Node {
        public String value;
        public Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //入栈
    public void push(String item) {
        top = new Node(item, top);
    }

    //出栈
    public String pop() {
        if (null == top) {
            return null;
        } else {
            String data = top.value;
            top = top.next;
            return data;
        }
    }
}
