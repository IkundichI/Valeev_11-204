package First;

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(0, 5, 5, 5, 0, 0, 5, 0);
        Rectangle r2 = new Rectangle(0, 5, 5, 5, 0, 0, 5, 0);
        //Rectangle r2 = new Rectangle(1, 4, 4, 4, 1, 1, 4, 1);
        System.out.println(r1.equals(r2));
        System.out.println(r1.commonPoints(r2));
        System.out.println(r1.perimeter());
        System.out.println(r1);
        System.out.println(r1.square());
    }

}
