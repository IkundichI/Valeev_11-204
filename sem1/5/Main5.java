import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static int [] sortik (int array []) {
        int a = 0;
        for (int l = 0; l < array.length; l++) {
            int min = l;
            for (int j = l; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            a = array[l];
            array[l] = array[min];
            array[min] = a;

        }
        return array;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the length of the array - ");
        int len = in.nextInt();
        int [] array = new int [len];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter a number - ");
            array[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sortik(array)));
    }
}