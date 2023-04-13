package hw7_8.src;

public class Main {
	public static void main(String[] args) {
		Tree tree = new Tree(3);
		tree.add(9);
		tree.add(10);
		tree.add(4567);
		tree.add(24354668);
		tree.add(2);
		tree.add(222);
		try {
			tree.levelOrderTraversal();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		tree.remove(9);
		tree.remove(8);
		try {
			tree.levelOrderTraversal();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
