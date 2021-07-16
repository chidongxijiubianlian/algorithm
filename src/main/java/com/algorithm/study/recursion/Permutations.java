package com.algorithm.study.recursion;

/**
 * @Author: yangzhi
 * @Description: 全排列 打印一个数组中所有可能组合的顺序
 * @Date: Create in 2021-07-07 1657
 */
public class Permutations {
    // 调用方式：
    // int[]a = a={1, 2, 3, 4}; printPermutations(a, 4, 4);
    // k表示要处理的子数组的数据个数
    public static void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;

            printPermutations(data, n, k - 1);

            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[]a ={1, 2};
        printPermutations(a,a.length,a.length);
    }
}
