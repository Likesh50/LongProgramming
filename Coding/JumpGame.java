public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // If the current position is beyond the maximum reachable index, return false
            if (i > maxReach) {
                return false;
            }
            // Update the maximum reachable index
            maxReach = Math.max(maxReach, i + nums[i]);

            // Early exit: If we already can reach or pass the last index
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1));  // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2));  // Output: false
    }
}
