package RationalFraction;

public class Main {
    public static void main(String[] args) {
        RationalFraction r1 = new RationalFraction(1, 1000000000);
        RationalFraction r2 = new RationalFraction(1, 1000000001);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1.equals(r2));
    }
}
