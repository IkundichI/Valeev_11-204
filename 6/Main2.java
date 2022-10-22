import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static boolean proverka(String a, String b) {
        if (a.length() < b.length()) {
            return false;
        }
        if (a.length() == b.length()) {
            if (a.equals(b)) {
                return true;
            }
            return false;
        }
        char [] aArray = a.toCharArray();
        char [] bArray = b.toCharArray();
        if (a.length() > b.length()) {
            for (int i = 0; i < b.length(); i++) {
                if (aArray[i] != bArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the length of the array - ");
        int k = in.nextInt();
        String [] array = new String[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Enter " + i + " elemet - ");
            array[i] = in.next();
        }
        System.out.println(Arrays.toString(array));
        boolean biloLi = false;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    if (proverka(array[i], array[j])) {
                        System.out.println("The substring: " + array[j] +  " is the beginning of the string: " + array[i]);
                        biloLi = true;
                    }
                }
            }
        }
        if (biloLi == false) {
            System.out.println("No strings");
        }
    }
}
