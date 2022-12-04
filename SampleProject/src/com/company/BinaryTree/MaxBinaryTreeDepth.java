package com.company.BinaryTree;

import java.util.LinkedList;

public class MaxBinaryTreeDepth {

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int count=0;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.addFirst(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.removeFirst();
                if(node.getLeft()!=null)
                    queue.addLast(node.getLeft());
                if(node.getRight()!=null)
                    queue.addLast(node.getLeft());
            }
            count++;
        }
        return count;
    }
}
