package com.example.github.algo.day02.queue;

/**
 * 数组实现的顺序队列
 */
public class ArrayQueue {

    private String[] data;
    private int size;
    private int head; //队头下标
    private int tail; //队尾下标

    public ArrayQueue(int capacity) {
        data = new String[capacity];
        size = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        if (tail == size) {
            return false;
        } else {
            data[tail++] = item;
            return true;
        }
    }

    //出队
    public String dequeue() {
        if (head == size) {
            return null;
        } else {
            return data[head++];
        }
    }
}
