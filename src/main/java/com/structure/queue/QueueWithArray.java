package com.structure.queue;

/**
 * @Author: yangzhi
 * @Description: com.structure.queue
 * @Date: Create in 2021-05-10 2202
 */
public class QueueWithArray {
    private int head =0;
    private int tail =0;
    private int size =0;
    private int[] array;

    public QueueWithArray(int size)
    {
        this.size =size;
        array =new int[size];
    }

    public boolean enqueue(int val)
    {
        if(tail ==size)
        {
            //说明有很大的空隙
            if(head !=0)
            {
                for (int i = head; i <tail; i++) {
                    array[i-head] =array[i];
                }
                tail -=head;
                head =0;
            }else
            {
                //说明队列已经满了
                return false;
            }
        }
        array[tail] =val;
        tail++;
        return true;
    }

    public int dequeue()
    {
        if(tail ==head) {
            //说明数组中没有值
            return Integer.MIN_VALUE;
        }
        int res =array[head];
        head++;
        return res;
    }

    public static void main(String[] args) {
        QueueWithArray queueWithArray =new QueueWithArray(4);
        System.out.println("hha");
    }
}
