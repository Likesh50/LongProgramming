

//https://leetcode.com/problems/maximum-product-of-three-numbers/

import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int first = nums[n-1] * nums[n-2] * nums[n-3];
        int sec = nums[0] * nums[1] * nums[n-1];

        return Math.max(first, sec);
    }
}