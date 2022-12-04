package com.company.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {

    static Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            VerticalBinayTree obj = new VerticalBinayTree();
            ArrayList <Integer> res = obj.verticalOrder(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();

        }
    }
}
// } Driver Code Ends


//User function Template for Java


public class VerticalBinayTree
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root)
    {
        // add your code here
        TreeMap<Integer, List<Integer>> map=new TreeMap<>();
        Node temp=root;
        int height=0;

        subTree(temp, map, height);

        ArrayList<Integer> arr=new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            arr.addAll(entry.getValue());
        }

        return arr;
    }


    static void subTree(Node temp, TreeMap<Integer, List<Integer>> map, int height){

        if(temp==null)
            return;

        List<Integer> l=map.get(height);

        if(l==null)
        {
            l=new LinkedList<>();
        }
        l.add(temp.data);

        map.put(height, l);

        subTree(temp.left, map, height-1);
        subTree(temp.right, map, height+1);

    }


}