package com.example.github.algo.day01;

/**
 * 动态扩容的数组
 */
public class DynamicArray {

    private Object[] data;
    private int capacity;

    private int size;


    public DynamicArray(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public void add(Object item) {
        if (capacity > size) {
            data[size++] = item;
            return;
        }
        if (capacity == size) {
            capacity = capacity << 1;
            Object[] tempArr = new Object[capacity];
            System.arraycopy(data, 0, tempArr, 0, data.length);
            data = tempArr;
        }

        data[size++] = item;
    }

    public Object get(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("数组下标超出范围");
        }
        return data[index];
    }

    public int size() {
        return size;
    }
}
