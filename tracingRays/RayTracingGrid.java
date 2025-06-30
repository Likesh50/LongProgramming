import java.util.*;



//https://chatgpt.com/share/684704b4-86ac-800a-ae4d-fd1b9fe43f0e


public class RayTracingGrid {
    static int N;
    static char[][] grid;
    static Set<String> atoms = new HashSet<>();

    static class Point {
        int r, c;
        Point(int r, int c) { this.r = r; this.c = c; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix size
        System.out.print("Enter matrix size (N): ");
        N = sc.nextInt();
        grid = new char[N][N];

        // Initialize grid
        for (char[] row : grid)
            Arrays.fill(row, '-');

        // Input atoms
        System.out.print("Enter number of atoms: ");
        int A = sc.nextInt();
        System.out.println("Enter atom positions (row col):");
        for (int i = 0; i < A; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            grid[r - 1][c - 1] = 'x';
            atoms.add((r - 1) + "," + (c - 1));
        }

        // Input rays
        System.out.print("Enter number of rays: ");
        int R = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter ray entries (e.g., R1, C3):");
        for (int i = 0; i < R; i++) {
            String entry = sc.nextLine().trim();
            traceRay(entry);
        }

        // Output result
        System.out.println("\nFinal Grid:");
        for (int r = N - 1; r >= 0; r--) {
            for (int c = 0; c < N; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    static void traceRay(String entry) {
        Point start = null;
        int dr = 0, dc = 0;

        char side = entry.charAt(0);
        int index = Integer.parseInt(entry.substring(1)) - 1;

        switch (side) {
            case 'R': // Left side
                start = new Point(index, 0);
                dr = 0; dc = 1;
                break;
            case 'L': // Right side
                start = new Point(index, N - 1);
                dr = 0; dc = -1;
                break;
            case 'T': // Bottom side
                start = new Point(0, index);
                dr = 1; dc = 0;
                break;
            case 'B': // Top side
                start = new Point(N - 1, index);
                dr = -1; dc = 0;
                break;
        }

        simulate(start.r, start.c, dr, dc, side);
    }

    static void simulate(int r, int c, int dr, int dc, char entrySide) {
        int entryR = r, entryC = c;

        while (r >= 0 && r < N && c >= 0 && c < N) {
            // Hit directly
            if (grid[r][c] == 'x') {
                grid[r][c] = 'H';
                return;
            }

            // Check diagonals
            boolean leftDiag = atoms.contains((r + dr) + "," + (c + dc - 1));
            boolean rightDiag = atoms.contains((r + dr) + "," + (c + dc + 1));

            if (leftDiag && rightDiag) {
                // Reflection
                grid[entryR][entryC] = 'R';
                return;
            } else if (leftDiag || rightDiag) {
                // Refraction (split)
                grid[r][c] = 'R';
                if (leftDiag) {
                    simulate(r + dr, c + dc - 1, dr, dc, entrySide);
                }
                if (rightDiag) {
                    simulate(r + dr, c + dc + 1, dr, dc, entrySide);
                }
                r += dr;
                c += dc;
            } else {
                // Normal move
                grid[r][c] = 'R';
                r += dr;
                c += dc;
            }
        }
        
    }
}