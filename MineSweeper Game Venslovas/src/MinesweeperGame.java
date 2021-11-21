public class MinesweeperGame {
    private int rows;
    private int columns;
    private int mines;
    private int board[][];
    private int visibleBoard[][];

    public MinesweeperGame(int inputRows, int inputColumns, int inputMines) {
        rows = inputRows;
        columns = inputColumns;
        mines = inputMines;
        visibleBoard = new int[rows][columns];
        visibleBoard();
        board = this.createBoard();
        board = populateBoard(board);
    }

    public int playerInteract(int inputRow, int inputColumn) {
        if (board[inputRow][inputColumn] == 9) {
            return 2;
        }
        else {
            visibleBoard[inputRow][inputColumn] = board[inputRow][inputColumn];
        }
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] != 9) {
                    if (visibleBoard[i][j] == board[i][j]) {
                        visibleBoard[i][j] = visibleBoard[i][j];
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public void getVisibleBoard() {
        printBoard(visibleBoard);
    }
    public void getBoard() {
        printBoard(board);
    }

    private int[][] createBoard(){
        int temp[][] = new int[rows][columns];
        return temp;
    }

    private int[][] populateBoard(int inputBoard[][]) {
        while (mines != 0) {
            int a = (int)(Math.random()*rows);
            int b = (int)(Math.random()*columns);
            if (inputBoard[a][b] == 0) {
                inputBoard[a][b] = 9;
                mines -= 1;
            }
        }

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (inputBoard[i][j] != 9) {
                    int tempMines = 0;
                    if ((j - 1) != -1) {  //top
                        if (inputBoard[i][j - 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i - 1) != -1) {  //left
                        if (inputBoard[i - 1][j] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i - 1) != -1 && (j - 1) != -1) {  // top left
                        if (inputBoard[i - 1][j - 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i - 1) != -1 && (j + 1) != columns) {  // top right
                        if (inputBoard[i - 1][j + 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i + 1) != rows) {  //bot
                        if (inputBoard[i + 1][j] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((j + 1) != columns) {  //right
                        if (inputBoard[i][j + 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i + 1) != rows && (j + 1) != columns) { //bot right
                        if (inputBoard[i + 1][j + 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    if ((i + 1) != rows && (j - 1) != -1) { // bot left
                        if (inputBoard[i + 1][j - 1] == 9) {
                            tempMines += 1;
                        }
                    }
                    inputBoard[i][j] = tempMines;
                }
            }
        }
        return (inputBoard);
    }

    private void printBoard(int inputBoard[][]) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(inputBoard[i][j] + "   ");
            }
            System.out.println();
        }
    }

    private void visibleBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                visibleBoard[i][j] = -1;
            }
        }
        printBoard(visibleBoard);
    }

}