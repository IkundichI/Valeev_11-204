import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the rank of the matrix - ");
        int k = in.nextInt();
        int s = 0;
        int [][] a = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print("Enter a" + i + "," + j + " - ");
                a[i][j] = in.nextInt();
                s += a[i][j];
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Sum of elements - " + s);
    }
}