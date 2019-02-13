package com.example.github.algo.day01;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {

        int a[] = {1,3,6,8,0,0,0,0};
        int b[] = {2,4,5,7};
        mergeSortedArr(a, 4, b , 4);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 合并两个有序数组（归并排序）
     * 末尾填充法，从后往前填充
     */
    public static void mergeSortedArr(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int writeIdx = m + n - 1;
        //如果是第二个数组用完了，说明剩下的全是数组1，不用填充了，他们已经在了
        while (i >= 0 && j >= 0) {
            nums1[writeIdx--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        //如果是第一个数组用完了，说明剩下的(最小的那些)全是数组2，把数组2填充进去就好了
        while (j >= 0) {
            nums1[writeIdx] = nums2[j--];
        }

    }

}
