import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many rows, columns and mines are in the field");
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int mines = sc.nextInt();
        System.out.println("Empty field is represented by -1, while 9 - mine");
        System.out.println("");
        MinesweeperGame game = new MinesweeperGame(rows, columns, mines);
        System.out.println("");
        System.out.println("Let's get started!");
        while (true) {
            System.out.println("");
            System.out.println("Select your next move: Row | Column ");
            int inputRow = sc.nextInt();
            int inputColumn = sc.nextInt();
            int y = game.playerInteract(inputRow, inputColumn);
            if (y == 2) {
                System.out.println("");
                System.out.println("Game over! You hit the mine. Here was the board:");
                System.out.println("");
                game.getBoard();
                System.exit(0);
            }
            if (y == 1) {
                System.out.println("");
                System.out.println("You won!");
                System.out.println("");
                game.getBoard();
                System.exit(0);
            }
            if (y == 0) {
                System.out.println("");
                System.out.println("What's your next move? Board:");
                System.out.println("");
                game.getVisibleBoard();
                game.getBoard();
            }
        }
    }
}