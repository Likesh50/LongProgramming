/*
 ✅ Problem Statement:
Remove all duplicate characters from a given string in-place while preserving the order.

✅ Constraints:
Do not use any built-in functions.

Do not use extra space (i.e., in-place processing).

For alphabets, keep only the first occurrence.

For digits, keep only the last occurrence.

Input:

a1b2c34c3b2cb3a1d

Output:

abc4231d

 */

public class RemoveDuplicates {

    public static void main(String[] args) {
        char[] str = "a1b2c34c3b2cb3a1d".toCharArray();
        int length = str.length;
        int writeIndex = 0;

        for (int i = 0; i < length; i++) {
            boolean keep = true;

            // Check if character is alphabet
            if (isAlphabet(str[i])) {
                // If it's appeared before, skip it
                for (int j = 0; j < writeIndex; j++) {
                    if (str[i] == str[j]) {
                        keep = false;
                        break;
                    }
                }
            }

            // Check if character is digit
            else if (isDigit(str[i])) {
                // If the digit appears again later, skip it
                for (int j = i + 1; j < length; j++) {
                    if (str[i] == str[j]) {
                        keep = false;
                        break;
                    }
                }
            }

            // If we decided to keep this character, write it to the result
            if (keep) {
                str[writeIndex] = str[i];
                writeIndex++;
            }
        }

        // Print the result
        for (int i = 0; i < writeIndex; i++) {
            System.out.print(str[i]);
        }
    }

    // Helper to check if char is alphabet
    static boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    // Helper to check if char is digit
    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
