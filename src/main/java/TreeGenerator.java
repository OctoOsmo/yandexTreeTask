import java.util.*;

public class TreeGenerator<T> {

    TreeNode<T> buildBalancedTree(List<T> values, TreeNode<T> parent) {
        if (values.isEmpty()) {
            return null;
        } else {
            int middle = values.size() / 2;
            TreeNode<T> node = new TreeNode<T>(values.get(middle));
            node.setParent(parent);
            node.setLeft(buildBalancedTree(values.subList(0, middle), node));
            node.setRight(buildBalancedTree(values.subList(middle + 1, values.size()), node));
            return node;
        }
    }

    public void printTree(TreeNode<T> root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for(String[] arr:res)
            Arrays.fill(arr," ");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for(String[] arr:res)
            ans.add(Arrays.asList(arr));
        for (List<String> an : ans) {
            for (String s : an) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public void fill(String[][] res, TreeNode<T> root, int i, int l, int r) {
        if (root == null)
            return;
        res[i][(l + r) / 2] = "" + root.getValue();
        fill(res, root.getLeft(), i + 1, l, (l + r) / 2);
        fill(res, root.getRight(), i + 1, (l + r + 1) / 2, r);
    }
    public int getHeight(TreeNode<T> root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }
}
