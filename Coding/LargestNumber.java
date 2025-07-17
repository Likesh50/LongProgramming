

//https://leetcode.com/problems/largest-number/

import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        String strnum[]=new String[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            strnum[i]=Integer.toString(nums[i]);
        }
        

        Arrays.sort(strnum,(a,b)-> (b+a).compareTo(a+b));
        
        if(strnum[0].equals("0"))
        {
            return "0";
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<nums.length;i++)
        {
            str.append(strnum[i]);
        }
        
        return str.toString();
    }
}