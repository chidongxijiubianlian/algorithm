package com.algorithm.study.sort;

import java.util.Arrays;

/**
 * @Author: yangzhi
 * @Description: O(nlogn) 稳定  非原地
 *               归并排序，先从中间分解数组 一直分解 直到仅有一个元素
 *               然后再合成元素 合成元素时 判断孰大孰小  有序合并
 * @Date: Create in 2021-05-16 2320
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array =new int[]{4,7,2,5,1,3};
        int[] temp =new int[array.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array,temp);
        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] array,int[] temp)
    {
        mergeSortC(array,0,array.length-1,temp);
    }

    public void mergeSortC(int[] array,int start,int end,int[] temp)
    {
        if(start >=end)
        {
            return;
        }
        int middle =(start+end)/2;
        mergeSortC(array, start, middle,temp);
        mergeSortC(array,middle+1,end,temp);
        merge(array,start,middle,end,temp);
    }

    public void merge(int[] array,int low,int mid,int high,int[] temp)
    {
        int i=0;
        int j=low;
        int k=mid+1;
        while (j<=mid && k<=high){
            if(array[j]<array[k])
            {
                temp[i++] =array[j++];
            }else
            {
                temp[i++] =array[k++];
            }
        }
        while (j<=mid){
            temp[i++] =array[j++];
        }
        while (k<=high){
            temp[i++] =array[k++];
        }
        for(int n=0;n<i;n++)
        {
            array[low+n] =temp[n];
        }

        System.out.println("merge:"+Arrays.toString(array));
    }



}
