package com.company.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountSmallerNumberAfterSelf {

    public List<Integer> countSmaller2(int[] nums) {

        int len=nums.length;
        List<Integer> result=new ArrayList<>();
        result.add(0);

        TreeNode root=new TreeNode(nums[len-1]);
        for(int i=len-2;i>=0;i--){
            int count=insertNode(nums[i],root);
            result.add(count);
        }
        Collections.reverse(result);
        return result;

    }

    private int insertNode(int num, TreeNode root) {

        int ans=0;
        boolean isConnected=false;
        TreeNode temp=new TreeNode(num);
        while(!isConnected){
            if(root.val>=num){
                root.count++;
                if(root.left==null){
                    root.left=temp;
                    isConnected=true;
                }
                else{
                    root=root.left;
                }
            }
            else{
                ans+=root.count;
                if(root.right==null){
                    root.right=temp;
                    isConnected=true;
                }
                else
                    root=root.right;
            }
        }

        return ans;
    }

    public List<Integer> countSmaller(int[] nums) {

        int n=nums.length;
        ArrayList<Integer> result=new ArrayList<>();
        int[] arr=new int[n];
        arr[n-1]=0;
        result.add(nums[n-1]);

        for(int i=n-2;i>=0;i--){
            int pos=0;
            pos=binarySearch(result,nums[i]);
            result.add(pos,nums[i]);
            arr[i]=pos;
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());

    }

    private int binarySearch(ArrayList<Integer> currList, int num) {

        if(currList.size()==0)
            return 0;

        else if(currList.size()==1){
            if(currList.get(0)>=num)
                return 0;
            else
                return 1;
        }
        else{
            int mid,left=0,right=currList.size();
            while(left<right){
                mid=left+(right-left)/2;
                if(currList.get(mid)>=num)
                    right=mid;
                else
                    left=mid+1;
            }
            return left;
        }

    }

    public static void main(String[] args) {

        CountSmallerNumberAfterSelf c=new CountSmallerNumberAfterSelf();
        System.out.println(c.countSmaller(new int[]{5,2,6,1}));
    }

}




class TreeNode{

    int val;
    int count=1;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }

}
