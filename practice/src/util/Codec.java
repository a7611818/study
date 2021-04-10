package util;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class Codec {// Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        LinkedList<Integer> tree = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node == null) {
                    tree.add(null);
                } else {
                    tree.add(node.val);
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
        }
        while (tree.size() != 0 && tree.getLast() == null) {
            tree.removeLast();
        }
        for (int i = 0; i < tree.size(); i++) {
            if (i == 0) {
                sb.append(tree.get(i).toString());
            } else {
                sb.append("," + tree.get(i));
            }
        }
        sb.append("]");
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] elements = data.split("[\\[\\]\\,]");
        List<Integer> list = new ArrayList<>();
        for (String s : elements) {
            if (s.length() == 0) continue;
            if (s.charAt(0) == 'n') {
                list.add(null);
            } else {
                list.add(new Integer(s));
            }
        }
        if (list.size() == 0) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int idx = 0;
        TreeNode root = new TreeNode(list.get(idx++));
        queue.addLast(root);
        while (!queue.isEmpty() && idx < list.size()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.removeFirst();
                Integer left = idx < list.size() ? list.get(idx++) : null;
                Integer right = idx < list.size() ? list.get(idx++) : null;
                if (left != null) {
                    TreeNode leftNode = new TreeNode(left);
                    node.left = leftNode;
                    queue.addLast(leftNode);
                }
                if (right != null) {
                    TreeNode rightNode = new TreeNode(right);
                    node.right = rightNode;
                    queue.addLast(rightNode);
                }
            }
        }
        return root;
    }
}
