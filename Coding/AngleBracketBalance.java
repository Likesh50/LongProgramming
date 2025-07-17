public class AngleBracketBalance {
    public static void main(String[] args) {
        System.out.println(checkBalanced("<><>"));     // Balanced
        System.out.println(checkBalanced("<<>><"));    // Not Balanced
    }

    public static String checkBalanced(String str) {
        int balance = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '<') {
                balance++;
            } else if (ch == '>') {
                balance--;
                // If more closing than opening at any point → not balanced
                if (balance < 0) return "Not Balanced";
            }
        }

        // At end, all opened '<' must be closed
        return balance == 0 ? "Balanced" : "Not Balanced";
    }
}
