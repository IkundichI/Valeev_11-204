package hw3.secondTask;

import java.util.*;

public class ModifiableCollection<T> extends AbstractCollection<T> {
    private T[] element;
    private int size;

    public ModifiableCollection() {
        this.element = (T[]) new Object[10];
        this.size = 0;
    }

    public ModifiableCollection(int capacity) {
        this.element = (T[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(T item) {
        if (size == element.length) {
            T[] newItems = (T[]) new Object[(element.length * 2) + 2];
            for (int i = 0; i < element.length; i++) {
                newItems[i] = element[i];
            }
            element = newItems;
        }
        element[size++] = item;
        return true;
    }

    public Iterator<T> iterator() {
        return new ModifiableIterator();
    }

    private class ModifiableIterator implements Iterator<T> {
        private int cursor = 0;
        private boolean canRemove = false;

        public boolean hasNext() {
            return cursor < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = element[cursor++];
            canRemove = true;
            return item;
        }

        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException();
            }
            cursor--;
            size--;
            for (int i = cursor; i < size; i++) {
                element[i] = element[i+1];
            }
            element[size] = null;
            canRemove = false;
        }
    }
}