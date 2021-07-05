package com.structure.tree;

/**
 * @Author: yangzhi
 * @Description: 根 左 右
 * @Date: Create in 2021-07-02 1224
 */
public class PreOrder {

    public static void main(String[] args) {
        print(MiddleOrder.getTree());
    }


    public static void print(TreeNode treeNode)
    {
        if(treeNode ==null)
        {
            return;
        }
        System.out.print(treeNode.val+",");
        print(treeNode.left);
        print(treeNode.right);
    }
}
