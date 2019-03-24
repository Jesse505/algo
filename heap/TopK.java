package com.example.github.algo.heap;

import java.util.Arrays;

public class TopK {
    public static void main(String[] args) {
        int[] arrays = {0,4,2,4,6,8,9,4,8,10,9,0,0};
        System.out.println(Arrays.toString(topMinK(arrays,4)));
    }



    //获取最小的Topk
    private static int[] topMinK (int[] array, int k) {
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = array[i];
        }
        buildMaxHeap(top);
        for (int i = k; i < array.length; i++) {
            if (array[i] < top[0]) {
                setTop(top, array[i]);
            }
        }
        return top;
    }

    //构建最大堆
    private static void buildMaxHeap (int[] array) {
        int len = array.length;
        for (int i = len/2 -1; i >= 0; i--) {
            heapify(array, i, len);
        }
    }

    private static void setTop(int[] array, int top) {
        array[0] = top;
        heapify(array, 0, array.length);
    }

    //堆化
    private static void heapify (int[] array, int index, int len) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < len && array[left] > array[largest])
            largest = left;
        if (right < len && array[right] > array[largest])
            largest = right;
        if (largest != index) {
            swap(array, index, largest);
            heapify(array,largest, len);
        }
     }

    private static void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
