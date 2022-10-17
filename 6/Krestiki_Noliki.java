// Данный код был написан 2-мя рукожопама: Валеев Артём и Антонов Кирилл
import java.util.Scanner;

public class Krestiki_Noliki {
    public static final int K = 3;
    public static char[][] matrix = new char[K][K];
    public static final char XOD_X = 'X'; // Маркер игрока №1.
    public static final char XOD_Y = 'O'; // Маркер игрока №2.

    public static void printMatrix() {
        System.out.println();
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void xod(int iMatrix, int jMatrix, boolean whoIgraet) { // true - игрок X, false - игрок Y
        if (whoIgraet) {
            matrix[iMatrix][jMatrix] = XOD_X;
        }
        else {
            matrix[iMatrix][jMatrix] = XOD_Y;
        }
        printMatrix();
    }
    public static void startMatrix() {
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                matrix[i][j] = '_';
            }
        }
    }
    public static boolean whoViigral(char a){
        boolean flag = true;
        for (int i = 0; i < K; i++) {
            flag = true;
            for (int j = 0; j < K; j++) {
                if (matrix[i][j] != a){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return true;
            }
        } // По столбцам
        for (int i = 0; i < K; i++) {
            flag = true;
            for (int j = 0; j < K; j++) {
                if (matrix[j][i] != a){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return true;
            }
        } // По Строкам
        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[2][2] == a) {
            return true;
        }
        if (matrix[2][0] == matrix[1][1] && matrix[1][1] == matrix[0][2] && matrix[0][2] == a) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в крестики нолики. Надеюсь вам понравиться.");
        System.out.println("Сначала вводиться координаты столбца, потом строки. Все координаты вводятся по правилам Марата Мирзаевича.");
        System.out.println("(Первый элемент имеет координаты {1, 1} и т.д. )");
        Scanner in = new Scanner(System.in);
        startMatrix();
        printMatrix();
        int iMatrix = 0;
        int p = 0;
        int jMatrix = 0;
        boolean whoIgraet = true;
        System.out.println(" ");
        while (true) {
            System.out.print("Сейчас ходит игрок X: ");
            whoIgraet = true;
            iMatrix = in.nextInt() - 1;
            jMatrix = in.nextInt() - 1;
            xod(iMatrix, jMatrix, whoIgraet);
            System.out.println(" ");
            p += 1;
            if (p == 9) {
                System.out.println("Никто не выйграл.");
                System.exit(0);
            }
            if (whoViigral(XOD_X)) {
                System.out.println("Выйграл игрок X. Поздравляем вас.");
                System.exit(0);
            }
            System.out.print("Сейчас ходит игрок 0: ");
            whoIgraet = false;
            iMatrix = in.nextInt() - 1;
            jMatrix = in.nextInt() - 1;
            xod(iMatrix, jMatrix, whoIgraet);
            if (whoViigral(XOD_Y)) {
                System.out.println("Выйграл игрок 0. Поздравляем вас.");
                System.exit(0);
            }
            p += 1;
        }

    }
}