package CarsRace;

abstract class Car implements Beepable{
    public int speedFirst3Minutes;
    public int speedAfter;
    public Car(int speedFirst3Minutes, int speedAfter) {
        this.speedFirst3Minutes = speedFirst3Minutes;
        this.speedAfter = speedAfter;
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
}
