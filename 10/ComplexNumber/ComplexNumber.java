package ComplexNumber;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber() {
        imaginaryPart = 0;
        realPart = 0;
    }
    public ComplexNumber(double realPart, double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
        this.realPart = realPart;
    }

    public ComplexNumber add(ComplexNumber n) {
        ComplexNumber complexNumber = new ComplexNumber(realPart + n.getRealPart(), imaginaryPart + n.getImaginaryPart());
        return complexNumber;
    }
    public void add2(ComplexNumber n) {
        realPart += n.getRealPart();
        imaginaryPart += n.getImaginaryPart();
    }

    public ComplexNumber sub(ComplexNumber n) {
        ComplexNumber complexNumber = new ComplexNumber(realPart - n.getRealPart(), imaginaryPart - n.getImaginaryPart());
        return complexNumber;
    }
    public void sub2(ComplexNumber n) {
        realPart -= n.getRealPart();
        imaginaryPart -= n.getImaginaryPart();
    }

    public ComplexNumber multNumber(double k) {
        ComplexNumber complexNumber = new ComplexNumber(realPart*k, imaginaryPart*k);
        return complexNumber;
    }
    public void multNumber2(double k) {
        imaginaryPart *= k;
        realPart *= k;
    }

    public ComplexNumber mult(ComplexNumber n) {
        ComplexNumber complexNumber = new ComplexNumber(realPart*n.getRealPart() - imaginaryPart*n.getImaginaryPart(), realPart*n.getImaginaryPart() + imaginaryPart*n.getRealPart());
        return complexNumber;
    }
    public void mult2(ComplexNumber n) {
        double a = realPart*n.getRealPart() - imaginaryPart*n.getImaginaryPart();
        double b = realPart*n.getImaginaryPart() + imaginaryPart*n.getRealPart();
        realPart = a;
        imaginaryPart = b;

    }

    public ComplexNumber div(ComplexNumber n) {
        ComplexNumber rev = new ComplexNumber(n.getRealPart(), (-1)*n.imaginaryPart);
        ComplexNumber ch1 = mult(rev);
        ComplexNumber ch2 = new ComplexNumber((n.getRealPart()*n.getRealPart() + n.imaginaryPart*n.imaginaryPart), 0);
        ComplexNumber rez = new ComplexNumber(ch1.getRealPart()*(1/ ch2.getRealPart()), ch1.getImaginaryPart()*(1/ch2.realPart));
        return rez;

    }
    public void div2(ComplexNumber n) {
        ComplexNumber n1 = div(n);
        realPart = n1.realPart;
        imaginaryPart = n1.imaginaryPart;
    }


    @Override
    public String toString() {
        String s = "";
        if (realPart != 0) {
            s += realPart;
            if (imaginaryPart > 0) {
                s += " + " + imaginaryPart + "*i";
            }
            else if (imaginaryPart < 0) {
                s += " - " + Math.abs(imaginaryPart) + "*i";
            }
        }
        else {
            if (imaginaryPart > 0) {
                s += imaginaryPart + "*i";
            }
            else if (imaginaryPart < 0) {
                s += "-" + Math.abs(imaginaryPart) + "*i";
            }
        }
        if (s.length() == 0) {
            return "0";
        }
        return s;
    }
    public boolean equals(ComplexNumber n1) {
        return (realPart == n1.getRealPart() && imaginaryPart == n1.getImaginaryPart());
    }
    public double length() {
        return Math.sqrt(realPart*realPart + imaginaryPart*imaginaryPart);
    }
    public double arg() {
        return (Math.atan(imaginaryPart/realPart));
    }
    public ComplexNumber pow(double k) {
        double a = Math.pow(length(), k) * Math.cos(arg()*k);
        double b = Math.pow(length(), k) * Math.sin(arg()*k);
        ComplexNumber rez = new ComplexNumber(a, b);
        return rez;

    }

    public double getRealPart() {
        return realPart;
    }
    public double getImaginaryPart() {
        return imaginaryPart;
    }
}
