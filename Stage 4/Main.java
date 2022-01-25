package tictactoe;
import java.util.Scanner;
public class Main {
    static int first;
    static int second;
    static String[][] x = new String[3][3];
    static  Scanner sc = new Scanner(System.in);

    static void board(String[][] x) {
        System.out.println("---------");
        System.out.println("| " + x[0][0] + " " + x[0][1] + " " + x[0][2] + " |");
        System.out.println("| " + x[1][0] + " " + x[1][1] + " " + x[1][2] + " |");
        System.out.println("| " + x[2][0] + " " + x[2][1] + " " + x[2][2] + " |");
        System.out.println("---------");
    }

    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        String input = sc.nextLine();
        counters(input, x);
        board(x);
        check();
    }
    static void counters(String input, String[][] x) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                x[i][j] = String.valueOf(input.charAt(i * 3 + j));
            }
        }
    }

    static void check() {
        while (true) {
            System.out.println("Enter the coordinates: ");
            try {
                first = sc.nextInt();
                second = sc.nextInt();
                if (first < 1 || first > 3 || second < 1 || second > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (!x[first - 1][second - 1].equals("_")) {
                        System.out.println("This cell is occupied! Try another one!");
                    } else {
                        x[first - 1][second - 1] = "X";
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
        board(x);
    }
}