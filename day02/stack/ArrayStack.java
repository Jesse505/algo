package com.example.github.algo.day02.stack;

/**
 * 数组实现的顺序栈
 */
public class ArrayStack {

    private String[] data;
    private int size;
    private int count;

    public ArrayStack(int capacity) {
        this.size = capacity;
        data = new String[capacity];
    }

    //入栈
    public boolean push(String item) {
        if (count == size) {
            return false;
        } else {
            data[count++] = item;
            return true;
        }
    }

    //出栈
    public String pop() {
        if (count == 0) {
            return null;
        } else {
            count--;
            return data[count];
        }
    }
}
