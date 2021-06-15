package com.structure.queue;

import java.util.Stack;

/**
 * @Author: yangzhi
 * @Description: com.structure.queue
 * @Date: Create in 2021-05-10 2242
 */
public class QueueWithStack {
    //第一个为了入队
    private Stack<Integer> first;
    //第二个为了出队
    private Stack<Integer> second;

    public QueueWithStack(){
        first =new Stack<Integer>();
        second =new Stack<Integer>();
    }
    public Boolean enqueue(int val){
        first.push(val);
        return true;
    }

    public int dequeue()
    {
        if(second.isEmpty()){
            if(first.isEmpty())
            {
                //队列中没有值
                return Integer.MIN_VALUE;
            }
            while (!first.isEmpty()){
                second.push(first.pop());
            }
        }
        int res = second.pop();
        return res;
    }

    public static void main(String[] args) {
        QueueWithStack queueWithStack = new QueueWithStack();
        System.out.println("hha");
    }
}
