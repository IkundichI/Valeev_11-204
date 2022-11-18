package CarsRace;

public class CasualCar extends Car implements Beepable{
    public CasualCar(int speedFirst3Minutes, int speedAfter) {
        super(speedFirst3Minutes, speedAfter);
    }
    @Override
    public void beep(){
        System.out.println("new honk");
    }

    @Override
    public String toString() {
        return "CasualCar{" +
                "speedFirst3Minutes=" + speedFirst3Minutes +
                ", speedAfter=" + speedAfter +
                '}';
    }
    @Override
    public String who() {
        return "CasualCar => ";
    }
}
