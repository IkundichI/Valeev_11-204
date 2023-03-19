package MySet;

import java.lang.reflect.Array;
import java.util.*;

public class MySet<T> extends AbstractSet<T> implements SortedSet<T> {

	private T[] elements;
	private Comparator<? super T> comparator;
	private T current;

	public MySet(Collection<? extends T> c, Comparator<? super T> comparator, Class<T> tClass) {
		this.comparator = comparator;
		this.elements = (T[]) Array.newInstance(tClass, c.size());
		c.toArray(this.elements);
		Arrays.sort(this.elements, comparator);
	}

	public MySet(Comparator<? super T> comparator, Class<T> tClass) {
		this.comparator = comparator;
		this.elements = (T[]) Array.newInstance(tClass, 0);
	}

	@Override
	public boolean add(T e) {
		if (e == null) {
			return false;
		}
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].equals(e)) {
				return false;
			}
		}
		T[] newElements = (T[]) Array.newInstance(elements.getClass().getComponentType(), this.size() + 1);
		for (int i = 0; i < elements.length; i++) {
			newElements[i] = elements[i];
		}
		int count = size();
		newElements[count] = e;
		elements = newElements;
		Arrays.sort(elements, comparator);


		return true;
	}

	public boolean remove(Object o) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].equals(o)) {
				int index = i;
				T[] newElements = (T[]) Array.newInstance(elements.getClass().getComponentType(), this.size() - 1);
				int count = 0;
				for (int j = 0; j < elements.length; j++) {
					if (j != index) {
						newElements[count] = elements[j];
						count++;
					}
				}
				elements = newElements;
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < size();
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				current = elements[index];
				index++;
				return current;
			}

			@Override
			public void remove() {
				if (current == null) {
					throw new IllegalStateException();
				}
				MySet.this.remove(current);
				current = null;
				index--;
			}

		};
	}

	@Override
	public int size() {
		return this.elements.length;
	}

	@Override
	public Comparator<? super T> comparator() {
		return this.comparator;
	}

	@Override
	public SortedSet<T> subSet(T fromElement, T toElement) {
		int fromIndex = Arrays.binarySearch(this.elements, fromElement, comparator);
		int toIndex = Arrays.binarySearch(this.elements, toElement, comparator);
		if (fromIndex < 0) {
			fromIndex = -fromIndex - 1;
		}
		if (toIndex < 0) {
			toIndex = -toIndex - 1;
		}
		return new MySet<>(Arrays.asList(elements).subList(fromIndex, toIndex), comparator(),
				  (Class<T>) elements.getClass().getComponentType());
	}

	@Override
	public SortedSet<T> headSet(T toElement) {
		MySet<T> newMySet = new MySet<T>(comparator, (Class<T>) elements.getClass().getComponentType());
		for (int i = 0; i < elements.length; i++) {
			if (comparator.compare(elements[i], toElement) < 0) {
				newMySet.add(elements[i]);
			}
		}
		return newMySet;
	}

	@Override
	public SortedSet<T> tailSet(T fromElement) {
		MySet<T> newMySet = new MySet<T>(comparator, (Class<T>) elements.getClass().getComponentType());
		for (int i = 0; i < elements.length; i++) {
			if (comparator.compare(elements[i], fromElement) >= 0) {
				newMySet.add(elements[i]);
			}
		}
		return newMySet;
	}

	@Override
	public T first() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		return elements[0];
	}

	@Override
	public T last() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		return elements[size() - 1];
	}
}