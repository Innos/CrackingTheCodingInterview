package TreesAndGraphs.Collections;


public class TreeNodeWithParent<T> {
    private TreeNodeWithParent<T> parent;
    private T value;
    private TreeNodeWithParent<T> left;
    private TreeNodeWithParent<T> right;

    public TreeNodeWithParent(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public TreeNodeWithParent<T> getLeft() {
        return this.left;
    }

    public void setLeft(TreeNodeWithParent<T> left) {
        left.setParent(this);
        this.left = left;
    }

    public TreeNodeWithParent<T> getRight() {
        return this.right;
    }

    public void setRight(TreeNodeWithParent<T> right) {
        right.setParent(this);
        this.right = right;
    }

    public TreeNodeWithParent<T> getParent() {
        return this.parent;
    }

    public void setParent(TreeNodeWithParent<T> parent) {
        this.parent = parent;
    }
}
