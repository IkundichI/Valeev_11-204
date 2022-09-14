import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x10 = scanner.nextInt();
		String x2 = "";


		while (x10 > 0) 
		{
			x2 = (x10 % 2 == 1)? ("1" + x2) : ("0" + x2);
			x10 = x10 / 2;
		}

		int lenx2 = x2.length();

		for (int i = 1; i <= lenx2; i++)
		{
			
		}


		System.out.println(x2);

	}
}