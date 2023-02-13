package MyLinkedList;

public class Main {
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<String>();
		MyLinkedList<String> list1 = new MyLinkedList<String>();
		list1.add("1");
		list1.add("4");
		list1.add("3");
		System.out.println(list1.set(2, "2"));
		System.out.println(list1);
	}
}
