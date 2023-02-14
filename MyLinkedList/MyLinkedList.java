package MyLinkedList;

public class MyLinkedList<T> {
	private Node<T> firstNode;

	public int size() {
		if (firstNode == null) {
			return 0;
		}
		int size = 1;
		Node<T> currentNode = firstNode;
		while (currentNode.getNext() != null){
			currentNode = currentNode.getNext();
			size++;
		}
		return size;
	}

	public boolean add(T elem) {
		if (firstNode == null) {
			firstNode = new Node<>(elem, null);
		} else {
			Node<T> current = firstNode;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new Node<>(elem, null));
		}
		return true;
	}

	public boolean addAll(MyLinkedList<T> otherList) {
		if (otherList.size() <= 0) {
			return false;
		}
		Node<T> current = firstNode;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(otherList.firstNode);
		return true;
	}

	public void clear() {
		firstNode = null;
	}

	public boolean contains(T elem) {
		Node<T> current = firstNode;
		while (current != null) {
			if (current.getValue().equals(elem)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	public boolean containsAll(MyLinkedList<T> otherList) {
		Node<T> current = otherList.firstNode;
		while (current != null) {
			if (!contains(current.getValue())) {
				return false;
			}
			current = current.getNext();
		}
		return true;
	}

	public boolean isEmpty() {
		return firstNode == null;
	}

	public int indexOf(T elem) {
		if (isEmpty()) {
			return -1;
		}
		int index = 0;
		Node<T> current = firstNode;
		while (current.getNext() != null) {
			if (current.getValue().equals(elem)) {
				return index;
			}
			index++;
			current = current.getNext();
		}
		if (current.getValue().equals(elem)) {
			return index;
		}
		return -1;
	}

	public T remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> curNode = null;
		if (index == 0) {
			curNode = firstNode;
			firstNode = firstNode.getNext();
			return curNode.getValue();
		}

		Node<T> current = firstNode;
		int currentIndex = 0;
		int finalIndex;
		while (index != currentIndex + 1) {
			current = current.getNext();
			currentIndex++;
		}
		curNode = current.getNext();
		current.setNext(current.getNext().getNext());
		return curNode.getValue();

	}

	public boolean remove(T elem) {
		if (indexOf(elem) == -1) {
			return false;
		}
		remove(indexOf(elem));
		return true;
	}

	public boolean removeAll(MyLinkedList<T> otherList) {
		if (!containsAll(otherList)) {
			return false;
		}
		Node<T> current = otherList.firstNode;
		while (current.getNext() != null) {

			while (contains(current.getValue())) {
				remove(current.getValue());
			}
			current = current.getNext();
		}
		while (contains(current.getValue())) {
			remove(current.getValue());
		}
		return true;
	}

	public T set(int index, T elem) {

		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = firstNode;
		T link = null;
		int count = 0;
		while (count != index && current.getNext() != null) {
			current = current.getNext();
			count++;
		}
		link = current.getValue();
		current.setValue(elem);
		return link;
	}

	public MyLinkedList<T> sublist(int fromIndex, int toIndex) {
		if (fromIndex == toIndex) {
			return new MyLinkedList<T>();
		}
		if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		MyLinkedList<T> currentList = new MyLinkedList<T>();
		Node<T> current = firstNode;
		int count = 0;
		while (current.getNext() != null) {
			if (count >= fromIndex && count < toIndex) {
				currentList.add(current.getValue());
			}
			current = current.getNext();
			count++;
		}
		return currentList;
	}

	public int lastIndexOf(T elem) {
		if (!contains(elem)) {
			return -1;
		}
		int index = 0;
		int count = 0;
		Node<T> current = firstNode;
		while (current.getNext() != null) {
			if (current.getValue().equals(elem)) {
				index = count;
			}
			count++;
			current = current.getNext();
		}
		if (current.getValue().equals(elem)) {
			index = count;
		}
		return index;


	}

	public Object[] toArray() {
		Object[] array = new Object[size()];
		int id = 0;
		for (Node<T> i = firstNode; i != null; i = i.getNext()) {
			array[id] = i.getValue();
			id++;
		}
		return array;
	}

	@Override
	public String toString() {
		if (size() == 0) {
			return "[]";
		}
		String str = "[";
		Node<T> current = firstNode;
		while (current.getNext() != null) {
			str += current.getValue() + ", ";
			current = current.getNext();
		}
		str += current.getValue() + "]";
		return str;

	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof MyLinkedList)) {
			return false;
		}
		MyLinkedList other = (MyLinkedList) o;
		if (this.size() != other.size()) {
			return false;
		}
		Node<T> currentNode = this.firstNode;
		Node<T> otherCurrentNode = other.firstNode;
		while (currentNode != null) {
			if (!currentNode.getValue().equals(otherCurrentNode.getValue())) {
				return false;
			}
			currentNode = currentNode.getNext();
			otherCurrentNode = otherCurrentNode.getNext();
		}
		return true;
	}
}