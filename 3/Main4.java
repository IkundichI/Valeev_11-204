import java.util.Scanner;

public class Main4 {
	public static boolean Simple(int x) {
		if (x == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(x + 1); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int a = scanner.nextInt();
	int b = scanner.nextInt();
	System.out.print("In the range from " + a + " to " + b + ": ");
	for (int i = a; i <= b; i++) {
		if (Simple(i)) {
			System.out.print(i + " ");
		}
	}
	System.out.println();
	

	}
}