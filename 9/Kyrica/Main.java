package Kyrica;

public class Main {
    public static void main(String[] args) throws KyricaException {
        Kyrica k1 = new Kyrica(1.3, "green", false, 945, 12, "Яичная");
        Kyrica k2 = new Kyrica(0.4, "white", false, 945, 12, "Яичная");
        Kyrica k3 = Kyrica.sosdatNewKyrica(k1, k2);
        k1.nestiYachki();
        k1.nestiYachki();
        k1.nestiYachki();
        //k1.zabratYachki(20);
        //Kyrica.metod(k1);

    }
}
