package Mashinki;


public class BoostedCar extends Car{
    public int boostStartTime;
    public BoostedCar(double weight, double horsePower,
                 int speedFirst3Minutes,
                 int speedAfter, int boostStartTime){
        super(weight,horsePower,speedFirst3Minutes,speedAfter);
        this.boostStartTime = boostStartTime;
    }
    public BoostedCar(double weight, double horsePower,
                      int speedFirst3Minutes,
                      int speedAfter){
        super(weight,horsePower,speedFirst3Minutes,speedAfter);
        boostStartTime = -1;
    }

    @Override
    public int countDistance(int duration) {
        int a = 0;
        if (boostStartTime >= 1) {
            int[] boost = {boostStartTime, boostStartTime + 1, boostStartTime + 2};
            for (int i = 0; i < boost.length; i++) {
                if (boost[i] > duration) {
                    break;
                } else if (boost[i] <= 3) {
                    a += speedFirst3Minutes;
                } else if (boost[i] > 3) {
                    a += speedAfter;
                }
            }
        }
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

    @Override
    public void beep(){
        System.out.println("Boooooooost");
    }

    @Override
    public String toString() {
        return "BoostedCat{" +
                "weight=" + weight +
                ", horsePower=" + horsePower +
                ", speedFirst3Minutes=" + speedFirst3Minutes +
                ", speedAfter=" + speedAfter +
                '}';
    }
}
