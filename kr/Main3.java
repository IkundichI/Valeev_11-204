import java.util.*;

public class Main3 {
	public static int factor(int x) {
		int s = 1;
		for (int i = 1; i <= x; i++) {
			s = s * i;
		}
		return s;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double n = in.nextInt();
		double x = in.nextInt();
		double s = 0;
		for (int k = 1; k <= n; k++) {
			s = s + (Math.pow(-1, k)*((Math.pow(x, 2*k + 1)) / (factor(k) + x)));
		}
		System.out.println(s);
	}
}