package com.algorithm.study.sort;

import java.util.Arrays;

/**
 * @Author: yangzhi
 * @Description: 时间复杂度 O(n²) 稳定 原地
 * @Date: Create in 2021-05-11 2236
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array ={4,5,6,3,2,1};
        bubbleSort.bubble(array);
        System.out.println(Arrays.toString(array));
    }

    private void bubble(int[] array)
    {
        if(array ==null)
        {
            return;
        }
        int n =array.length;
        for(int i=0;i<array.length-1;i++)
        {
            //冒泡排序，n-i是为了节省次数，
            //每经过一次排序会有一个数到达自己正确的位置
            // 此处已经是一个优化
            //-1的目的是为了不让后面的逻辑数组超出索引
            //毕竟是和下一个元素比较并交换  优化不优化都得-1
            boolean flag =false;
            for(int j=0;j<n-i-1;j++){
                if(array[j] >array[j+1]){
                    int temp =array[j];
                    array[j] =array[j+1];
                    array[j+1] =temp;
                    flag =true;
                }
            }
            for(int p=0;p<array.length;p++)
            {
                System.out.printf(array[p]+",");
            }
            System.out.println(" ");
            if(!flag){
                break;
            }
        }
    }
}
