package com.structure.queue;

/**
 * @Author: yangzhi
 * @Description: 艺术
 * 判断队列已满:(tail+1)%size
 * 判断队列为空:tail =head
 * head和tail 判断下一个位置 (head+1)%size  (tail+1)%size
 * @Date: Create in 2021-05-10 2305
 */
public class CircleQueueWithArray {
    private int head;
    private int tail;
    private int size;
    private int[] array;

    public CircleQueueWithArray(int size){
        this.size =size;
        array =new int[size];
    }

    public boolean enqueue(int val)
    {
        if((tail+1)%size ==head)
        {
            //队列已满
            return false;
        }
        array[tail] =val;
        tail =(tail+1)%size;
        return true;
    }

    public int dequeue(){
        if(tail ==head)
        {
            //空队列
            return Integer.MIN_VALUE;
        }
        int res =array[head];
        head =(head+1)%size;
        return res;
    }

    public static void main(String[] args) {
        CircleQueueWithArray circleQueueWithArray = new CircleQueueWithArray(5);
        System.out.println("hah");
    }
}
