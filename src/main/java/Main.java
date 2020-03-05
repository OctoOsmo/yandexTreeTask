import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Integer> values = Arrays.asList(1, 2, 3, 6, 10, 12, 21, 22, 29, 33, 64, 65, 66, 70, 78, 101, 111, 123, 345, 355, 444, 541);
    static NodeService<Integer> ns = new NodeService<>();

    public static void main(String[] args) {

        TreeGenerator<Integer> treeGenerator = new TreeGenerator<>();
        TreeNode<Integer> balancedTree = treeGenerator.buildBalancedTree(values, null);

        treeGenerator.printTree(balancedTree);

//        int startValue = 101;
//        printSuccessor(balancedTree, startValue);

        for (int i = 0; i < values.size() - 1; i++) {
            Integer current = values.get(i);
            Integer next = values.get(i + 1);

            TreeNode<Integer> successor = printSuccessor(balancedTree, current);

            System.out.println(successor.getValue().equals(next));
        }
        TreeNode<Integer> successor = printSuccessor(balancedTree, values.get(values.size() - 1));
        System.out.println(successor == null);
        System.out.println("Tree is Done");

        TopFrequentFinder topFrequentFinder = new TopFrequentFinder();
        List<Integer> kFrequent = topFrequentFinder.topKFrequent(Arrays.asList(5, 5, 5, 5, 5, 1, 1, 1, 2, 2, 6, 6, 6), 2);
        System.out.println(kFrequent);
    }

    private static TreeNode<Integer> printSuccessor(TreeNode<Integer> balancedTree, int startValue) {
        TreeNode<Integer> integerTreeNode = ns.findByValue(startValue, balancedTree);
        System.out.println("start node is " + integerTreeNode.getValue());
        TreeNode<Integer> inorderSuccessor = ns.inorderSuccessor(integerTreeNode);
        System.out.println("inorderSuccessor is " + (inorderSuccessor != null ? inorderSuccessor.getValue() : null));
        return inorderSuccessor;
    }
}
