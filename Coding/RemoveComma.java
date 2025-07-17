import java.util.*;

public class RemoveComma {
    public static void main(String[] args) {
        String input = "1,  3, 4";
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            numbers.add(Integer.parseInt(part.trim()));
        }

        System.out.println(numbers);  // Output: [1, 3, 4]
    }
}
