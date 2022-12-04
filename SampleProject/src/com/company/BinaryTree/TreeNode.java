package com.company.BinaryTree;

public class TreeNode {

    private Integer data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void insert(Integer data){
        if(data>=this.getData()){
            if(this.getRight()==null)
                this.setRight(new TreeNode(data));
            else
                this.getRight().insert(data);
        }
        else{
            if(this.getLeft()==null)
                this.setLeft(new TreeNode(data));
            else
                this.getLeft().insert(data);
        }
    }
}
