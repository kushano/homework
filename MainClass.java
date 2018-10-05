package MainPackage;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class MainClass {
    public static void initDisplay (int[][] gameBoard) {
        for (int n = 0; n < 10; n++) {
            System.out.println();
        }

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                if (gameBoard[row][col] == 0) {
                    System.out.print("   ");
                } else if (gameBoard[row][col] == 1) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" O ");
                }
                if (col != 2)
                    System.out.print(" | ");
            }
            System.out.println();
            if (row != 2)
                System.out.print("---------------");
            System.out.println();
        }
    }

    public static boolean ifYouWon (int[][] gameBoard, boolean caseWon) {
        //boolean caseWon = false;

        // СТРОКИ //
        if (gameBoard[0][0] == gameBoard[1][0] && gameBoard[0][0] == gameBoard[2][0] && gameBoard[0][0] != 0) {
            caseWon = true;
        }
        if (gameBoard[0][1] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][1] && gameBoard[0][1] != 0) {
            caseWon = true;
        }
        if (gameBoard[0][2] == gameBoard[1][2] && gameBoard[0][2] == gameBoard[2][2] && gameBoard[0][2] != 0) {
            caseWon = true;
        }

        // СТОЛБЦЫ
        if (gameBoard[0][0] == gameBoard[0][1] && gameBoard[0][0] == gameBoard[0][2] && gameBoard[0][0] != 0) {
            caseWon = true;
        }
        if (gameBoard[1][0] == gameBoard[1][1] && gameBoard[1][0] == gameBoard[1][2] && gameBoard[1][0] != 0) {
            caseWon = true;
        }
        if (gameBoard[2][0] == gameBoard[2][1] && gameBoard[2][0] == gameBoard[2][2] && gameBoard[2][0] != 0) {
            caseWon = true;
        }

        // ДИАГОНАЛИ //

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != 0) {
            caseWon = true;
        }
        if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0] && gameBoard[0][2] != 0) {
            caseWon = true;
        }

        return caseWon;
    }

//    public static void newInitDisplay (int[][] gameBoard) {
//        JFrame mainFrame = new JFrame("Hello there");
//        mainFrame.setSize(600, 600);
//        JPanel contents = new JPanel();
//        contents.setLayout(new GridLayout(3,3));
//
//        JButton button1 = new JButton(" ");
//        JButton button2 = new JButton(" ");
//        JButton button3 = new JButton(" ");
//        JButton button4 = new JButton(" ");
//        JButton button5 = new JButton(" ");
//        JButton button6 = new JButton(" ");
//        JButton button7 = new JButton(" ");
//        JButton button8 = new JButton(" ");
//        JButton button9 = new JButton(" ");
//
//        contents.remove(button1);
//        contents.remove(button2);
//        contents.remove(button3);
//        contents.remove(button4);
//        contents.remove(button5);
//        contents.remove(button6);
//        contents.remove(button7);
//        contents.remove(button8);
//        contents.remove(button9);
//
//        button1.setText("" + gameBoard[0][0]);
//        button2.setText("" + gameBoard[0][1]);
//        button3.setText("" + gameBoard[0][2]);
//        button4.setText("" + gameBoard[1][0]);
//        button5.setText("" + gameBoard[1][1]);
//        button6.setText("" + gameBoard[1][2]);
//        button7.setText("" + gameBoard[2][0]);
//        button8.setText("" + gameBoard[2][1]);
//        button9.setText("" + gameBoard[2][2]);
//
//        contents.add(button1);
//        contents.add(button2);
//        contents.add(button3);
//        contents.add(button4);
//        contents.add(button5);
//        contents.add(button6);
//        contents.add(button7);
//        contents.add(button8);
//        contents.add(button9);
//
//        mainFrame.setContentPane(contents);
//        mainFrame.setVisible(true);
//    }

    public static void main(String[] args) {
        int[][] gameBoard = new int[3][3];
        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[x].length; y++) {
                gameBoard[x][y] = 0;
            }
        }

        int coordX, coordY;

        Scanner input = new Scanner(System.in);
        String playerX = "X", playerO = "O", currentPlayer = playerX;
        boolean whileRight = false;
        boolean caseWon = false;

        while (!caseWon) {
            initDisplay(gameBoard);
            //newInitDisplay(gameBoard);

            System.out.println("Make a move, " + currentPlayer + " (x coordinate + enter; y coordinate + enter)");
            while (whileRight != true) {
                coordX = input.nextInt();
                coordY = input.nextInt();

                if (gameBoard[coordX][coordY] == 2 || gameBoard[coordX][coordY] == 1) {
                    System.out.println("Sorry, retry again");
                } else if (currentPlayer.equals(playerX)) {
                    gameBoard[coordX][coordY] = 1;
                    whileRight = true;
                } else if (currentPlayer.equals(playerO)) {
                    gameBoard[coordX][coordY] = 2;
                    whileRight = true;
                }
            }

            if (currentPlayer.equals(playerX)) {
                currentPlayer = playerO;
            } else {
                currentPlayer = playerX;
            }

            whileRight = false;

            caseWon = ifYouWon(gameBoard, caseWon);
        }
        if (currentPlayer.equals(playerO)) {
            System.out.println("The winner is " + playerX);
        } else {
            System.out.println("The winner is " + playerO);
        }
    }
}
