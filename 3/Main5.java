import java.util.Scanner;

public class Main5 {
	public static void Kvadratiki(int x) {
		for (int i = 0; i*i <= x; i++) {
			for (int j = 0; j*j <= x; j++) {
				for (int l = 0; l*l <= x; l++) {
					if ((i*i + j*j + l*l) == x) {
						System.out.println(i + " " + j + " " + l + " || " + i*i + " + " + j*j + " + " + l*l + " = " + (i*i + j*j + l*l));
						return;
					}
				}
			}
		}
		System.out.println("x y z does not exist");
		return;
	}
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int x = scanner.nextInt();
	Kvadratiki(x);

	}
}