package com.algorithm.study.search;

/**
 * @Author: yangzhi
 * @Description: com.algorithm.study.search
 * @Date: Create in 2021-06-22 1621
 */
public class BinarySearch {

    public static void main(String[] args) {
        //奇数
        int[] array =new int[]{2,6,9,13,56,88};
//        System.out.println(hasValue(array,array.length-1,13));
        System.out.println(hasValueRecursion(array,0,array.length-1,12));
    }
    /**
     * 非递归版
     * @param array
     * @param n
     * @param value
     * @return
     */
    public static Boolean hasValue(int[] array,int n,int value){
        int low =0;
        int high =n;
        while (low <=high){
            int mid =low +((high-low)>>1);
            if(value ==array[mid])
            {
                return true;
            }
            else if(value <array[mid])
            {
                high =mid-1;
            }else
            {
                low =mid+1;
            }
        }
        return false;
    }
    public static Boolean hasValueRecursion(int[] array,int start,int end,int value){
        if(start>end)
        {
            return false;
        }
        int mid =start+((end-start)>>1);
        if(array[mid] ==value)
        {
            return true;
        }else if(value >array[mid])
        {
            return hasValueRecursion(array,mid+1,end,value);
        }else
        {
            return hasValueRecursion(array,start,mid-1,value);
        }
    }
}
