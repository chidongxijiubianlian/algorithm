package com.structure.tree;

/**
 * @Author: yangzhi
 * @Description: com.structure.tree
 * @Date: Create in 2021-07-02 1426
 */
public class BinarySearchTree {
    private TreeNodeInt tree;

    public void insert(int val) {
        TreeNodeInt nodeInt = tree;
        if (nodeInt == null) {
            //创建根节点
            nodeInt = new TreeNodeInt(val);
            return;
        }
        while (nodeInt != null) {
            if (val > nodeInt.val) {
                if (nodeInt.right == null) {
                    nodeInt.right = new TreeNodeInt(val);
                    return;
                }
                nodeInt = nodeInt.right;
            } else {
                if (nodeInt.left == null) {
                    nodeInt.left = new TreeNodeInt(val);
                    return;
                }
                nodeInt = nodeInt.left;
            }
        }
    }

    public TreeNodeInt find(int val)
    {
        TreeNodeInt node =tree;
        if(node ==null)
        {
            return null;
        }
        while (node !=null){
            if(val <node.val)
            {
                node =node.left;
            }else if(val >node.val)
            {
                node =node.right;
            }else
            {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree =new BinarySearchTree();
        TreeNodeInt treeNodeInt =TreeNodeInt.getTree();
        binarySearchTree.tree =treeNodeInt;
        TreeNodeInt treeNodeInt1 = binarySearchTree.find(20);
        System.out.println("res is "+(treeNodeInt1==null?"没有":treeNodeInt1.val));
    }
}
