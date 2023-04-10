package XsiO_proiect;

import java.util.Random;

public class Computer extends Player {
    @Override
    void move(GameBoard gameBoard, Round round) {
        int[] move = geRandomMove(gameBoard);
        int line = move[0];
        int col = move[1];

        gameBoard.playerMove(line + 1, col + 1, Cell.O);
    }

    private int[] geRandomMove(GameBoard gameBoard) {
        int[][] moves = new int[9][2];
        int emptyCellsNo = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.board[i][j].equals(Cell.EMPTY)) {
                    moves[emptyCellsNo][0] = i;
                    moves[emptyCellsNo++][1] = j;
                }
            }
        }

        Random random = new Random();
        int nr = random.nextInt(emptyCellsNo);

        return new int[]{moves[nr][0], moves[nr][1]};
    }
}
