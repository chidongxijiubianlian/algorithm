package com.algorithm.study.sort;

import java.util.Collections;

/**
 * @Author: yangzhi
 * @Description: 计数排序
 * @Date: 这玩意比较绕 https://time.geekbang.org/column/article/42038
 * //先申请一个数组  数组大小是 要排序数组中的最大值+1 比如最大值是5 那么申请int[] array=new int[6] 把0预留出来
 * //遍历要排序的数组a[] 将每个元素的出现频率放到 申请的数组中
 * //累加申请的数组 比如数组[1,0,3,1,2] 累加后变成[1,1,4,5,7] array[0]处存储的是小于等于0的元素个数 array[1]存小于等于1的元素个数 难点1
 * //反向遍历 要排序的数组a[] a[i]的值作为array[]数组的索引 将array[a[i]]-1的值放到 要返回的数组中 然后 array[a[i]--]
 */
public class CountingSort {




    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
