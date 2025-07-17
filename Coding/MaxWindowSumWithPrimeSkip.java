public class MaxWindowSumWithPrimeSkip {
    
    // Prime checker
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i*i <= num; i++)
            if (num % i == 0) return false;
        return true;
    }

    public static int maxWindowSum(int[] arr, int k) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            int j = i;

            while (j < i + k) {
                sum += arr[j];

                // If current number is prime, skip next one
                if (isPrime(arr[j]) && j + 1 < i + k) {
                    j += 2; // skip next
                } else {
                    j += 1;
                }
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1, 5, 6};
        int k = 4;
        System.out.println("Max valid window sum: " + maxWindowSum(arr, k)); // Output: 8
    }
}
