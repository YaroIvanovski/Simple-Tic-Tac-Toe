package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cells: ");
        char[] input = sc.nextLine().toCharArray();
        char[][] x = new char[3][3];
        int count = 0;

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                x[i][j] = input[count++];
                System.out.print(x[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}