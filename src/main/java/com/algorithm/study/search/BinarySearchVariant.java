package com.algorithm.study.search;

/**
 * @Author: yangzhi
 * @Description: 变体二分查找
 * @Date: Create in 2021-06-22 1621
 */
public class BinarySearchVariant {

    public static void main(String[] args) {
        int[] array =new int[]{1,3,4,5,6,8,8,8,11,18};
        System.out.println(binarySearchFirstEq(array,10,8));
        System.out.println(binarySearchLastEq(array,10,8));
        System.out.println(binarySearchFirstGt(array,10,8));
        System.out.println(binarySearchLastGt(array,10,8));
    }

    /**
     * 查找第一个值等于给定值的元素
     * 查找首个值为value的元素
     * 单独处理等于
     * 1,3,4,5,6,8,8,8,11,18
     * 寻找8
     * 首先找到
     * @param array
     * @param n
     * @param value
     * @return 返回元素的索引
     */
    public static int binarySearchFirstEq(int[] array,int n,int value)
    {
        int low,high;
        low =0;
        high =n-1;
        while (low <=high){
            int mid =low +((high-low)>>1);
            if(value <array[mid])
            {
                high =mid-1;
            }else if(value >array[mid])
            {
                low =mid+1;
            }else{
                if(mid ==0 || array[mid-1] !=value)
                {
                    return mid;
                }else
                {
                    high =mid-1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * 得到最后一个和value相等的索引
     * @param array
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchLastEq(int[] array,int n,int value)
    {
        int high =n-1;
        int low =0;
        while (low <=high){
            int mid =low +((high -low)>>1);
            if(value < array[mid])
            {
                high =mid-1;
            }else if(value >array[mid])
            {
                low =mid+1;
            }else
            {
                if(mid ==n-1 || array[mid +1] !=value)
                {
                    return mid;
                }else
                {
                    //array[mid]==value时 后面还有相同的 要向后找 向后找需要low =mid +1;
                    low =mid+1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素 2,3,5,5,6,7 4
     * @param array
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchFirstGt(int[] array,int n,int value)
    {
        int low =0;
        int high =n-1;
        while (low <=high){
            int mid =low +((high-low)>>1);
            if(value <=array[mid])
            {
                if(mid ==0 || value >array[mid-1])
                {
                    return mid;
                }else
                {
                    //value 仍然小于 mid-1时 需要继续往前面找 往前找 high 变小 往后找 low 变大
                    high =mid-1;
                }
            }else{
                //往后找 low变大
                low =mid +1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param array
     * @param n
     * @param value
     * @return
     */
    public static int binarySearchLastGt(int[] array,int n,int value)
    {
        int low =0;
        int high =n-1;
        while (low <=high){
            int mid =low +((high-low)>>1);
            if(value >=array[mid])
            {
                if(mid ==n-1 || value < array[mid+1])
                {
                    return mid;
                }else
                {
                    low =mid+1;
                }
            }else
            {
                high =mid-1;
            }
        }
        return -1;
    }


}
