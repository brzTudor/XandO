package XsiO_proiect;

public class GameBoard {
    public Cell[][] board = new Cell[3][3];

    public void init() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Cell.EMPTY;
            }
        }
    }

    public void print() {
        System.out.println("-----");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(Cell.X)) {
                    System.out.print("X");
                } else if (board[i][j].equals(Cell.O)) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("-----");
    }

    public boolean playerMove(int line, int col, Cell cell) {
        if (!checkLineAndCol(line, col)) {
            return false;
        }
        board[line - 1][col - 1] = cell;

        return true;
    }

    private boolean checkLineAndCol(int line, int col) {
        if (line < 1 || col < 1 || line > 3 || col > 3) {
            return false;
        }
        return board[line - 1][col - 1].equals(Cell.EMPTY);
    }

    public GameState getGameState() {
        if (isWin(Cell.X)) {
            return GameState.X_WIN;
        }
        if (isWin(Cell.O)) {
            return GameState.O_WIN;
        }
        if (hasEmptyCells()) {
            return GameState.NOT_FINISHED;
        }
        return GameState.DRAW;
    }

    public boolean isWin(Cell player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == player) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[2][j] == player) {
                return true;
            }
        }

        return board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == player
                || board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] == player;
    }

    public boolean hasEmptyCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(Cell.EMPTY)) {
                    return true;
                }
            }
        }

        return false;
    }
}
