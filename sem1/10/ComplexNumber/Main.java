package ComplexNumber;

public class Main {
    public static void main(String[] args) {
        ComplexNumber s1 = new ComplexNumber(0, -3);
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " => " + s1.pow(i) + ", argument => " + s1.arg());
        }






    }
}
