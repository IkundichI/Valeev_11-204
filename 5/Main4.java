import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the rank of the matrix - ");
        int k = in.nextInt();
        int [][] a = new int[k][k];
        int s = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print("Enter a" + i + "," + j + " - ");
                a[i][j] = in.nextInt();
                if (i == j) {
                    s += a[i][j];
                }
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Is the sum of the numbers of the main diagonal even? - " + ((s % 2 == 0) ? true : false));

    }
}