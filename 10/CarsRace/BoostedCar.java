package CarsRace;

public class BoostedCar extends Car implements Beepable{
    public int boostStartTime;
    public BoostedCar(int speedFirst3Minutes, int speedAfter, int boostStartTime){
        super(speedFirst3Minutes,speedAfter);
        this.boostStartTime = boostStartTime;
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
    public String toString() {
        return "BoostedCar{" +
                "boostStartTime=" + boostStartTime +
                ", speedFirst3Minutes=" + speedFirst3Minutes +
                ", speedAfter=" + speedAfter +
                '}';
    }

    @Override
    public String who() {
        return "BoostedCar => ";
    }

    @Override
    public void beep(){
        System.out.println("Boooooooost");
    }
}
