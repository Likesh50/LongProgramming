

//https://leetcode.com/problems/word-break/

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // faster lookup
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string is always true

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // Check if substring s[j:i] is in the dictionary and s[0:j] is valid
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid split
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak solver = new WordBreak();
        System.out.println(solver.wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
        System.out.println(solver.wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // true
        System.out.println(solver.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
    }
}
