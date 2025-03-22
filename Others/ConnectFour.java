package Others;
import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = '.';
    private static final char PLAYER1 = 'R';
    private static final char PLAYER2 = 'Y';
    
    private static char[][] board = new char[ROWS][COLS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();
        boolean playerOneTurn = true;
        boolean gameWon = false;

        printBoard();

        while (!gameWon) {
            System.out.print("Player " + (playerOneTurn ? "1 (R)" : "2 (Y)") + ", choose a column (0-6): ");
            int col = scanner.nextInt();

            if (col < 0 || col >= COLS || board[0][col] != EMPTY) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            int row = dropPiece(col, playerOneTurn ? PLAYER1 : PLAYER2);
            printBoard();

            if (checkWin(row, col)) {
                System.out.println("Player " + (playerOneTurn ? "1 (R)" : "2 (Y)") + " wins!");
                gameWon = true;
            }

            playerOneTurn = !playerOneTurn;
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }

    private static int dropPiece(int col, char piece) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == EMPTY) {
                board[i][col] = piece;
                return i;
            }
        }
        return -1; // Should never reach here (column is validated before placing)
    }

    private static boolean checkWin(int row, int col) {
        char piece = board[row][col];
        return checkDirection(row, col, 1, 0, piece) || // Vertical
               checkDirection(row, col, 0, 1, piece) || // Horizontal
               checkDirection(row, col, 1, 1, piece) || // Diagonal \
               checkDirection(row, col, 1, -1, piece);  // Diagonal /
    }

    private static boolean checkDirection(int row, int col, int rowDir, int colDir, char piece) {
        int count = 1;

        // Check one direction
        for (int i = 1; i < 4; i++) {
            int r = row + i * rowDir, c = col + i * colDir;
            if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != piece) break;
            count++;
        }

        // Check opposite direction
        for (int i = 1; i < 4; i++) {
            int r = row - i * rowDir, c = col - i * colDir;
            if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != piece) break;
            count++;
        }

        return count >= 4;
    }
}
