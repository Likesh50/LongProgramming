

//https://leetcode.com/problems/find-the-highest-altitude/

class Solution {
    public int largestAltitude(int[] gain) {
        int max=0;
        int ini=0;
        for(int i=0;i<gain.length;i++)
        {
            if(ini+gain[i]>max)
            {
                max=ini+gain[i];
            }
            ini=ini+gain[i];
        }
        return max;
    }
}