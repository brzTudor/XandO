package XsiO_proiect;

import java.util.Scanner;

public class Game {
    private final GameBoard gameBoard = new GameBoard();
    private Round round = Round.X;
    private Player player1;
    private Player player2;

    private void getInfo() {
        Scanner scanner = new Scanner(System.in);
        String line;

        boolean nrPlayersSelected = false;
        while (!nrPlayersSelected) {
            System.out.println("Introdu numărul de jucători: 1 sau 2. Dacă selectezi 1, vei juca cu calculatorul, dacă selectezi 2, este nevoie de doi jucători");
            line = scanner.nextLine();
            try {
                int nr = Integer.parseInt(line);
                if (nr == 1) {
                    nrPlayersSelected = true;
                    setPlayers(1);
                } else if (nr == 2) {
                    nrPlayersSelected = true;
                    setPlayers(2);
                } else {
                    System.out.println("Numarul nu este valid");
                }
            } catch (ClassCastException e) {
                System.out.println("Introdu un numar valid");
            }
        }
    }

    private void setPlayers(int nrPlayers) {
        player1 = new User();
        if (nrPlayers == 1) { // Jucator si Calculator
            player2 = new Computer();
        } else { // 2 Jucatori
            player2 = new User();
        }
    }

    private void changeRound() {
        if (round.equals(Round.X)) {
            round = Round.O;
        } else {
            round = Round.X;
        }
    }

    public void start() {
        gameBoard.init();
        getInfo();
        while (true) {
            player1.move(gameBoard, round);
            changeRound();
            gameBoard.print();
            boolean finished = gameFinished();
            if (finished) {
                break;
            }

            player2.move(gameBoard, round);
            changeRound();
            gameBoard.print();
            finished = gameFinished();
            if (finished) {
                break;
            }
        }

        System.out.println("Jocul s-a terminat");
    }

    private boolean gameFinished() {
        GameState gameState = gameBoard.getGameState();
        if (gameState.equals(GameState.X_WIN)) {
            System.out.println("X a castigat");
            return true;
        } else if (gameState.equals(GameState.O_WIN)) {
            System.out.println("O a castigat");
            return true;
        } else if (gameState.equals(GameState.DRAW)) {
            System.out.println("Remiza");
            return true;
        }

        return false;
    }
}
