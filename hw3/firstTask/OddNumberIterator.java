package hw1.firstTask;

import java.util.Iterator;

public class OddNumberIterator implements Iterator<Integer> {
    private int[] array;
    private int index;

    public OddNumberIterator(int[] array) {
        this.array = array;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        while (array.length > index && array[index] % 2 == 0) {
            index++;
        }
        return array.length > index;
    }

    @Override
    public Integer next() {
        int currentNumber = array[index++];
        return currentNumber;
    }
}
