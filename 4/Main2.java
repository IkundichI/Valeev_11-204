import java.util.Scanner;

public class Main2 {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the line: ");
        String strochechka = in.nextLine();
        char [] array = strochechka.toCharArray();
        char [] arrayReverse = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayReverse[i] = array[(array.length - 1) - i];
        }
        System.out.print("Your line is inverted: ");
        System.out.println(String.valueOf(arrayReverse));
    }
}