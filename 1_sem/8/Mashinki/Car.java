package Mashinki;

public class Car {
    public double weight;
    public double horsePower;
    public int speedFirst3Minutes;
    public int speedAfter;

    public Car(double weight, double horsePower, int speedFirst3Minutes, int speedAfter) {
        this.weight = weight;
        this.horsePower = horsePower;
        this.speedFirst3Minutes = speedFirst3Minutes;
        this.speedAfter = speedAfter;
    }
    public Car(){
    }
    public int countDistance(int duration) {
        int a = 0;
        for (int i = 1; i < duration + 1; i++) {
            if (i <= 3) {
                a += speedFirst3Minutes;
            }
            else {
                a += speedAfter;
            }
        }
        return a;
    }
    public void beep(){
        System.out.println("beep beep");
    }
}
