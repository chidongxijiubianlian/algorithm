package com.structure.queue;

/**
 * @Author: yangzhi
 * @Description: 尾插法 出头
 * @Date: Create in 2021-05-10 2221
 */
public class QueueWithLinkedList {
    private ListNode head;
    private ListNode tail;

    public QueueWithLinkedList(){

    }

    public Boolean enqueue(int val){
        if(head ==null || tail ==null)
        {
            ListNode listNode =new ListNode(val);
            head =listNode;
            tail =listNode;
        }else
        {
            tail.next =new ListNode(val);
            tail =tail.next;
        }
        return true;
    }

    public int dequeue(){
        if(head ==null)
        {
            return Integer.MIN_VALUE;
        }
        int res =head.val;
        head =head.next;
        if(head ==null)
        {
            //也算最后让首位相连了
            tail =null;
        }
        return res;
    }





    static class ListNode{
        ListNode next;
        int val;
        public ListNode(int val){
            this.val =val;
        }
        public ListNode(ListNode listNode,int val){
            this.val =val;
            //new的时候属于头插法
            this.next =listNode;
        }
    }

    public static void main(String[] args) {
        QueueWithLinkedList queueWithLinkedList = new QueueWithLinkedList();

        System.out.println("hah");
    }
}
