/*
 * Given multiple strings, remove the common fragment of 3 consecutive words that appears in all the strings.

✅ Sample Input:

S1 = "Every morning I want to do exercise regularly"
S2 = "Every morning I want to do meditation without fail"
S3 = "It is important that I want to be happy always"
✅ Output:

S1 = Every morning do exercise regularly
S2 = Every morning do meditation without fail
S3 = It is important that be happy always
Removed fragment = I want to

 */

 public class RemoveCommonFragment {

    // Function to manually tokenize a string into words (no split used)
    static String[] getWords(String str) {
        char[] chars = str.toCharArray();
        String[] words = new String[50]; // Max 50 words for safety
        int index = 0;
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                currentWord.append(chars[i]);
            } else {
                if (currentWord.length() > 0) {
                    words[index++] = currentWord.toString();
                    currentWord.setLength(0);
                }
            }
        }

        if (currentWord.length() > 0) {
            words[index++] = currentWord.toString();
        }

        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = words[i];
        }
        return result;
    }

    // Function to generate all 3-word fragments
    static String[] generateFragments(String[] words) {
        String[] fragments = new String[words.length - 2];
        for (int i = 0; i < words.length - 2; i++) {
            fragments[i] = words[i] + " " + words[i + 1] + " " + words[i + 2];
        }
        return fragments;
    }

    // Function to check if a fragment exists in word array
    static boolean containsFragment(String[] words, String fragment) {
        for (int i = 0; i < words.length - 2; i++) {
            String testFragment = words[i] + " " + words[i + 1] + " " + words[i + 2];
            if (testFragment.equals(fragment)) {
                return true;
            }
        }
        return false;
    }

    // Function to remove the fragment from the word array
    static String removeFragment(String[] words, String fragment) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length;) {
            if (i <= words.length - 3) {
                String testFragment = words[i] + " " + words[i + 1] + " " + words[i + 2];
                if (testFragment.equals(fragment)) {
                    i += 3; // skip the fragment
                    continue;
                }
            }
            result.append(words[i]).append(" ");
            i++;
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String s1 = "Every morning I want to do exercise regularly";
        String s2 = "Every morning I want to do meditation without fail";
        String s3 = "It is important that I want to be happy always";

        String[] words1 = getWords(s1);
        String[] words2 = getWords(s2);
        String[] words3 = getWords(s3);

        String[] fragments1 = generateFragments(words1);

        String commonFragment = null;

        for (int i = 0; i < fragments1.length; i++) {
            String fragment = fragments1[i];
            if (containsFragment(words2, fragment) && containsFragment(words3, fragment)) {
                commonFragment = fragment;
                break;
            }
        }

        if (commonFragment != null) {
            System.out.println("S1 = " + removeFragment(words1, commonFragment));
            System.out.println("S2 = " + removeFragment(words2, commonFragment));
            System.out.println("S3 = " + removeFragment(words3, commonFragment));
            System.out.println("Removed fragment = \"" + commonFragment + "\"");
        } else {
            System.out.println("No common fragment found.");
        }
    }
}
