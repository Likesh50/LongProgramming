/*
 * You are given an array called paths, where each paths[i] = [cityA, cityB] represents a direct path going from cityA to cityB.

Your task is to:

Print the entire path from the starting city (source) to the destination city, eliminating any cycles inside the graph.

✅ Notes:
The graph will always have exactly one source city and exactly one destination city.

A source city is a city that only appears as a starting point but never as a destination.

A destination city is a city that only appears as a destination but never as a starting point.

There may be cycles in the input, but the valid path is cycle-free from source to destination.

📥 Input:
An array paths where each element is a pair of strings [cityA, cityB] indicating a direct route from cityA to cityB.

📤 Output:
A string representing the full path from source city to destination city in the following format:



 */


import java.util.*;

public class CityPathFinder {

    public static String findPath(List<String[]> paths) {
        Map<String, String> graph = new HashMap<>();
        Set<String> destinations = new HashSet<>();

        // Build graph and collect destination cities
        for (String[] path : paths) {
            graph.put(path[0], path[1]);
            destinations.add(path[1]);
        }

        // Find the source city (which is not present in any destination)
        String source = null;
        for (String city : graph.keySet()) {
            if (!destinations.contains(city)) {
                source = city;
                break;
            }
        }

        // Build the path
        StringBuilder result = new StringBuilder();
        Set<String> visited = new HashSet<>();
        String current = source;

        while (current != null && !visited.contains(current)) {
            if (result.length() > 0) {
                result.append(" -> ");
            }
            result.append(current);
            visited.add(current);
            current = graph.get(current);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        List<String[]> paths1 = Arrays.asList(
            new String[]{"London", "New York"},
            new String[]{"New York", "Lima"},
            new String[]{"Lima", "Sao Paulo"}
        );
        System.out.println(findPath(paths1));  // Output: London -> New York -> Lima -> Sao Paulo

        List<String[]> paths2 = Arrays.asList(
            new String[]{"B", "C"},
            new String[]{"D", "B"},
            new String[]{"C", "A"},
            new String[]{"C", "B"}
        );
        System.out.println(findPath(paths2));  // Output: D -> B -> C -> A

       
    }
}
