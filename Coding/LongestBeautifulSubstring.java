/*
 * Problem Understanding:
You're given a string word, and you need to find the longest "beautiful" substring.

A substring is beautiful if:
It contains all 5 vowels: 'a', 'e', 'i', 'o', 'u' — at least once.

The vowels appear in increasing sorted order — meaning:

All 'a's must come before all 'e's,

All 'e's before 'i's,

All 'i's before 'o's,

All 'o's before 'u's.

Input: "aeiaaioaaaaeiiiiouuuooaauuaeiu"


 */

public class LongestBeautifulSubstring {

    public static void main(String[] args) {
        String input1 = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        System.out.println(findLongestBeautifulSubstring(input1));  // Output: "aaaaeiiiiouuu"

        String input2 = "maeaiaaioaaaeziiiihoouuuzooaaaeiuugn";
        System.out.println(findLongestBeautifulSubstring(input2));  // Output: "aaaeziiiihoouuu"

        String input3 = "aeeiioouuaaeioueiu";
        System.out.println(findLongestBeautifulSubstring(input3));  // Output: "aeiou"
    }

    public static String findLongestBeautifulSubstring(String word) {
        String vowels = "aeiou";
        int maxLen = 0;
        int start = 0;
        int resultStart = -1;

        int n = word.length();
        int i = 0;

        while (i < n) {
            // Start a new window only if we see 'a'
            if (word.charAt(i) == 'a') {
                int j = i;
                int vowelIndex = 0;

                while (j < n && word.charAt(j) >= vowels.charAt(vowelIndex)) {
                    if (word.charAt(j) == vowels.charAt(vowelIndex)) {
                        // Stay on same vowel
                    } else if (vowelIndex + 1 < 5 && word.charAt(j) == vowels.charAt(vowelIndex + 1)) {
                        // Move to next vowel
                        vowelIndex++;
                    } else if (word.charAt(j) > vowels.charAt(vowelIndex + 1)) {
                        // Invalid order, break
                        break;
                    }
                    j++;

                    // If we reached the last vowel 'u' (index 4), update max
                    if (vowelIndex == 4) {
                        int len = j - i;
                        if (len > maxLen) {
                            maxLen = len;
                            resultStart = i;
                        }
                    }
                }

                i = j; // Skip to end of this invalid/valid sequence
            } else {
                i++;
            }
        }

        return resultStart == -1 ? "0" : word.substring(resultStart, resultStart + maxLen);
    }
}
