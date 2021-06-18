package com.algorithm.study.sort;

import java.util.Arrays;

/**
 * @Author: yangzhi
 * @Description: 快排每次就是将分区点归位
 * @Date: Create in 2021-05-17 2307
 */
public class QuickSort {

    public static void main(String[] args)
    {
        int[] array =new int[]{3,4,8,6,1,7};
        QuickSort quickSort = new QuickSort();
        quickSort.partition(array,0,array.length-1);
    }

    public void quickSort(int[] array)
    {
        quickSortC(array,0,array.length-1);
    }

    public void quickSortC(int[] array,int start,int end)
    {
        if(start >=end)
        {
            return;
        }
        int q =partition(array,start,end);
        quickSortC(array,start,q-1);
        quickSortC(array,q+1,end);
    }

    public int partition(int[] array,int start,int end)
    {
        //end array[end]我们作为基准值
        //因此j遍历到end-1
        //自己不用和自己比较
        //i是最后pivot要插入的位置
        //从start开始 逐一与pivot进行比较
        //遇到小的就与自增j做交换 同时增加i的位置索引
        int pivot =array[end];
        int i =start;
        for(int j =start;j<=end-1;j++)
        {
            if(array[j] <pivot)
            {
                int temp = array[i];
                array[i] =array[j];
                array[j] =temp;
                i++;
            }
        }
        //交换i和pivot的元素  使pivot左边都是小于它 而右边都是大于它 这是一招从天而降的掌法
        int temp = array[i];
        array[i] =array[end];
        array[end] =temp;
        return i;
    }
}
