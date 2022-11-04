package Matrix;

import java.util.Arrays;

public class Matrix {
    private int[][] innerMatrix;
    public Matrix(int len) {
        innerMatrix = new int[len][len];
    }
    public int getElement(int i, int j) {
        return innerMatrix[i][j];
    }
    public void setElement(int i, int j, int value) {
        innerMatrix[i][j] = value;
    }
    public int getMatrixSize() {
        return innerMatrix.length;
    }

    public void printMatrix() {
        for (int i = 0; i < innerMatrix.length; i++) {
            System.out.println(Arrays.toString(innerMatrix[i]));
        }
    }
    public static Matrix summOfMatrix(Matrix matrix1, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix1.getMatrixSize());
        if (matrix1.getMatrixSize() != matrix2.getMatrixSize()) {
            throw new RuntimeException("error");
        }
        else {
            for (int i = 0; i < matrix1.getMatrixSize(); i++) {
                for (int j = 0; j < matrix1.getMatrixSize(); j++) {
                    matrix3.setElement(i, j, matrix1.getElement(i, j) + matrix2.getElement(i, j));
                }
            }
        }
        return matrix3;
    }
    public int[] getGlDiag() {
        int[] array = new int[innerMatrix.length];
        for (int i = 0; i < innerMatrix.length; i++) {
            array[i] = innerMatrix[i][i];
        }
        return array;
    }
    public int[] getPobochDiag() {
        int[] array = new int[innerMatrix.length];
        for (int i = 0; i < innerMatrix.length; i++) {
            for (int j = 0; j < innerMatrix.length; j++) {
                if (i + j == innerMatrix.length - 1) {
                    array[i] = innerMatrix[i][j];
                }
            }
        }
        return array;
    }

    public int opredelitelOfMatrix() {
        if (innerMatrix.length != 3) {
            throw new RuntimeException("error");
        }
        else {
            return (innerMatrix[0][0]*innerMatrix[1][1]*innerMatrix[2][2] + innerMatrix[1][0]*innerMatrix[2][1]*innerMatrix[0][2] + innerMatrix[0][1]*innerMatrix[1][2]*innerMatrix[2][0] - innerMatrix[0][2]*innerMatrix[1][1]*innerMatrix[2][0] - innerMatrix[1][0]*innerMatrix[0][1]*innerMatrix[2][2] - innerMatrix[0][0]*innerMatrix[2][1]*innerMatrix[1][2]);

        }
    }

    public int sumOfMatrix() {
        int summ = 0;
        for (int i = 0; i < innerMatrix.length; i++) {
            for (int j = 0; j < innerMatrix.length; j++) {
                summ += innerMatrix[i][j];
            }
        }
        return summ;
    }
}