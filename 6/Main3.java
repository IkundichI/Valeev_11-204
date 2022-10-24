import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static int[] sortirVibor(int[] a) {
        int m = 0;
        int h = 0;
        for (int i = 0; i < a.length - 1; i++) {
            m = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[m]) {
                    m = j;
                }
            }
            h = a[i];
            a[i] = a[m];
            a[m] = h;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the length of the array - ");
        int k = in.nextInt();
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Enter " + i + " elemet - ");
            array[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(array));
        sortirVibor(array);
        String [] arrayStr = new String[k + 1];
        for (int i = 0; i < arrayStr.length; i++) {
            arrayStr[i] = "";
        }
        int count = 1;
        for (int i = 0; i < k - 1; i++) {
            if (array[i] == array[i + 1]) {
                count += 1;
            }
            else {
                arrayStr[count] += ("" + array[i] + " ");
                count = 1;
            }
        }
        if (k != 1) {
            if (array[k - 1] == array[k - 2]) {
                arrayStr[count] += ("" + array[k - 2] + " ");
            }
            if (array[k - 1] != array[k - 2]) {
                arrayStr[1] += ("" + array[k - 1] + " ");
            }
            for (int i = 0; i < arrayStr.length; i++) {
                if (arrayStr[i] != "") {
                    System.out.println(i + " time: " + arrayStr[i]);
                }
            }
        }
        if (k == 1) {
            System.out.println( "1 time: " + array[0]);
        }
    }
}