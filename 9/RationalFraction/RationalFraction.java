package RationalFraction;



public class RationalFraction {

    private int numerator;
    private int denominator;
    public int dcd(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return dcd(number2, number1 % number2);
    }
    public int lcm(int number1, int number2) {
        return number1*number2*dcd(number1, number2);
    }

    public RationalFraction() {
        numerator = 0;
        denominator = 1;
    }
    public RationalFraction(int numerator, int denominator) {
        this.denominator = denominator;
        this.numerator = numerator;
        if (denominator == 0) {
            throw new RuntimeException("Division by 0 is forbidden! Learn math. ");
        }
        reduce();
    }

    public RationalFraction add(RationalFraction f1){
        RationalFraction f2 = new RationalFraction(numerator*f1.getDenominator() + f1.getNumerator()*denominator, f1.getDenominator()*denominator);
        f2.reduce();
        return f2;
    }
    public void add2(RationalFraction f1){
        numerator = numerator*f1.getDenominator() + f1.getNumerator()*denominator;
        denominator = f1.getDenominator()*denominator;
        reduce();
    }

    public RationalFraction sub(RationalFraction f1) {
        RationalFraction f2 = new RationalFraction(numerator*f1.getDenominator() - f1.getNumerator()*denominator, f1.getDenominator()*denominator);
        f2.reduce();
        return f2;
    }
    public void sub2(RationalFraction f1){
        numerator = numerator*f1.getDenominator() - f1.getNumerator()*denominator;
        denominator = f1.getDenominator()*denominator;
        reduce();
    }

    public RationalFraction mult(RationalFraction f1){
        RationalFraction f2 = new RationalFraction(numerator*f1.getNumerator(), f1.getDenominator()*denominator);
        f2.reduce();
        return f2;
    }
    public void mult2(RationalFraction f1){
        numerator = numerator*f1.getNumerator();
        denominator = f1.getDenominator()*denominator;
        reduce();
    }

    public RationalFraction div(RationalFraction f1) {
        RationalFraction f2 = new RationalFraction(numerator*f1.getDenominator(), f1.getNumerator() * denominator);
        f2.reduce();
        return f2;
    }
    public void div2(RationalFraction f1){
        numerator = numerator*f1.getDenominator();
        denominator = f1.getNumerator() * denominator;
        reduce();
    }

    @Override
    public String toString() {
        return "Your fraction - [" + numerator + "/" + denominator + "] | In decimal form - " + value() + " | Integer part - " + numberPart();
    }

    public void reduce() {
        int dcdNumber = dcd(numerator, denominator);
        numerator = numerator/dcdNumber;
        denominator = denominator/dcdNumber;
        if (numerator < 0 && denominator < 0) {
            denominator = Math.abs(denominator);
            numerator = Math.abs(numerator);
        }
        else if (denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }
    }
    public double value() {
        return (double) numerator/denominator;
    }
    public boolean equals(RationalFraction f1) {
        return (f1.getDenominator() == denominator && f1.numerator == numerator) ? true : false;
    }
    public int numberPart() {
        return numerator/denominator;
    }

    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
}
