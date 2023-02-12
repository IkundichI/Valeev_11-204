import java.util.Scanner;

public class Main3 {
    public static boolean proverylkin(char[] a) {
        if (65 <= (int)a[0] && (int)a[0] <= 90) {
            return true;
        }
        return false;
    }
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of array elements - ");
        int arrayLength = in.nextInt();
        String array [] = new String[arrayLength];
        Scanner in1 = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + " line - ");
            array[i] = in1.nextLine();
        }
        for (int i = 0; i < array.length; i++ ) {
            if (proverylkin(array[i].toCharArray())) {
                System.out.println(array[i]);
            }
        }
    }
}