import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		String Dvik = "";
		int jaba = 0;
		int xran = 0;
		while (x > 0) {
			if (x % 2 == 1) {
				x = x / 2;
				Dvik = "1" + Dvik;
				jaba += 1;
				if (xran < jaba) {
					xran = jaba;
				}

			} else {
				x = x / 2;
				Dvik = "0" + Dvik;
				jaba = 0;
			}

		}
		System.out.println(xran);
		System.out.println(Dvik);
	}
}