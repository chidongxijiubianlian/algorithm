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
            tree = new TreeNodeInt(val);
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


    /**
     * 删除比较复杂
     * 删除没有子节点
     * 删除一个子节点
     * 删除两个子节点
     * 都不太一样
     * @param val
     * @return
     */
    public void delete(int val){
        TreeNodeInt p = tree; // p指向要删除的节点，初始化指向根节点
        TreeNodeInt pp = null; // pp记录的是p的父节点
            while (p != null && p.val != val) {
                pp = p;
                if (val > p.val) p = p.right;
                else p = p.left;
            }
            if (p == null) return; // 没有找到

            // 要删除的节点有两个子节点
            if (p.left != null && p.right != null) { // 查找右子树中最小节点
                TreeNodeInt minP = p.right;
                TreeNodeInt minPP = p; // minPP表示minP的父节点
                while (minP.left != null) {
                    minPP = minP;
                    minP = minP.left;
                }
                p.val = minP.val; // 将minP的数据替换到p中
                //双节点节点 这一步只是做了替换 其实要看懂还得是下面的逻辑
                p = minP;
                pp = minPP;
            }

            // 删除节点是叶子节点或者仅有一个子节点
            TreeNodeInt child; // p的子节点
            if (p.left != null) child = p.left;
            else if (p.right != null) child = p.right;
            else child = null;

            // 要删除的节点是根节点 仅将孩子节点赋值给根节点即可 反正是叶子节点
            if (pp == null) tree = child;
            // 被删除的节点有左子节点  那么父节点指向左子节点
            else if (pp.left == p) pp.left = child;
            // 被删除的节点有右子节点  那么父节点指向右子节点
            else pp.right = child;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree =new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(8);
        binarySearchTree.insert(6);
        binarySearchTree.insert(9);

        binarySearchTree.delete(2);
    }
}
