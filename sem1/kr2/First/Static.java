package First;

public class Static {

    public double massivPlosh(Rectangle[] array) {
        double s = 0;
        for (int i = 0; i < array.length; i++) {
            s += array[i].perimeter();
        }
        return s;
    }
    public boolean proverkaPrym(Rectangle[] array) {
        boolean ans = true;
        for (int i = 1; i < array.length - 1; i++) {
            if ((array[i].commonPoints(array[i + 1]) && array[i].commonPoints(array[i - 1])) == false) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
