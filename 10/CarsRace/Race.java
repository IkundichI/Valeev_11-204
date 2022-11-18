package CarsRace;

public class Race {
    
    public static void start(Car[] cars, int duration) {
        int i = 0;
        int rez = 0;
        int maxCar = 0;
        for (Car k1: cars) {
            if (k1 == null) {
                break;
            }
            System.out.println(k1.who() + k1.countDistance(duration));
            if (k1.countDistance(duration) > maxCar) {
                maxCar = k1.countDistance(duration);
                rez = i;
            }
            i++;
        }
        System.out.print((rez + 1) + " => "); //Тут выводиться строка, в которой была машинка в файле
        cars[rez].beep();
    }
}
