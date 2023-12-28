import java.util.Scanner;

public class XOGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = new char[3][3];
        char player = 'X';
        boolean gameFinished = false;

        // Initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        // Main game loop
        while (!gameFinished) {
            // Print the current state of the board
            System.out.println("Current board:");
            printBoard(board);

            // Prompt the player for their move
            System.out.println("Player " + player + ", enter your move (row column):");
            int row = input.nextInt();
            int col = input.nextInt();

            // Check if the move is valid
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            // Update the board with the player's move
            board[row][col] = player;

            // Check if the game is over
            if (checkWin(board, player)) {
                System.out.println("Player " + player + " wins!");
                gameFinished = true;
            } else if (checkDraw(board)) {
                System.out.println("Draw!");
                gameFinished = true;
            }

            // Switch to the other player
            player = (player == 'X') ? 'O' : 'X';
        }
    }

    // Print the current state of the board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-+-+-");
            }
        }
    }

    // Check if the given player has won the game
    public static boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        // Player has not won
        return false;
    }

    // Check if the game is a draw
    public static boolean checkDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
