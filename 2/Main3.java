import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	int x = scanner.nextInt(); 
	long factorial = 1; // Нормально работает только до 25, далее идёт перегруз
	
	if (x >= 0) {
		if (x > 1) {
			for (int i = 2; i <= x; i++) {
				factorial = factorial * i;
			}
		}
		System.out.println(factorial);
	}

	else {
		System.out.println("Error");
	}

	}
}