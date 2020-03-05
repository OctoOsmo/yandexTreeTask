package tree;

public interface Node<T> {
    Node<T> getParent();

    Node<T> getLeft();

    Node<T> getRight();

    T getValue();
}
