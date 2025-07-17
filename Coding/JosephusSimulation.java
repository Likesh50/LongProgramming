import java.util.*;

public class JosephusSimulation {
    public static void main(String[] args) {
        int N = 5;
        int K = 2;
        int winner = simulateJosephus(N, K);
        System.out.println("The winner is at position: " + winner);
    }

    public static int simulateJosephus(int N, int K) {
        List<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        int index = 0;
        while (circle.size() > 1) {
            index = (index + K - 1) % circle.size();
            System.out.println("Eliminated: " + circle.get(index));
            circle.remove(index);
        }

        return circle.get(0);
    }
}
