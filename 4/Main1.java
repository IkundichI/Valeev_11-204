import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static int summOfElement(int a[]) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                s += a[i];
            }
        }
        return s;
    }
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int sLength = in.nextInt();
        int [] array = new int[sLength];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter " + i + " element: ");
            array[i] = in.nextInt();
        }
        System.out.println("The entered array | " + Arrays.toString(array));
        System.out.println("Sum of odd elements: " + summOfElement(array));

    }
}