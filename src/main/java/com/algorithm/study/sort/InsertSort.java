package com.algorithm.study.sort;

import java.util.Arrays;

/**
 * @Author: yangzhi
 * @Description: O(n²) 稳定 原地
 * i代表要插入的元素
 * j最初代表要插入位置i的前一个元素
 * 如果array[j]>array[i]
 * 说明array[j]要往后挪一个元素
 * arra[i]再和array[j-1]做比较
 * 最终j+1的位置是符合array[i]的位置 因为array[i]的位置会被其它挪元素的j+1取代 因此需要中间变量value
 *
 * @Date: Create in 2021-05-12 2250
 */
public class InsertSort {
    private void insert(int[] array)
    {
        if(array ==null || array.length==1)
        {
            return;
        }
        for(int i=1;i<array.length;i++)
        {
            int value =array[i];
            int j =i-1;
            for(;j>=0;j--)
            {
                if(array[j] >value)
                {
                    array[j+1] =array[j];
                }else
                {
                    //这里默认的条件是 j这个数 是已排序的最大值,如果比这个值还大，那么前面的没必要继续比了
                    break;
                }
            }
            //经过上面的循环操作 j的值最小是一个比0更小的值
            array[j+1] =value;
            System.out.println(Arrays.toString(array));
        }
    }




    public static void main(String[] args) {
        int[] array ={4,6,7,3,1,2};
        InsertSort insertSort =new InsertSort();
        insertSort.insert(array);
    }
}
