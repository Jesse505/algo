package com.example.github.algo.day02.queue;

/**
 * 实现一个循环队列
 */
public class CircularQueue {

    private String[] data;
    private int size;
    private int head; //队头下标
    private int tail; //队尾下标

    public CircularQueue(int capacity) {
        data = new String[capacity];
        size = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1)%size == head) {
            return false;
        } else {
            data[tail] = item;
            tail = (tail + 1)%size;
            return true;
        }
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        } else {
            String ret = data[head];
            head = (head + 1)%size;
            return ret;
        }
    }
}
