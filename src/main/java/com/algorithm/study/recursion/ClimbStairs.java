package com.algorithm.study.recursion;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: yangzhi
 * @Description: 上楼梯 可以 一次两步 也可以一次一步 问 走到第n个楼梯有多少种方式
 * fn = f(n-1) +f(n-2)
 * 第三节楼梯 = 第二阶楼梯方法+第一阶楼梯方法
 * @Date: Create in 2021-05-11 2117
 */
public class ClimbStairs {

    public static AtomicInteger atomicInteger =new AtomicInteger(0);
    public static HashMap<Integer,Integer> hashMap =new HashMap();

    public ClimbStairs(){
        hashMap.put(1,1);
        hashMap.put(2,2);
    }
    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.getNumber(30));
        System.out.println(atomicInteger.get());
    }

    private int getNumber(int n){
        if(hashMap.containsKey(n))
        {
            return hashMap.get(n);
        }
        atomicInteger.getAndIncrement();
        int res =getNumber(n-2)+getNumber(n-1);
        hashMap.put(n,res);
        return res;
    }

    private int getNumberV2(int n)
    {
        if(n ==1)
        {
            return 1;
        }
        if(n ==2)
        {
            return 2;
        }
        int last =1;
        int lastlast =2;
        int curr =0;
        for(int i=3;i<=n;i++)
        {
            curr =last+lastlast;
            last =curr;
            lastlast =last;
        }
        return curr;
    }
}
