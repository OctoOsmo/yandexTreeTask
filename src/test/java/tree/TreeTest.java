package tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class TreeTest {
    List<Integer> values = Arrays.asList(1, 2, 3, 6, 10, 12, 21, 22, 29, 33, 64, 65, 66, 70, 78, 101, 111, 123, 345, 355, 444, 541);
    NodeService<Integer> ns = new NodeService<>();
    TreeGenerator<Integer> treeGenerator = new TreeGenerator<>();

    @Test
    public void test() {
        TreeNode<Integer> balancedTree = treeGenerator.buildBalancedTree(values, null);

        for (int i = 0; i < values.size() - 1; i++) {
            Integer current = values.get(i);
            Integer next = values.get(i + 1);
            TreeNode<Integer> successor = findSuccessorByValue(balancedTree, current);

            assertEquals(next, successor.getValue());
        }
        Integer lastValue = values.get(values.size() - 1);
        TreeNode<Integer> lastNodeSuccessor = findSuccessorByValue(balancedTree, lastValue);

        assertNull(lastNodeSuccessor);
    }

    private TreeNode<Integer> findSuccessorByValue(TreeNode<Integer> balancedTree, Integer current) {
        TreeNode<Integer> treeNode = ns.findByValue(current, balancedTree);
        return ns.inorderSuccessor(treeNode);
    }
}
