
package tictactoe;
import java.util.Scanner;
public class Main {
    static boolean finished = true;
    static boolean winX = false;
    static boolean winO = false;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String[][] x = new String[3][3];
        start(input, x);
        win(x);
        result(x);
    }

    static void board(String[][] x) {
        System.out.println("---------");
        System.out.println("| " + x[0][0] + " " + x[0][1] + " " + x[0][2] + " |");
        System.out.println("| " + x[1][0] + " " + x[1][1] + " " + x[1][2] + " |");
        System.out.println("| " + x[2][0] + " " + x[2][1] + " " + x[2][2] + " |");
        System.out.println("---------");
    }

    static void start(String input, String[][] x) {
        int length = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                x[i][j] = String.valueOf(input.toCharArray()[length++]);
                if (x[i][j].contains("_")) {
                    finished = false;
                }
            }
        }
        board(x);
    }

    static int counterX(String[][] x) {
        int countX = 0;
        for (String[] strings : x) {
            for (int j = 0; j < x.length; j++) {
                if (strings[j].equals("X")) {
                    countX++;
                }
            }
        }
        return countX;
    }

    static int counterO(String[][] x) {
        int countO = 0;
        for (String[] strings : x) {
            for (int j = 0; j < x.length; j++) {
                if (strings[j].equals("O")) {
                    countO++;
                }
            }
        }
        return countO;
    }

    static void win(String[][] x) {
        for (int i = 0; i < 3; i++) {
            count++;
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

    static void result(String[][] x) {
        boolean impossible = (winX && winO && count == 3) || (counterX(x) - counterO(x) > 1 || counterO(x) - counterX(x) > 1);
        boolean notFinished = !finished && !winX && !winO && count == 3;
        if (count == 3) {
            if (impossible) {
                System.out.println("Impossible");
            } else if (notFinished) {
                System.out.println("Game not finished");
            } else if (winX) {
                System.out.println("X wins");
            } else if (winO) {
                System.out.println("O wins");
            } else {
                System.out.println("Draw");
            }
        }
    }
}