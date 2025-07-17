public class CustomChecksum {
    public static int calculateChecksum(String input) {
        int n = input.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int digit = input.charAt(n - 1 - i) - '0';  // Reverse index

            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9)
                    digit -= 9;
            }

            sum += digit;
        }

        return (sum % 10 == 0) ? 0 : (10 - (sum % 10));
    }

    public static void main(String[] args) {
        String input = "1234";
        System.out.println("Checksum: " + calculateChecksum(input));  // Output: 4
    }
}
