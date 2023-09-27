//import java.util.*;
//
//public class Main4 {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int k = in.nextInt();
//		int [][] array = new int[k][k];
//		int s = 0;
//		int x = 0;
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array.length; j++) {
//				array[i][j] = in.nextInt();
//				if (i == j || i + j == n - 1 || (i < j && i + j > n - 1) || (j + i && i + j < n -1)) {
//					s += array[i][j];
//					x += 1;
//
//				}
//
//
//			}
//		}
//		if (x != 0) {
//			double ar = s / x;
//			System.out.println(ar)
//		}
//		else {
//			System.out.println("false")
//		}
//
//
//	}
//}