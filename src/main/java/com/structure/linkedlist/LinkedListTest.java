package com.structure.linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yangzhi
 * @Description: com.algorithm.study
 * @Date: Create in 2021-04-20 2142
 */
public class LinkedListTest {


    //反转链表
    public static void main(String[] args) {
        ListNode listNode = generHeader(new int[]{1, 2, 3, 4, 5});
        ListNode kthFromEnd = getKthFromEnd(listNode, 2);
    }

    /**
     * 链表的反转 精髓 设置空的头节点
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head)
    {
        ListNode curr =head;
        ListNode pre =null;
        while (curr !=null)
        {
            ListNode next =curr.next;
            curr.next =pre;
            pre =curr;
            curr =next;
        }
        return pre;
    }


    /**
     * 合并两个有序链表
     */
    public ListNode MergeTwoList(ListNode l1,ListNode l2)
    {
        if(l1 ==null) {return l2;}
        if(l2 ==null) {return l1;}
        else if(l1.val < l2.val)
        {
            l1.next =MergeTwoList(l1.next,l2);
            return l1;
        }else
        {
            l2.next =MergeTwoList(l2.next,l1);
            return l2;
        }
    }



    /**
     * 第二种解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode MergeTwoList2(ListNode l1,ListNode l2)
    {
        if(l1 ==null && l2 !=null)
        {
            return l2;
        }
        if(l1 !=null && l2 ==null)
        {
            return l1;
        }
        ListNode head = new ListNode(-99);
        ListNode res =head;
        while (l1 !=null && l2 !=null){
            if(l1.val < l2.val)
            {
                head.next =l1;
                l1 =l1.next;
            }else{
                head.next =l2;
                l2 =l2.next;
            }
            head = head.next;
        }
        if(l1 !=null && l2 ==null)
        {
            head.next =l1;
        }else if(l1 ==null && l2 !=null)
        {
            head.next =l2;
        }
        return res.next;
    }




    /**
     * 判断链表中是否有环
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> ListNodeSet =new HashSet<ListNode>();
        while (head !=null)
        {
            if(ListNodeSet.contains(head))
            {
                return head;
            }else
            {
                ListNodeSet.add(head);
            }
            head =head.next;
        }
        return null;
    }




    /**
     * 删除链表中倒数第k个节点
     */
    public static ListNode getKthFromEnd(ListNode head, int n) {
        ListNode temp =head;
        int listNodeLength =0;
        while (temp !=null)
        {
            listNodeLength++;
            temp = temp.next;
        }
        //倒数的时候少了一位  一共四个数 倒数第二个 是整数第三个
        int removeIndex =listNodeLength-n+1;
        //如果是倒数第一 就不能提前知道了,因此放了个空节点
        ListNode temp2 =new ListNode(99,head);
        ListNode temp3 = temp2;
        int counter =0;
        while (temp2 !=null)
        {
            if((counter+1) ==removeIndex)
            {
                temp2.next =temp2.next.next;
                return temp3.next;
            }
            temp2 = temp2.next;
            counter++;
        }
        return temp3.next;
    }


    /**
     * 删除链表中倒数第k个节点
     * 谁能想到添加一个0节点 会让fast到null时 slow正好是被删节点的上一个节点
     * fuck
     */
    public static ListNode getKthFromEnd2(ListNode head, int n) {
        ListNode zeroNode =new ListNode(-99,head);
        ListNode fast =head;
        ListNode slow =zeroNode;
        for (int i=0;i<n;i++)
        {
            fast =fast.next;
        }
        while (fast !=null)
        {
            fast = fast.next;
            slow =slow.next;
        }
        slow.next =slow.next.next;
        return zeroNode.next;
    }

    public static ListNode generHeader(int[] array)
    {
        ListNode listNode =new ListNode(-1);
        ListNode tempHeader =listNode;
        for(int i=0;i<array.length;i++)
        {
            listNode.next =new ListNode(array[i]);
            listNode = listNode.next;
        }
        return tempHeader.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode temp =head;
        int length =0;
        while(temp !=null)
        {
            ++length;
            temp =temp.next;
        }
        int res =length/2+1;
        length =0;
        while(head !=null)
        {
            length++;
            if(length ==res)
            {
                return head;
            }
            head = head.next;
        }
        return null;
    }







    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(){

        }
        public ListNode(int val){
            this.val =val;
        }
        public ListNode(int val,ListNode next){
            this.val =val;
            this.next =next;
        }
    }
}
