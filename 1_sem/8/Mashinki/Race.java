package Mashinki;

public class Race {
    public static void start(Car car1, Car car2, Car car3, int duration) {
        int a = car1.countDistance(duration);
        int b = car2.countDistance(duration);
        int c = car3.countDistance(duration);
        System.out.println("FisrtCar - " + a + " " + "SecondCar - " + b + " ThirdCar - " + c);
        if (a > Math.max(b, c)) {
            car1.beep();
        }
        else if (b > Math.max(c, a)) {
            car2.beep();
        }
        else if (c > Math.max(a, b)) {
            car3.beep();
        }
        else if (a == b && b != c) {
            car1.beep();
            car3.beep();
        }
        else if (a == c && c != a) {
            car1.beep();
            car3.beep();
        }
        else if (b == c && b != a) {
            car2.beep();
            car3.beep();
        }
        else {
            car2.beep();
            car3.beep();
            car1.beep();
        }
    }
}
