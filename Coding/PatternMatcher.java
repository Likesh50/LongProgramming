/*
 * Problem Description
You are given a string and a pattern. Your task is to find the first match of the pattern in the string.

The pattern may include two special characters:

* — The preceding character can occur zero or more times.

+ — The preceding character must occur at least once, but can appear any number of times.

Return the first substring from the input string that matches the given pattern according to the rules above.



Input:


String:  abcbcbabb  
Pattern: cb*cab+

Output:

cbbcabb

 */

public class PatternMatcher {

    public static void main(String[] args) {
        String text1 = "abcbcbabb";
        String pattern1 = "cb*cab+";
        System.out.println(firstMatch(text1, pattern1));  // Output: cbbcabb

        String text2 = "abcbbacbk";
        String pattern2 = "bbk*ac+";
        System.out.println(firstMatch(text2, pattern2));  // Output: bbac
    }

    public static String firstMatch(String text, String pattern) {
        int n = text.length();

        for (int i = 0; i < n; i++) {
            int tIdx = i;
            int pIdx = 0;
            int matchStart = -1;

            while (tIdx < n && pIdx < pattern.length()) {
                char pc = pattern.charAt(pIdx);

                if (pIdx + 1 < pattern.length() && (pattern.charAt(pIdx + 1) == '*' || pattern.charAt(pIdx + 1) == '+')) {
                    char op = pattern.charAt(pIdx + 1);
                    int count = 0;

                    while (tIdx < n && text.charAt(tIdx) == pc) {
                        tIdx++;
                        count++;
                    }

                    if (op == '+' && count == 0) {
                        break;  // + requires at least one match
                    }

                    if (matchStart == -1) matchStart = i;
                    pIdx += 2;
                } else {
                    if (text.charAt(tIdx) != pc) {
                        break;
                    }

                    if (matchStart == -1) matchStart = i;
                    tIdx++;
                    pIdx++;
                }
            }

            if (pIdx == pattern.length()) {
                return text.substring(i, tIdx);
            }
        }

        return "";  // No match found
    }
}
