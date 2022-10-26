package Kyrica;

import java.util.Random;

public class Kyrica {
    private double age;
    private String colorOfPeria; //red, green, blackGold, purple, white
    private boolean boleetLi;
    private double ves;
    private int dlinaOfKrilo;
    private String poroda;
    private int countOfYachki = 0;
    public Kyrica(double age, String colorOfPeria, boolean boleetLi, double ves, int dlinaOfKrilo, String poroda) {
        this.age = age;
        this.colorOfPeria = colorOfPeria;
        this.boleetLi = boleetLi;
        this.ves = ves;
        this.dlinaOfKrilo = dlinaOfKrilo;
        this.poroda = poroda;
        this.countOfYachki = 0;
    }
    public Kyrica(double age, String colorOfPeria, boolean boleetLi, double ves, int dlinaOfKrilo, String poroda, int countOfYachki) {
        this(age, colorOfPeria, boleetLi, ves, dlinaOfKrilo, poroda);
        this.countOfYachki = countOfYachki;

    }

    public boolean getBoletLi() {
        return boleetLi;
    }

    public void setBoleetLi(boolean boleetLi) {
        this.boleetLi = boleetLi;
    }


    public static Kyrica sosdatNewKyrica(Kyrica k1, Kyrica k2) {
        Random random = new Random();
        int random1;
        if (k1.age < 0.3 || k2.age < 0.3) {
            throw new RuntimeException("Курицы не готовы к размножению, трай эгейн лейтер...");
        }
        Kyrica k3 = new Kyrica(0, k1.colorOfPeria, k1.boleetLi, random.nextInt(200) + 400, k1.dlinaOfKrilo, k1.poroda);
        if (k1.age > 2 || k2.age > 2 || k2.boleetLi || k1.boleetLi) {
            k3.boleetLi = true;
        }
        random1 = random.nextInt(5);
        switch (random1) {
            case 1:
                k3.colorOfPeria = "red";
                break;
            case 2:
                k3.colorOfPeria = "green";
                break;
            case 3:
                k3.colorOfPeria = "blackGold";
                break;
            case 4:
                k3.colorOfPeria = "purple";
                break;
            case 0:
                k3.colorOfPeria = "white";
                break;
            default:
                k3.colorOfPeria = "brown";
        }
        random1 = random.nextInt(2);
        if (random1 == 0) {
            k3.poroda = k1.poroda;
        }
        else {
            k3.poroda = k2.poroda;
        }
        k3.dlinaOfKrilo = random.nextInt(Math.max(k1.dlinaOfKrilo, k2.dlinaOfKrilo) + Math.min(k1.dlinaOfKrilo, k2.dlinaOfKrilo) );
        return k3;
    }

    public void krikOfKyrica() {
        System.out.println("Кудах тах тах");
        if (age > 1 && age < 2) {
            System.out.println("Я курица и хочу трахаться с женскими особями...");
        }
    }

    public void iAmEating() {
        System.out.println("Я клевать зерно... и расти чтобы стать большой курица");
        ves += 10;
        age += 0.4;
    }

    public void nestiYachki() {
        if (poroda == "Яичная" && age >= 0.4) {
            countOfYachki += 3;
        }
    }


    public void showInfo() {
        System.out.println("Курица породы - " + poroda + ", возраст у неё{лет} - " + age + ", её вес{гр.} - " + ves + ", цвет перьев - " + colorOfPeria + ", есть ли болезнь? - " + boleetLi + ", у меня столько яиц - " + countOfYachki);
    }
}
