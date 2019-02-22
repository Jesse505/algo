package com.example.github.algo.day03.binarySearch;

public class Test {
    public static void main(String[] args) {
        System.out.println(mySqrt(11));
    }

    /**
     * 求x的平方根
     * @param x
     * @return x的平方根
     */
    public static int mySqrt(int x) {
        int ans = -1;
        if (0 == x){
            return 0;
        }
        int left = 1, right = x;
        while (left <= right) {
            //防止整型溢出
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
