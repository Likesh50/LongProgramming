/*
 * Given an array arr[] of non-negative integers, find the first index (0-based) such that the sum of elements before that index equals the sum of elements after it.

If such a point exists, return the index.

If not, return -1.


 */

public class EquilibriumPoint {
    public static int findEquilibriumIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];  // This is now the right sum

            if (leftSum == totalSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findEquilibriumIndex(new int[]{1, 3, 5, 2, 2}));  // Output: 2
        System.out.println(findEquilibriumIndex(new int[]{1}));              // Output: 0
        System.out.println(findEquilibriumIndex(new int[]{1, 2, 3}));        // Output: -1
        System.out.println(findEquilibriumIndex(new int[]{1, 9, 3, 4, 4, 2})); // Output: 2
    }
}
