package dunguonGame;

import java.util.*;
class DungeonGame {

    static class Point {
        int x, y, hasTrigger;

        Point(int x, int y, int hasTrigger) {
            this.x = x;
            this.y = y;
            this.hasTrigger = hasTrigger; // 0 or 1
        }
    }

    static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static char[][] grid;
    static boolean[][][] visited;

    static int rows, cols;

    static Point start, treasure, monster, trigger;
    static Set<String> pits = new HashSet<>();

    public static void main(String[] args) {
        // Sample grid 7x7
        rows = 7;
        cols = 7;
        grid = new char[rows][cols];

        for (char[] row : grid)
            Arrays.fill(row, '.');

        // Position setup
        start = new Point(0, 0, 0);
        treasure = new Point(6, 6, 0);
        monster = new Point(3, 3, 0);
        trigger = new Point(1, 5, 0);

        // Pits
        pits.add("2,2");
        pits.add("5,5");

        grid[start.x][start.y] = 'A';
        grid[treasure.x][treasure.y] = 'T';
        grid[monster.x][monster.y] = 'M';
        grid[trigger.x][trigger.y] = 'R';
        for (String pit : pits) {
            String[] parts = pit.split(",");
            grid[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])] = 'P';
        }

        visited = new boolean[rows][cols][2];

        boolean found = bfs();
        if (!found) {
            System.out.println("No valid path to treasure found.");
        }
    }

    public static boolean bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][0] = true;

        Map<String, String> parent = new HashMap<>();

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (curr.x == treasure.x && curr.y == treasure.y) {
                printPath(parent, curr);
                return true;
            }

            for (int[] dir : directions) {
                int nx = curr.x + dir[0];
                int ny = curr.y + dir[1];
                int hasTrigger = curr.hasTrigger;

                if (isValid(nx, ny)) {
                    char cell = grid[nx][ny];

                    if (cell == 'P') continue; // Pit: skip
                    if (cell == 'M' && hasTrigger == 0) continue; // Monster: avoid unless armed
                    if (cell == 'R') hasTrigger = 1; // Trigger picked

                    if (!visited[nx][ny][hasTrigger]) {
                        visited[nx][ny][hasTrigger] = true;
                        queue.add(new Point(nx, ny, hasTrigger));
                        parent.put(nx + "," + ny + "," + hasTrigger, curr.x + "," + curr.y + "," + curr.hasTrigger);
                    }
                }
            }
        }

        return false;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    public static void printPath(Map<String, String> parent, Point end) {
        List<Point> path = new ArrayList<>();
        String key = end.x + "," + end.y + "," + end.hasTrigger;

        while (parent.containsKey(key)) {
            String[] parts = key.split(",");
            path.add(new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            key = parent.get(key);
        }

        Collections.reverse(path);
        char[][] temp = new char[rows][cols];
        for (int i = 0; i < rows; i++) temp[i] = grid[i].clone();

        for (Point p : path) {
            if (temp[p.x][p.y] == '.' || temp[p.x][p.y] == 'R') {
                temp[p.x][p.y] = '*';
            }
            printMaze(temp);
        }

        System.out.println("Treasure reached!");
    }

    public static void printMaze(char[][] board) {
        System.out.println("Step:");
        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
        System.out.println("-----------------");
    }
}
