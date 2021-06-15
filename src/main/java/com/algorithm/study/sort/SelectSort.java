package com.algorithm.study.sort;

import java.util.Arrays;

/**
 * @Author: yangzhi
 * @Description: O(n²) 不稳定(两个相同大小的元素 排序后前后位置发生变化) 原地(不需要额外的存储空间)
 *               首次选一个最小的 第二次选次小的 第三次选第三小的
 * @Date: Create in 2021-05-15 1743
 */
public class SelectSort {


    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] array =new int[]{4,6,7,3,1,2};
        selectSort.selectSort(array);
        Arrays.sort(new int[]{1,2,3});
    }

    public void selectSort(int[] array)
    {
        if(array ==null || array.length ==1){
            return;
        }
        for(int i=0;i<array.length-1;i++)
        {
            int minIndex =i;
            for(int j=i+1;j<array.length;j++)
            {
                if(array[j] < array[minIndex])
                {
                    minIndex =j;
                }
            }
            if(i !=minIndex)
            {
                int temp =array[i];
                array[i] =array[minIndex];
                array[minIndex] =temp;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
