

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i=0;
        int j=0;
        int ans=0;
        int n=s.length();
        HashSet<Character> freq=new HashSet<>();
        char ch[]=s.toCharArray();

        while(j<n)
        {
            while(j<n && !freq.contains(ch[j]))
            {
                freq.add(ch[j]);
                j++;
            }
            ans=Math.max(ans,j-i);
            while(i<n && j<n && ch[i]!=ch[j])
            {
                freq.remove(ch[i]);
                i++;
            }
            i++;
            j++;
        }
        ans=Math.max(ans,j-i);

        return ans;
    }
}