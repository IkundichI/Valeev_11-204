package Matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matrix matrix1 = new Matrix(3);
        for (int i = 0; i < matrix1.getMatrixSize(); i++) {
            for (int j = 0; j < matrix1.getMatrixSize(); j++) {
                matrix1.setElement(i, j, in.nextInt());
            }
        }
        matrix1.printMatrix();
        System.out.println(matrix1.opredelitelOfMatrix());
        System.out.println(matrix1.sumOfMatrix());
    }

}