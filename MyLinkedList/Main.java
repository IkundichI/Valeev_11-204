package MyLinkedList;

public class Main {
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.add("111");
		list.add("55");
		list.add("113141");
		Object[] array = list.toArray();
		int[] z = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			z[i] = Integer.parseInt((String) array[i]);
		}
		System.out.println(z[0] + z[1]);


	}
}
