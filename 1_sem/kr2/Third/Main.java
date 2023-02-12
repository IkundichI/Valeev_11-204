package Third;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(2);
        Car c2 = new CasualCar(2, 3, 4);
        c1.beep();
        c2.beep();
        System.out.println(c1.summa());
        System.out.println(c2.summa());
    }

}
