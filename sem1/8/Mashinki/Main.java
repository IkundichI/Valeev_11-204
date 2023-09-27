package Mashinki;

public class Main {
    public static void main(String[] args) {
        F1Car f1 = new F1Car(10, 10, 60, 220);
        CasualCar f2 = new CasualCar(10, 10, 100, 150);
        BoostedCar f3 = new BoostedCar(10, 12, 90, 160, 3);
        Race.start(f1, f2, f3, 4);

    }
}
