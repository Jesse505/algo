package com.example.github.algo.day03.sort;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        int[] arrays = {0,4,2,4,6,8,9};
        System.out.println(findLeastNums(arrays, 7));
    }

    /**
     * 获取一组数据的第k大元素
     * 利用快排中的partition方法
     * @return
     */
    public static int findLeastNums(int[] arrays, int k) {
        if (arrays == null || arrays.length == 0 || k > arrays.length) {
            throw new IllegalArgumentException("参数异常");
        }
        int start = 0;
        int end = arrays.length - 1;
        int index = partition(arrays, arrays.length, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index -1;
            } else {
                start = index + 1;
            }
            index = partition(arrays, arrays.length, start, end);
        }
        return arrays[index];
    }

    /**
     * 快排中的partition方法
     * @return
     */
    public static int partition(int[] arrays, int len, int start, int end) {
        if (arrays == null || arrays.length == 0 || start < 0 || end >= len) {
            throw new IllegalArgumentException("参数异常");
        }
        //获取随机数组下标
        int index = randomInRange(start, end);
        swap(arrays, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            //把比最后一个数小的都放到数组的最前面
            if (arrays[i] < arrays[end]) {
                ++small;
                if (i != small)
                swap(arrays, i, small);
            }
        }
        ++small;
        //交换最后一个数和small位置的数
        swap(arrays, small, end);
        return small;
    }

    public static void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static int randomInRange(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }
}
