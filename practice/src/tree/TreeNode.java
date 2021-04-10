package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public TreeNode left;
    public boolean leftType = false;

    public Integer val;
    public Byte realVal;

    public TreeNode right;
    public boolean rightType = false;

    public TreeNode(int val) {
        this.val = val;
    }

    //算高度
    public int height() {
        return 1 + (Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()));
    }

    /**
     * @param node
     */
    public TreeNode add(TreeNode node) {
        if (val > node.val) {
            if (left != null) {
                left = left.add(node);
            } else {
                left = node;
            }

        } else {
            if (right != null) {
                right = right.add(node);
            } else {
                right = node;
            }
        }

        //判断是否需要旋转
        if (leftHeight() - rightHeight() >= 2) {
            if (left.rightHeight() > left.leftHeight()) {
                //左节点坐旋转
                TreeNode left = this.left;
                TreeNode temp = left.right.left;
                this.left = this.left.right;
                this.left.left = left;
                this.left.left.right = temp;

            }
//                右旋转
            TreeNode res = this.left;
            TreeNode root = this;
            TreeNode temp = root.left.right;
            root.left.right = root;
            root.left = temp;
            return res;


        } else if (rightHeight() - leftHeight() >= 2) {
            if (right.leftHeight() > right.rightHeight()) {
                //左节点坐旋转
                TreeNode right = this.right;
                TreeNode temp = right.left.right;
                this.right = this.right.left;
                this.right.right = right;
                this.right.right.left = temp;
            }
//              右旋转
            TreeNode res = this.right;
            TreeNode root = this;
            TreeNode temp = root.right.left;
            root.right.left = root;
            root.right = temp;

            return res;

        }
        return this;
    }

    private int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    private int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        Queue<TreeNode> temp = new LinkedList<>();
        while (queue.size() > 0) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                str.append(poll.val + ",");
                temp.add(poll.left);
                temp.add(poll.right);
            } else {
                str.append("null,");
            }
            if (queue.size() == 0) {
                queue = temp;
            }
        }
        return str.toString();
    }
}
