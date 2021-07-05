package com.structure.tree;

/**
 * @Author: yangzhi
 * @Description: 根 左 右
 * @Date: Create in 2021-07-02 1224
 */
public class MiddleOrder {

    public static void main(String[] args) {


        print(getTree());
    }


    public static void print(TreeNode treeNode)
    {
        if(treeNode ==null)
        {
            return;
        }
        print(treeNode.left);
        System.out.print(treeNode.val+",");
        print(treeNode.right);
    }

    public static TreeNode getTree()
    {
        TreeNode left1 =new TreeNode("B");
        TreeNode left1_left =new TreeNode("D");
        TreeNode left1_right =new TreeNode("E");
        left1.left =left1_left;
        left1.right =left1_right;

        TreeNode right1 =new TreeNode("C");
        TreeNode right1_lefth =new TreeNode("F");
        TreeNode right1_right =new TreeNode("G");
        right1.left =right1_lefth;
        right1.right =right1_right;
        TreeNode treeNode = new TreeNode("A");
        treeNode.left =left1;
        treeNode.right =right1;
        return treeNode;
    }
}
