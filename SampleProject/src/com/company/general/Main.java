package com.company.general;

import java.util.*;

public class Main {

    List<Integer> querySum(int n, int arr[], int q, int queries[])
    {
        // code here

        List<Integer> l1=new ArrayList<>();
        for(int i=0;i<(2*q);i+=2){
            int sum=0;
            for(int z=queries[i]-1;z<queries[i+1];z++){
                sum+=arr[z];
            }
            l1.add(sum);
        }
        System.out.println(l1);
        return l1;
    }

    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        int minPrice2=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]<minPrice)
                minPrice=A[i];
            else if(A[i]-minPrice>maxProfit){
                maxProfit=A[i]-minPrice;
                minPrice2=minPrice;
            }
        }

        ArrayList<Integer> l1=new ArrayList<>();
        l1.add(minPrice2);
        l1.add(maxProfit);
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        list.add(l1);
        StringBuilder sb=new StringBuilder();
        sb.append('0');
        sb=null;

        sb.append('0');


        System.out.println(list);
        return list;


    }

    static int countSetBits(int n){

        // Your code here
        int count=0;
        int x=Integer.toBinaryString(n).length()-1;
        int sum= x*(int) Math.pow(2,x-1);
        int start= (int) (Math.pow(2,x));
        for(int i=start;i<=n;i++){
            count+=count(i);
        }
        return count+sum;

    }

    static int count(int n){
        int count=0;
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }


    static int search(int[] inorder, int root, int previosRootIndex){
        for(int i=0;i<previosRootIndex;i++){
            if(inorder[i]==root)
                return i;
        }
        return -1;
    }
    static boolean checktree(int preorder[], int inorder[], int postorder[], int N)
    {
        // Your code goes here

        int rootIndex=search(inorder, preorder[0], N);

        if (rootIndex != 0)
            checktree(inorder, Arrays.copyOfRange(preorder, 1, N), postorder, rootIndex);

        if (rootIndex != N - 1)
            checktree(Arrays.copyOfRange(inorder, rootIndex+1, N),
                    Arrays.copyOfRange(preorder, 1+rootIndex, N), postorder, N - rootIndex - 1);

        int count=0;
        int[] postOrder2=new int[N];
        postOrder2[count++]=preorder[0];

        for(int i=0;i<N;i++){
            if(postorder[i]!=postOrder2[i])
                return false;
        }
        return true;

    }


    static int maxLen(int arr[], int n)
    {
        // Your code here

        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);
        int res=0,sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(map.containsKey(sum))
                res= Math.max(res, i-map.get(sum));
            else
                map.put(sum,i);
        }
        return res;
    }

    boolean areAnagrams(String s, String s1){

        char[] ch1=s.toCharArray();
        char[] ch2=s1.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        //Arrays.q
        for(int i=0;i<ch1.length;i++){
            if(ch1[i] != ch2[i])
                return false;
        }
        return true;
    }

    int anagram(String txt, String pat){

        int count=0;

        int wordLength=txt.length();
        int subLength=pat.length();
        for(int i=0;i<wordLength-subLength;i=i+subLength){
            String s=txt.substring(i,i+subLength);
            if(areAnagrams(s,pat))
                count++;
        }
        return count;

    }

    public int reverse(int x) {
        int temp=0;
        while(x !=0){
            temp=(temp*10)+x%10;
            x/=10;
        }

        return temp;
    }

    Stack<Integer> sortStack(Stack<Integer> s){

        Stack<Integer> temp=new Stack<>();
        while(!s.empty()){

            int element=s.pop();
            while(!temp.empty() && element < temp.peek()){
                s.push(temp.pop());
            }
            temp.push(element);
        }
        return temp;
    }

    int anagram2(String txt, String pat){

        String[] x1=txt.split("\\s+");
        int wordLength=txt.length();
        int subLength=pat.length();

        int[] textArr=new int[26];
        int[] subArr=new int[26];
        int count=0;

        int i=0;
        for (;i<subLength;i++){
            textArr[txt.charAt(i)-97]++;
            subArr[pat.charAt(i)-97]++;
        }
        if(Arrays.equals(textArr,subArr))
            count++;

        for(;i<wordLength;i++){
            textArr[txt.charAt(i)-97]++;
            textArr[txt.charAt(i-subLength)-97]--;
            if(Arrays.equals(textArr,subArr))
                count++;
        }
        return count;


    }

    public static void main(String[] args) {
	// write your code here

        Main m =new Main();
        int[] arr={        18468 ,6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996,
                11943, 4828, 5437, 32392, 14605, 3903, 154, 293, 12383, 17422, 18717, 19719, 19896, 5448,
                21727 ,14772 ,11539 ,1870 ,19913 ,25668 ,26300 ,17036 ,9895 ,28704,23812 ,31323};
        int[] query={ 1,3,22,26,7,23,3,9,29,40,4,8,30,40,20,23,11,12,15,37,2,35,11,39,7,11,21,34,5,10,11,21,13,22,13,21,16,24,4,5,25,39,11,27,13,17,3,16,15,26,1,35,8,25,4,36,4,36,6,7,6,19,34,39,1,1,6,18,3,5,13,34,24,34,2,7,5,19,6,31,12,30,10,35,1,41,9,17,5,11,23,29,28,36,32,40,2,24,4,10,1,6,8,15,5,25,39,41,6,11,13,21,19,42,13,18,5,18,31,42,3,16,2,10,33,33,2,9,9,17,19,40,7,16,13,41,8,31,12,26,1,9,4,9,2,6,7,26,9,14,14,28,7,24,8,23,1,15,14,22,21,42,14,15,13,22,4,5,7,18,11,27,4,32,6,22,32,34,5,12,1,1,19,25,1,15,15,36,1,9,12,26,19,19,17,29,3,30,5,6,3,18,34,41,1,4,2,31,17,22,1,9,14,15,18,42,8,25,31,31,5,37,1,4,26,30,1,1,5,30,1,3,6,33,4,32,12,31,4,4,1,2,1,2,33,38,8,11,16,28,5,21,12,13,6,12,27,40,3,7,6,14,1,2,8,21,1,1,5,16,12,34,26,41,14,14,6,8,1,14,2,12,2,5,1,20,3,29,24,31,13,26,3,8,33,42,30,38,2,20,1,15,27,30,30,37,14,29,1,11,20,29,13,21,12,20,34,39,2,9,3,30,1,22,1,33,4,27,14,28,1,40,5,9,27,33,14,36,25,42,11,14,3,5,33,37,1,3,13,42,2,15,12,32,1,30,8,15,19,23,15,42,37,39,24,26,15,26,14,22,32,35,20,27,14,28,1,7,34,42,4,12,9,17,3,39,3,5,1,3,7,21,10,23,2,6,14,15,3,6,20,35,1,3,8,37,6,26,10,23,10,11,26,39,17,40,5,33,11,31,3,11,1,28,23,37,11,12,11,30,1,30,32,37,25,28,29,35,1,2,10,27,6,8,2,9,2,3,4,11,13,27,10,32,14,18,5,29,7,11,33,41,4,28,4,12,11,17,13,15,1,8,7,20,3,12,31,32,17,23,8,30,12,25,5,14,1,35,8,15,10,27,10,20,2,3,1,1,1,1,2,31,13,19,9,17,25,35,8,38,19,33,31,34,1,2,2,4,2,4,3,3,8,33,6,7,1,18,22,22,8,30,8,29,1,36,5,37,15,41,4,5,2,6,21,24,4,6,1,2,1,1,2,3,4,9,1,2,4,16,4,18,9,21,1,15,2,32,4,11,20,22,5,9,9,33,13,20,1,2,5,7,6,7,8,10,32,34,39,39,2,8,1,3,1,6,31,32,3,32,36,39,9,23,10,23,15,36,6,18,7,29,19,23,10,28,9,26,34,37,4,29,1,3,18,24,1,4,1,2,4,8,4,29,19,34,5,31,1,2,10,16,6,35,10,27,22,30,14,32,2,11,5,16,1,10,3,11,3,11,12,13,1,23,30,34,13,42};
        //m.querySum(42,arr, 334,query);

        int arr2[] ={15, -2, 2, 1, 7, -8, 10};

        String s="51304 34155 241461 153662 202768 102696 182872 51054 51428 292417 484370 397566 114639 162448 113697 150911 103386 99483 76551 34895 242305 203783 42221 241074 106848 502838 224778 477202 477202 40838 201886 100682 18468 196449 61396 247326 143786 108569 217611 368545 220700 324373 634253 123820 141843 88584 140552 155697 320964 132867 97678 135844 281341 62411 126118 99483 382928 47049 212174 232559 241074 165703 11539 159997 123820 327793 168199 398654 327707 156920 178465 127161 79210 271559 108389 155246 241754 212102 262881 86558 345099 10454 103386 34895 184970 203783 418212 252786 28181 165125 18468 69167 262881 266117 178465 156920 5437 161692 408214 27204 257845 153198 70474 436276 73108 178465 10454 387756 224778 21727 484332 70474 81202 18468 362543 51304 394856 418212 242427 19170 24803 24803 102326 85280 144792 264608 40110 149400 241204 102234 176190 24803 208045 18468 195403 270608 282438 9962 67801 262389 217131 67731 320477 402766 115605 133638 129197 196060 144273 302009 262881 63780 127237 175142 212317 139484 99483 108160 100682 159997 408214 338985 481055 336650 155246 610441 107991 111818 276079 326144 78218 61396 85290 51304 429977 244413 257199 433017 135844 56491 403187 53231 30098 106848 86558 48094 99869 155246 127037 184521 184295 123820 556934 61396 51304 237404 160674 79210 10454 72875 214753 51304 427769 283038 160674 33852 229922 344564 410581 270573 187514 407673 215821 51428 248846 433017 100062 68241 95165 24803 209489 67801 159997 32836 161013 152355 291051 30221 357095 114639 164737 356369 184295 93649 27282 154000 222799 210796 36499 73262 305980 139498 191915 502838 135844 209489 142012 32836 18468 18468 436276 52486 123820 163406 444805 198407 49908 24803 52006 52006 26501 354018 40838 282648 3903 305980 300532 528506 484332 371864 34895 79210 18955 46374 24803 18468 32836 127161 24803 214573 231344 181082 262881 451048 161013 50900 107991 327055 84878 24803 56563 40838 57134 28181 9895 135532 51304 97678 36499 444713 78899 185139 160674 266117 196449 329891 56491 229208 215237 73751 376265 51304 61612 70474 24803 102696 376265 200277 384270 24803 87412 416639 209489 97935 217089 193849 195403 184171 187514 187514 40110 339139 55356 429977";
        //String s2=s.replaceAll(" ", ", ");
        //System.out.println(s2);


        m.stockBuySell(arr2,4);

        maxLen(arr2,7);

        countSetBits(4);

        System.out.println(m.anagram2("aabaabaa", "aaba"));

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(12);
        stack.push(100);
        stack.push(13);
        stack.push(50);
        stack.push(4);

        m.sortStack(stack);

        System.out.println(m.reverse(-2147483648));

    }
}
