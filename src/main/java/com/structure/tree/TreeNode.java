package com.structure.tree;

/**
 * @Author: yangzhi
 * @Description: com.structure.tree
 * @Date: Create in 2021-07-02 1222
 */
public class TreeNode {
    public String val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(String val){
        this.val =val;
    }
    public TreeNode(String val,TreeNode left,TreeNode right)
    {
        this.left =left;
        this.right =right;
        this.val =val;
    }
}
