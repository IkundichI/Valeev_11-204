package hw7_8.src;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	private int value;
	private Tree left;
	private Tree right;
	private Tree parent;

	public Tree(int value) {
		this.value = value;
	}

	public Tree() {

	}

	public Tree(int value, Tree left, Tree right, Tree parent) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public Tree get(int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value && this.left != null) {
			return this.left.get(value);
		} else if (value > this.value && this.right != null) {
			return this.right.get(value);
		}
		return null;
	}

	public Tree add(int value) {
		Tree node = new Tree();
		node.value = value;
		node.parent = this;
		if (value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(value);
			}
		} else if (value >= this.value) {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(value);
			}
		}
		return node;
	}

	public void remove(int value) {
		Tree node = this.get(value);
		if (node == null) {
			return;
		}
		if (node.left != null && node.right != null) {
			Tree successor = node.right;
			while (successor.left != null) {
				successor = successor.left;
			}
			node.value = successor.value;
			successor.remove(successor.value);
		} else if (node.left != null) {
			if (node.parent.left == node) {
				node.parent.left = node.left;
			} else {
				node.parent.right = node.left;
			}
			node.left.parent = node.parent;
		} else if (node.right != null) {
			if (node.parent.left == node) {
				node.parent.left = node.right;
			} else {
				node.parent.right = node.right;
			}
			node.right.parent = node.parent;
		} else {
			if (node.parent.left == node) {
				node.parent.left = null;
			} else {
				node.parent.right = null;
			}
		}
	}

	public void levelOrderTraversal() throws IOException {
		File file = new File("fileWithTree.txt");
		file.createNewFile();
		RandomAccessFile randomAccessFile =
				  new RandomAccessFile(file,"rw");
		randomAccessFile.setLength(0);
		Queue<Tree> queue = new LinkedList<>();
		queue.add(this);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Tree node = queue.poll();
				if (level > 2) {
					randomAccessFile.write((node.value + "(" + node.parent.value + ") ").getBytes());
					System.out.print(node.value + "(" + node.parent.value + ") ");
				}
				else {
					randomAccessFile.write((node.value + " ").getBytes());
					System.out.print(node.value + " ");
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			randomAccessFile.writeBytes("\n");
			System.out.println();

			level++;
		}
		randomAccessFile.close();
	}

}