package MuLinkedList;

public class Main {
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		MyLinkedList<String> list1 = new MyLinkedList<String>();

		list.add(1);
		list.add(3);
		list.add(7);
		list.add(3);
		list.add(12);


		list.sort(Integer::compareTo);
		System.out.println(list);


	}
}
