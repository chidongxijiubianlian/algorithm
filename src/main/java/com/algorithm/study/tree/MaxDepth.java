package com.algorithm.study.tree;

import com.structure.tree.MiddleOrder;
import com.structure.tree.TreeNode;

/**
 * @Author: yangzhi
 * @Description: com.algorithm.study.tree
 * @Date: Create in 2021-07-06 1208
 */
public class MaxDepth {
    public int maxDepth(TreeNode root)
    {
        if(root ==null){
            return 0;
        }
        else{
            int leftHeight =maxDepth(root.left);
            int rightHeight =maxDepth(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = MiddleOrder.getTree();
        MaxDepth maxDepth =new MaxDepth();
        int i = maxDepth.maxDepth(tree);
        System.out.println(i);
    }
}
