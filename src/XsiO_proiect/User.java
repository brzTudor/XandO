package XsiO_proiect;

import java.util.Scanner;

public class User extends Player {

    @Override
    void move(GameBoard gameBoard, Round round) {
        Scanner scanner = new Scanner(System.in);
        boolean selected = false;
        while (!selected) {
            System.out.println("Intordu linia si coloana");
            String line = scanner.nextLine();
            String[] numbersString = line.split(" ");
            try {
                int linie = Integer.parseInt(numbersString[0]);
                int coloana = Integer.parseInt(numbersString[1]);

                Cell cell = Cell.X;
                if (round.equals(Round.O)) {
                    cell = Cell.O;
                }
                boolean moved = gameBoard.playerMove(linie, coloana, cell);
                if (moved) {
                    selected = true;
                } else {
                    System.out.println("Inputul nu este valid");
                }
            } catch (ClassCastException e) {
                System.out.println("Ar trebui sa introduci numere din intervalul [1,3]");
            }
        }
    }
}