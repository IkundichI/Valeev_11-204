package MyLinkedList;

public class Main {
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<String>();
		MyLinkedList<String> list1 = new MyLinkedList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list1.equals(list));

	}
}
