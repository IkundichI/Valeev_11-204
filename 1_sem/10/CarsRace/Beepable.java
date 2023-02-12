package CarsRace;

public interface Beepable {
    default void beep() {
        System.out.println("beeeep");
    }
    default String who() {
        return "Car => ";
    }
}
