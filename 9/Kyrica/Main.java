package Kyrica;

public class Main {
    public static void main(String[] args) throws KyricaException {
        Kyrica k1 = new Kyrica(1.3, "green", false, 945, 12, "Мясная");
        Kyrica k2 = new Kyrica(0.4, "white", false, 945, 12, "Яичная");
        k1.nestiYachki();
        k2.nestiYachki();
        System.out.println(k2.skolikoYachnits());
        System.out.println(k1.skolikoYachnits());

    }
}
