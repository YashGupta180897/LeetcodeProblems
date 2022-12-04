package com.company.BinaryTree;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(Integer data){
        if(root==null)
            root=new TreeNode(data);
        else
            root.insert(data);
    }

    public TreeNode find(Integer data){
        TreeNode temp=root;
        while(temp!=null){
            if(temp.getData().equals(data))
                return temp;
            else if(temp.getData()>data)
                temp=temp.getLeft();
            else
                temp=temp.getRight();
        }
        return null;
    }

    public void delete(Integer data){
        TreeNode temp=root;
        TreeNode curr=temp.getLeft();
        while(curr!=null){
            if(temp.getData().equals(data)){

            }
        }

    }

}
