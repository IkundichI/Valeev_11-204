package Third;

public class CasualCar extends Car{

    int a;
    int b;

    public CasualCar(int a, int a1, int b) {
        super(a);
        this.a = a1;
        this.b = b;
    }

    @Override
    public void beep(){
        System.out.println("bip bip");
    }
    @Override
    public int summa() {
        return a + b;
    }
}
