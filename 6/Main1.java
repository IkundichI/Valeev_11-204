import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static int[] bubbleSort(int[] array) {
        int temporary;
        int arrayLength = array.length;
        int count = 0;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                count++;
                if (array[i] < array[j]) {
                    temporary = array[i];
                    array[i] = array[j];
                    array[j] = temporary;
                }
            }
        }
        System.out.println("Number of iterations in Bubble Sort - " + count + ": " + Arrays.toString(array));
        return array;
    }
    public static int[] bubbleSortOptimized(int[] array) {
        int temporary;
        int arrayLength = array.length;
        int count = 0;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                count++;
                if (array[i] > array[j]) {
                    temporary = array[i];
                    array[i] = array[j];
                    array[j] = temporary;
                }
            }
        }
        System.out.println("Number of iterations in Oprimized Bubble Sort - " + count + ": " + Arrays.toString(array));
        return array;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the length of the array - ");
        int k = in.nextInt();
        int [] arrayFirst = new int[k];
        int [] arraySecond = new int[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Enter " + (i + 1) + " elemet - ");
            arrayFirst[i] = in.nextInt();
            arraySecond[i] = arrayFirst[i];
        }
        System.out.println(Arrays.toString(arrayFirst));
        bubbleSort(arrayFirst);
        bubbleSortOptimized(arraySecond);
    }
}