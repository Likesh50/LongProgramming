

//https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int res=-1;

        while(l<=r)
        {
            int mid=l+(r-l)/2;

            if(nums[mid]==target)
            {
                return mid;
            }

            if(nums[l]<=nums[mid])
            {
                if(nums[mid]>target && target>=nums[l])
                {
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
            else
            {
                if(nums[r]>=target && nums[mid]<target)
                {
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return res;
    }
}