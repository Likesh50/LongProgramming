public class ReduceToOne {
    public static void main(String[] args) {
        System.out.println(minSteps(8));   // Output: 3
        System.out.println(minSteps(13));  // Output: 4
    }

    public static int minSteps(int n) {
        int steps = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                // n is even
                n = n / 2;
            } else {
                if (n == 3 || (n & 3) == 1) {
                    n--;
                } else {
                    n++;
                }
            }
            steps++;
        }
        return steps;
    }
}
