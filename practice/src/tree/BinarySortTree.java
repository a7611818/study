package tree;

/**
 * 实现左旋右旋和双旋
 *
 * @author ybq
 */
public class BinarySortTree {
    TreeNode root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] ints = new int[100];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }

        for (int i = 0; i < ints.length; i++) {
            //从i到ints.length-1获取一个数，放在i里面
            double v = Math.random() * (ints.length - i) + i;
            int temp = ints[i];
            ints[i] = ints[(int) v];
            ints[(int) v] = temp;
        }

        for (int num : ints) {
            tree.add(new TreeNode(num));
        }
        
        tree.prev();
    }
}