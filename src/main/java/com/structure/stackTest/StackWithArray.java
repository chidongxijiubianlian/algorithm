package com.structure.stackTest;

/**
 * @Author: yangzhi
 * @Description: com.structure.stackTest
 * @Date: Create in 2021-05-01 1519
 */
public class StackWithArray {
    int[] array =null;
    int size =0;
    int nowSize =0;

    public StackWithArray(int size)
    {
        this.size =size;
        array =new int[size];
    }


    /**
     * 入栈
     * @return
     */
    public boolean push(int val)
    {
        if(nowSize ==size)
        {
            return false;
        }
        array[nowSize] =val;
        nowSize++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public int pop()
    {
        if(nowSize ==0)
        {
            return Integer.MIN_VALUE;
        }
        int i = array[--nowSize];
        return i;
    }

    /**
     * 品栈
     * @return
     */
    public int peek()
    {
        if(nowSize ==0)
        {
            return Integer.MIN_VALUE;
        }
        return array[nowSize];
    }
}
