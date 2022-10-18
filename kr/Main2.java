import java.util.*;

public class Main2 {
	public static boolean proverylkin(int x) {
		boolean ans = true;
		while (x != 0) {
			if (x % 10 != 0 || x % 10 != 2 || x % 10 != 4 || x % 10 != 6 || x % 10 != 8) {
				ans = false;
			}
			x = x / 10;
		}
		if (ans) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = in.nextInt();
		}
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			if (proverylkin(array[i])) {
				System.out.println("true");
				break;
			}
		}

	}
}