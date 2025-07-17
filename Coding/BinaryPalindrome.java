public class BinaryPalindrome {
    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 10;

        checkBinaryPalindrome(n1);  // 9 → 1001 → Palindrome
        checkBinaryPalindrome(n2);  // 10 → 1010 → Not Palindrome
    }

    public static void checkBinaryPalindrome(int n) {
        String binary = decimalToBinary(n);
        System.out.print("Binary: " + binary + " → ");
        if (isPalindrome(binary)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    // Convert decimal to binary string manually
    public static String decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);  // prepend the remainder
            n = n / 2;
        }
        return binary.toString();
    }

    // Check if string is palindrome
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
