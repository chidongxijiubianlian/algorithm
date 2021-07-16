package com.structure.tree;

/**
 * @Author: yangzhi
 * @Description: com.structure.tree
 * @Date: Create in 2021-07-02 1427
 */
public class TreeNodeInt {
    int val;
    TreeNodeInt left;
    TreeNodeInt right;
    public TreeNodeInt(int val){
        this.val =val;
    }
    public TreeNodeInt(int val,TreeNodeInt left,TreeNodeInt right){
        this.left =left;
        this.right =right;
        this.val =val;
    }

    public static TreeNodeInt getTree()
    {
        TreeNodeInt left1 =new TreeNodeInt(1);
        TreeNodeInt left1_left =new TreeNodeInt(4);
        TreeNodeInt left1_right =new TreeNodeInt(5);
        left1.left =left1_left;
        left1.right =left1_right;

        TreeNodeInt right1 =new TreeNodeInt(3);
        TreeNodeInt right1_lefth =new TreeNodeInt(6);
        TreeNodeInt right1_right =new TreeNodeInt(7);
        right1.left =right1_lefth;
        right1.right =right1_right;
        TreeNodeInt treeNode = new TreeNodeInt(2);
        treeNode.left =left1;
        treeNode.right =right1;
        return treeNode;
    }
}
