

public class Main {
    public static void main(String[] args) {
        double num = 25;
        double sqrt = squareRoot(num);
        System.out.println("Square root of " + num + " is: " + sqrt);
    }

    static double squareRoot(double n) {
        double low = 0, high = n;
        double mid;
        double eps = 1e-6; // accuracy

        if (n < 1) high = 1; // For numbers like 0.25

        while ((high - low) > eps) {
            mid = (low + high) / 2;
            if (mid * mid > n)
                high = mid;
            else
                low = mid;
        }
        return (low + high) / 2;
    }
}
