import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double x = in.nextInt();
		double y = in.nextInt();
		if (x == -(4/y)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}
}