
package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String[][] x = new String[3][3];
        print(input, x);
    }

    static void board(String[][] x) {
        System.out.println("---------");
        System.out.println("| " + x[0][0] + " " + x[0][1] + " " + x[0][2] + " |");
        System.out.println("| " + x[1][0] + " " + x[1][1] + " " + x[1][2] + " |");
        System.out.println("| " + x[2][0] + " " + x[2][1] + " " + x[2][2] + " |");
        System.out.println("---------");
    }

    static void print(String input, String[][] x) {
        int length = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                x[i][j] = String.valueOf(input.toCharArray()[length++]);
            }
        }
        board(x);
    }
}