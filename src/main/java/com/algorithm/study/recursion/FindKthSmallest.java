package com.algorithm.study.recursion;

import java.util.Arrays;

/**
 * @Author: yangzhi
 * @Description: com.algorithm.study.recursion
 * @Date: Create in 2021-05-19 2342
 */
public class FindKthSmallest {

    public static void main(String[] args) {
        int[] array =new int[]{1,1,2};
        System.out.println(KthSmallest(array,2));
        System.out.println(Arrays.toString(array));

    }

    public static int KthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }

        int partition = partition(arr, 0, arr.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(arr, partition + 1, arr.length - 1);
            } else {
                partition = partition(arr, 0, partition - 1);
            }
        }

        return arr[partition];
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];

        int i = p;
        for (int j = p; j < r; j++) {
            // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
            if (arr[j] <= pivot) {
                // 4,1,3,6,2 把小的往前换
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
