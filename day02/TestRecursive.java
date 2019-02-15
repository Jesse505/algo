package com.example.github.algo.day02;


public class TestRecursive {

    public static void main(String[] args) {

        System.out.println(getNByRec(6));
        System.out.println(getN(6));
        System.out.println(getSumByRec(6));
        System.out.println(getSum(6));
    }

    /**
     * 求斐波那契数列的第n项的值(方法一，递归，复杂度O(2ˆn))
     */
    public static int getNByRec(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        return getNByRec(n-1) + getNByRec(n-2);
    }

    /**
     * 求斐波那契数列的第n项的值（方法二，复杂度O(n)）
     * 另一种方式是自底向上求解，从1，2推导3。再从2，3推导出4。也就是说，我们想要求第n项的值的话，
     * 只需要知道n-1和n-2的值就可以了，而不需要像递归那样所有的值都算出来。
     */
    public static int getN(int n) {
        int preN = 1;
        int prePreN = 1;
        int value = 0;
        int flag = 2;
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n > 2) {
            while (flag < n) {
                value = preN + prePreN;
                prePreN = preN;
                preN = value;
                flag++;
            }
        }
        return value;
    }

    /**
     * 求斐波那契数列前n项的和(递归算法）
     */
    public static int getSumByRec(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getNByRec(i); //累加前n项
        }
        return sum;
    }

    /**
     * 求斐波那契数列前n项的和
     *
     * 求和：Sn=a1+a2+a3+……+An
     *
     * Sn也可以写成Sn=1+a1+a2+a3+……+An-1
     * 因为a2等于1，所以Sn=a2+a1+a2+a3+……+An-1
     * 即：Sn=a2+a1+a2+a3+……+An-1
     * Sn=a3+a2+a3+……+An-1
     * Sn=a4+a3+……+An-1……
     * Sn=An+A(n-1)+An-1
     * 即：Sn=A(n+1)+An-1=A(n+2)-1
     */
    public static int getSum(int n) {
        return getN(n+2) - 1;
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
