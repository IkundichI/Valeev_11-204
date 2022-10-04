import java.util.Scanner;
public class Main4 {
    public static boolean proverkaProgres (int a[]) {
       int d = (a[0] - a[1]);
       for (int i = 0; i < (a.length - 1); i++) {
           if ((a[i] - a[i + 1]) != d) {
               return false;
           }
       }
       return true;
    }
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of array elements - ");
        int arrayLength = in.nextInt();
        int [] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter " + i + " element - ");
            array[i] = in.nextInt();
        }
        System.out.println("Are the array elements an arithmetic progression? - " + proverkaProgres(array));
    }
}