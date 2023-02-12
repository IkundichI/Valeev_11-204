import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the rank of the matrix - ");
        int k = in.nextInt();
        int count = 0;
        double s = 0;
        int [][] a = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print("Enter a" + i + "," + j + " - ");
                a[i][j] = in.nextInt();
                if (i % 2 == 0 && j % 2 != 0) {
                    s += a[i][j];
                    count++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        if (count > 0) {
            System.out.println("Arithmetic mean of elements on even rows and odd columns - " + (s / count));
        }
        else {
            System.out.println("No element");
        }

    }
}