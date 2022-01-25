
package tictactoe;
import java.util.*;

public class Main {
    static String[][] x = new String[3][3];
    static boolean winX, winO = false;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                x[i][j] = " ";
            }
        }
        board(x);
        check(x);
    }

    static void board(String[][] x) {
        System.out.println("---------");
        System.out.println("| " + x[0][0] + " " + x[0][1] + " " + x[0][2] + " |");
        System.out.println("| " + x[1][0] + " " + x[1][1] + " " + x[1][2] + " |");
        System.out.println("| " + x[2][0] + " " + x[2][1] + " " + x[2][2] + " |");
        System.out.println("---------");
    }

    static void check(String[][] x) {
        int count = 0, count2 = 0;
        while (true) {
            try {
                System.out.println("Enter the coordinates: ");
                Scanner sc = new Scanner(System.in);
                int first = sc.nextInt(), second = sc.nextInt();

                if (first < 1 || first > 3 || second < 1 || second > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (!x[first - 1][second - 1].equals(" ")) {
                    System.out.println("This cell is occupied! Try another one!");
                } else {
                    count++;
                    if (count2 == 0) {
                        x[first - 1][second - 1] = "X";
                        count2++;
                    } else if (count2 == 1) {
                        x[first - 1][second - 1] = "O";
                        count2--;
                    }
                    board(x); win(x);

                    if (count == 9 && !winX && !winO) {
                        System.out.println("Draw");
                        break;
                    } else if (winX && !winO) {
                        System.out.println("X wins");
                        break;
                    } else if (!winX && winO) {
                        System.out.println("O wins");
                        break;
                    }
                }
           } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    static void win(String[][] x) {
        for (int i = 0; i < 3; i++) {
            if (x[i][0].equals("X") && x[i][1].equals("X") && x[i][2].equals("X")) {
                winX = true;
            } else if (x[i][0].equals("O") && x[i][1].equals("O") && x[i][2].equals("O")) {
                winO = true;
            } else if (x[0][i].equals("X") && x[1][i].equals("X") && x[2][i].equals("X")) {
                winX = true;
            } else if (x[0][i].equals("O") && x[1][i].equals("O") && x[2][i].equals("O")) {
                winO = true;
            } else if (x[0][0].equals("X")&& x[1][1].equals("X") && x[2][2].equals("X")) {
                winX = true;
            } else if (x[0][0].equals("O") && x[1][1].equals("O") && x[2][2].equals("O")) {
                winO = true;
            } else if (x[2][0].equals("X") && x[1][1].equals("X") && x[0][2].equals("X")) {
                winX = true;
            } else if (x[2][0].equals("O") && x[1][1].equals("O") && x[0][2].equals("O")) {
                winO = true;
            }
        }
    }
}