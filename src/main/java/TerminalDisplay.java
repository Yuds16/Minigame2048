import Minigame2048.Minigame2048;

import java.util.Scanner;

public class TerminalDisplay {
    private Minigame2048 minigame;

    public TerminalDisplay(Minigame2048 minigame) {
        this.minigame = minigame;
    }

    private void display() {
        int[][] board = this.minigame.getBoard();
        for (int[] i : board) {
            System.out.println("-".repeat(this.minigame.getSize() * 2 + 1));
            for (int j : i) {
                if (j == 0) {
                    System.out.print("| ");
                } else {
                    System.out.print("|" + j);
                }
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(this.minigame.getSize() * 2 + 1));
    }

    public void run() {
        System.out.println("U/D/L/R/EXIT");
        display();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("U")) {
                this.minigame.moveUp();
            } else if (command.equalsIgnoreCase("D")) {
                this.minigame.moveDown();
            } else if (command.equalsIgnoreCase("L")) {
                this.minigame.moveLeft();
            } else if (command.equalsIgnoreCase("R")) {
                this.minigame.moveRight();
            } else if (command.equalsIgnoreCase("EXIT")) {
                System.exit(0);
            }
            display();
        }
    }

    public static void main(String[] args) {
        Minigame2048 minigame = new Minigame2048();
        TerminalDisplay terminalDisplay = new TerminalDisplay(minigame);
        terminalDisplay.run();
    }
}
