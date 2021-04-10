package tree;

public class BinaryTree {
    TreeNode root;

    /**
     * 添加一个节点
     *
     * @param node
     */
    public void add(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root = root.add(node);
        }
    }

    public void prev() {
        prev(root);
    }

    private void prev(TreeNode root) {
        if (root == null) {
            return;
        }
        prev(root.left);
        System.out.println(root.val);
        prev(root.right);
    }

}
