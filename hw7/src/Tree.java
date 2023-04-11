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


    public Tree get(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value && left != null) {
            return left.get(value);
        } else if (value > this.value && right != null) {
            return right.get(value);
        } else {
            return null;
        }
    }

    public Tree add(int value) {
        if (value < this.value) {
            if (left == null) {
                left = new Tree();
                left.value = value;
                left.parent = this;
                return left;
            } else {
                return left.add(value);
            }
        } else {
            if (right == null) {
                right = new Tree();
                right.value = value;
                right.parent = this;
                return right;
            } else {
                return right.add(value);
            }
        }
    }
}