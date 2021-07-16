package com.algorithm.study.heap;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * @Author: yangzhi
 * @Description: 两种性质的树
 * 1.符合完全二叉树 最大高度相差1 靠左排列
 * 2.子节点都小于父节点(大顶堆)
 *   子节点都大于父节点(小顶堆)
 * @Date: Create in 2021-07-14 1127
 */
public class Heap {
    private int[] a;// 数组 从下标1开始存储数据
    private int n; // 对可以存储的最大数据个数
    private int count; //堆中已存储的数据个数

    public Heap(int capacity)
    {
        a =new int[capacity +1];
        n =capacity;
        count =0;
    }

    /**
     * 自下向上 最后一个节点不管是左子树还是右子树 /2之后都是 父节点索引
     * 堆的插入操作是自下向上的 因为a[count] =data 然后 i再一直除以2 索引越来越小
     * @param data
     */
    public void insert(int data){
        if(count >=n)
        {
            System.out.println("heap is full");
            //堆满了
            return;
        }
        ++count;
        a[count] =data;
        int i=count;
        while (i/2 >0 && a[i] >a[i/2]){
            swap(a,i,i/2);
            i=i/2;
        }
    }

    /**
     * 删除堆顶元素  肯定得自上向下
     */
    public void removeMax()
    {
        if(count ==0)
        {
            System.out.println("heap is empty");
            return;
        }
        //将最后一个元素往堆顶放 先保证全完二叉树的特性 再从堆顶往下迭代替换元素
        a[1] =a[count];
        --count;
        heapify(a,count,1);
    }

    /**
     * 自上向下遍历堆
     * @param a 数组
     * @param count 当前堆数量
     * @param i 堆顶
     */
    private void heapify(int[] a,int count,int i)
    {
        while (true){
            int maxPos =i;
            //小于堆数量 并且堆顶节点小于堆子节点
            //和节点的左节点做对比 如果小于 就更新pos
            if(i*2 <=count && a[i] <a[i*2]){
                maxPos =i*2;
            }
            //和节点的右子节点做对比 如果小于 就更新pos
            //都是先判断索引是否超了 没超就比较值
            if(i*2+1 <=count && a[maxPos] < a[i*2+1])
            {
                maxPos =i*2+1;
            }
            //maxPos没变 退出
            if(maxPos ==i)
            {
                break;
            }
            //交换
            swap(a,i,maxPos);
            i=maxPos;
        }
    }

    /**
     * 建堆
     * @param a
     * @param n
     */
    private void buildHeap(int[] a,int n)
    {
        //n/2 代表叶子节点的父节点(前提是 它属于全完二叉树)
        for(int i=n/2;i>=1;i--)
        {
            heapify(a,n,i);
        }
    }


    public void swap(int[] a,int i,int targetIndex)
    {
        int temp =a[targetIndex];
        a[targetIndex] =a[i];
        a[i]=temp;
    }

    // n表示数据的个数，数组a中的数据从下标1到n的位置。
    public void sort(int[] a,int n)
    {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            heapify(a, --k, 1);
        }
    }

    public static void main(String[] args) {
        Heap heap =new Heap(10);
        for(int i=1;i<11;i++)
        {
            heap.insert(i);
        }
        System.out.println(Arrays.toString(heap.a));
        heap.insert(99);
    }
}
