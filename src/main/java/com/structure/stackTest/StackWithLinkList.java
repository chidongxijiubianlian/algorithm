package com.structure.stackTest;

/**
 * @Author: yangzhi
 * @Description: 链表实现的栈用的是头插法 整个过程仅关注头节点即可
 * @Date: Create in 2021-05-04 1638
 */
public class StackWithLinkList {

    ListNode top;
    public StackWithLinkList(){
    }

    public boolean push(int val)
    {
        if(top ==null)
        {
            top =new ListNode(val);
        }else
        {
            top =new ListNode(top,val);
        }
        return true;
    }

    public int pop()
    {
        if(top ==null)
        {
            return Integer.MIN_VALUE;
        }
        int res =top.val;
        top =top.next;
        return res;
    }

    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(){

        }

        public ListNode(int val){
            this.val =val;
        }
        public ListNode(ListNode next,int val){
            this.val =val;
            this.next =next;
        }
    }

    public static void main(String[] args) {
        StackWithLinkList stackWithLinkList = new StackWithLinkList();
        System.out.println("hha");
    }
}
