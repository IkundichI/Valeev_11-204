import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static int[] bubleSort(int[] array) {
        int temporary;
        int arrayLength = array.length;
        int count = 0;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 1; j < (arrayLength - i); j++) {
                if (array[j - 1] > array[j]) {
                    temporary = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temporary;
                }
                count++;
            }
        }
        System.out.println("Number of iterations in Bubble Sort - " + count);
        return array;
    }
    public static int[] bubleSortOpti(int[] array) {
        boolean biloLi;
        int count = 0;
        int temporary;
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            biloLi = false;
            for (int j = 1; j < (arrayLength - i); j++) {
                if (array[j - 1] > array[j]) {
                    temporary = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temporary;
                    biloLi = true;
                }
                count++;
            }
            if (biloLi == false) {
                break;
            }
        }
        System.out.println("Number of iterations in Oprimized Bubble Sort - " + count);
        return array;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the length of the array - ");
        int k = in.nextInt();
        int [] arrayFirst = new int[k];
        int [] arraySecond = new int[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Enter " + i + " elemet - ");
            arrayFirst[i] = in.nextInt();
            arraySecond[i] = arrayFirst[i];
        }
        System.out.println(Arrays.toString(arrayFirst));
        System.out.println(Arrays.toString(bubleSort(arrayFirst)));
        System.out.println(Arrays.toString(bubleSortOpti(arraySecond)));
    }
}