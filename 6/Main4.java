import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the dimension of the square matrix - ");
        int k = in.nextInt();
        int [][] matrix = new int[k][k];
        System.out.print("Enter the color of your zone - ");
        String whatArey = in.next();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print("Enter " + i + "," + j + " elemet - ");
                matrix[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        int count = 0;
        double s = 0;
        switch (whatArey) {

            case "green":
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        if (i < j && j < k/2 && i + j < k - 1 && i < k/2) {
                            count += 1;
                            s += matrix[i][j];
                        }
                    }
                }
                System.out.println("Arithmetic mean of the zone - " + s/count);
                break;

            case "red":
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        if (i > j && i + j > k - 1 && j < k/2 && i > k/2) {
                            count += 1;
                            s += matrix[i][j];
                        }
                    }
                }
                System.out.println("Arithmetic mean of the zone - " + s/count);
                break;

            case "yellow":
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        if (i < j && i + j > k - 1 && j > k/2 && i < k/2) {
                            count += 1;
                            s += matrix[i][j];
                        }
                    }
                }
                System.out.println("Arithmetic mean of the zone - " + s/count);
                break;

            default:
                System.out.println("You have entered the wrong zone name, please try again later...");
                break;

        }
    }
}
