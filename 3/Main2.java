import java.util.Scanner;

public class Main2 {
	public static String Perevodchik(int x, int k) {
		String ans = "";
		if (x == 0) {
			return "0";
		}
		while (x > 0) {
			ans = (x % k) + ans;
			x = x / k;
		}
		return ans;
	}
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int x = scanner.nextInt();
	int k = scanner.nextInt();
	System.out.println("From 10 to " + k + " => " + Perevodchik(x, k));
	}
}