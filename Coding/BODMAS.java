import java.util.Stack;

public class BODMAS {
    public static void main(String[] args) {
        String expression = "6 + 36 / 3 - 4";  // Example: 6 + 36 ÷ 3 - 4 = 14
        System.out.println("Expression: " + expression);
        System.out.println("Result: " + evaluate(expression));
    }

    public static int evaluate(String expr) {
        expr = expr.replaceAll(" ", "");  // remove spaces
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';  // initial sign

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) || i == expr.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = ch;
                num = 0;
            }
        }

        int result = 0;
        for (int val : stack)
            result += val;
        return result;
    }
}
