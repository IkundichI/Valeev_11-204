import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int x10 = scanner.nextInt();
		String x2 = "";
		int max = 0;
		int count = 0;

		while (x10 > 0) {
			x2 = (x10 % 2 == 1)? ("1" + x2) : ("0" + x2); 

			if (x10 % 2 == 1) {
				count++;
			} 
			else {
				max = (max < count)? (count) : (max);
				count = 0;
			}

			x10 = x10 / 2;
		}

		System.out.println("In Binary -> " + x2);
		System.out.println("Number of '1' in a row -> " + max);

	}
}