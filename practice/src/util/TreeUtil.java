package util;


import tree.TreeNode;

public class TreeUtil {
    public static void main(String[] args) {
        TreeNode deserialize = Codec.deserialize("[1,2,3,4,5,6,7,8]");
        orderThreaded(deserialize);
        System.out.println(deserialize);
    }

    private static TreeNode pre;

    public static void orderThreaded(TreeNode root) {
        if (root == null) {
            return;
        }
        orderThreaded(root.left);
        if (pre != null && pre.right == null) {
            pre.right = root;
            pre.rightType = true;
        }
        if (pre != null && root.left == null) {
            root.left = pre;
            root.leftType = true;
        }
        pre = root;
        orderThreaded(root.right);
    }
}
