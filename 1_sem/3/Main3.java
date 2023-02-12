import java.util.Scanner;

public class Main3 {
	public static String NumberOfUnits(int x, int k) {
		String ans = "";
		int count = 0;
		while (x > 0) {
			count = (x % k == 1) ? (count + 1) : (count);
			x /= k;
		}
		return (count > 3) ? ("count more than 3") : ("count less than 3");
	}
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int x = scanner.nextInt();
	int k = scanner.nextInt();
	System.out.println(NumberOfUnits(x, k));
	}
}