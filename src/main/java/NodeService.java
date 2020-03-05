public class NodeService<T extends Integer> {

    public TreeNode<T> findByValue(T value, TreeNode<T> rootNode) {
        if (rootNode.getValue().compareTo(value) > 0) {
            return findByValue(value, rootNode.getLeft());
        } else if (rootNode.getValue().compareTo(value) < 0) {
            return findByValue(value, rootNode.getRight());
        } else {
            return rootNode;
        }
    }

    public TreeNode<T> inorderSuccessor(TreeNode<T> node) {
        //есть правая нода
        // берём рекурсивно левую у неё
        TreeNode<T> right = node.getRight();
        if (right != null) {
            return getLeftRecurse(right);
        } else {
            //нет правой ноды
            // поднимаемся наверх до первой правой, если её нет, то возвращаем null
            // если есть то возвращаем первую правую
            if (hasParent(node)) {
                return getUp(node);
            } else {
                return null;
            }
        }
    }

    private TreeNode<T> getUp(TreeNode<T> node) {
        if (!hasParent(node)) {
            return null;
        }

        if (isRight(node)) {
            return getUp(node.getParent());
        } else {
            return node.getParent();
        }
    }

    private boolean hasParent(TreeNode<T> node) {
        return node.getParent() != null;
    }

    private boolean isRight(TreeNode<T> node) {
        TreeNode<T> right = node.getParent().getRight();
        return node.equals(right);
    }

    private TreeNode<T> getLeftRecurse(TreeNode<T> node) {
        TreeNode<T> left = node.getLeft();
        if (left != null) {
            return getLeftRecurse(left);
        }
        return node;
    }
}
