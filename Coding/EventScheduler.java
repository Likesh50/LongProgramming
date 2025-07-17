/*
 * You are tasked with creating a system that processes event schedules. Each event is represented by a pair of integers:
[start_time, end_time].

Your goal is to determine the maximum number of events a person can attend without overlapping.


 */


import java.util.Arrays;
import java.util.Comparator;

public class EventScheduler {
    public static int maxEvents(int[][] events) {
        // Sort events by their end time (greedy choice)
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastEndTime = -1;

        for (int[] event : events) {
            int start = event[0];
            int end = event[1];

            if (start >= lastEndTime) {
                count++;
                lastEndTime = end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] events1 = {{1, 3}, {2, 4}, {3, 5}, {7, 8}};
        System.out.println(maxEvents(events1));  // Output: 3

        int[][] events2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(maxEvents(events2));  // Output: 4

        int[][] events3 = {{1, 5}, {2, 6}, {3, 7}, {4, 8}};
        System.out.println(maxEvents(events3));  // Output: 1
    }
}
