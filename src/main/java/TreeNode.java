public class TreeNode<T> implements Node<T> {
    private TreeNode<T> parent;
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T value;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right, T value) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left){
        this.left = left;
    }

    @Override
    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    @Override
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
