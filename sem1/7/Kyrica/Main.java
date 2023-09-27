package Kyrica;

public class Main {
    public static void main(String[] args) {
        Kyrica k1 = new Kyrica(1.3, "green", false, 945, 12, "Яичная");
        Kyrica k2 = new Kyrica(0.4, "white", false, 945, 12, "Яичная");
        Kyrica k3 = Kyrica.sosdatNewKyrica(k1, k2);
        k3.showInfo();
        k3.krikOfKyrica();
        k3.iAmEating();
        k3.nestiYachki();
        k3.nestiYachki();
        k3.showInfo();





    }
}
