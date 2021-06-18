package com.algorithm.study.recursion;

import java.util.Arrays;

/**
 * @Author: yangzhi
 * @Description: com.algorithm.study.recursion
 * @Date: Create in 2021-05-19 2342
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] array =new int[]{4,5,3,6,2};
        System.out.println(kthLargest(array,1));
        System.out.println(Arrays.toString(array));

    }

    public static int kthLargest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }

        int partition = partition(arr, 0, arr.length - 1);
        while (partition +1 != k) {
            if (partition + 1 > k) {
                //求第k大的数 排序后是倒序数组 如果partition+1>k 需要往前找不是往后找了
                partition = partition(arr, 0, partition - 1);
            } else {
                partition = partition(arr, partition + 1, arr.length - 1);
            }
        }

        return arr[partition];
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];

        int i = p;
        for (int j = p; j < r; j++) {
            // 这里是区分求第k大和第k小的关键点之一
            if (arr[j] >= pivot) {
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
