package hw1.secondTask;

import java.util.AbstractCollection;
import java.util.Iterator;

public class ModifiableCollection<T> extends AbstractCollection<T> {
    private T[] elements;
    private int size;
    public ModifiableCollection() {
        this.elements = (T[]) new Object[0];
        this.size = 0;
    }
    public ModifiableCollection(T[] elements) {
        this.elements = elements;
        this.size = elements.length;
    }

    public boolean add(T element) {
        if (size == elements.length) {
            T[] new_elements = (T[]) new Object[(elements.length * 2) + 2];
            for (int i = 0; i < elements.length; i++) {
                new_elements[i] = elements[i];
            }
            elements = new_elements;
        }
        elements[size] = element;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current_index = 0;

            public boolean hasNext() {
                return current_index < size;
            }

            public T next() {
                T result = elements[current_index];
                current_index++;
                return result;
            }

            public void remove() {
                for (T elem: elements) {
                    if ()
                }
            }
        };
    }
}
