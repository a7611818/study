package tree.huffman;

import tree.TreeNode;

import java.io.*;
import java.util.*;

/**
 *
 */
public class HuffMan {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new HuffMan().fileZip("C:\\Users\\ybq\\Pictures\\test.mp4"
                , "C:\\Users\\ybq\\Pictures\\1.zip");

        new HuffMan().unzip("C:\\Users\\ybq\\Pictures\\1.zip"
                , "C:\\Users\\ybq\\Pictures\\res.mp4");
    }

    public void fileZip(String src, String dst) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        TreeNode root = buildHuffman(bytes);

        Map<Byte, String> map = buildCode(root);
        byte[] zip = zip(bytes, map);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dst));
        oos.writeObject(zip);
        oos.writeObject(map);
        fis.close();
        oos.close();

    }

    public void unzip(String src, String dst) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(src));
        FileOutputStream fos = new FileOutputStream(dst);
        byte[] bytes = (byte[]) ois.readObject();
        Map<Byte, String> map = (Map<Byte, String>) ois.readObject();
        byte[] res = decode(bytes, map);
        fos.write(res);
        ois.close();
        fos.close();
    }

    private byte[] decode(byte[] bytes, Map<Byte, String> zipMap) {
        //翻转map
        Map<String, Byte> decodeMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : zipMap.entrySet()) {
            decodeMap.put(entry.getValue(), entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int temp = bytes[i];
            String str;
            str = Integer.toBinaryString(temp | 0b100000000);
            sb.append(str.substring(str.length() - 8));
        }


        List<Byte> res = new ArrayList<>();
        int start = 0, end = 1;
        ret:
        while (start < sb.length()) {
            while (!decodeMap.containsKey(sb.substring(start, end))) {
                if (++end > sb.length()) {
                    break ret;
                }
            }
            res.add(decodeMap.get(sb.substring(start, end)));
            start = end;
            end++;
        }
        bytes = new byte[res.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = res.get(i);
        }
        return bytes;
    }


    private byte[] zip(byte[] bytes, Map<Byte, String> zipMap) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(zipMap.get(b));
        }
        //把字符串sb转换为byte数组


        //后面补0,因为所有节点都是1开始，所以不会出问题
        sb.append("0000000");
        int length = sb.length() / 8;
        byte[] res = new byte[length];
        for (int i = 0, index = 0; i + 8 <= sb.length(); i += 8) {
//            if (i + 8 > sb.length()) {
//                res[index++] = (byte) Integer.parseInt(sb.substring(i), 2);
//            } else {
            res[index++] = (byte) Integer.parseInt(sb.substring(i, i + 8), 2);
//            }
        }
        return res;
    }

    /**
     * 根据赫夫曼树生成压缩编码映射
     *
     * @param root
     * @return
     */
    private Map<Byte, String> buildCode(TreeNode root) {
        //获取所有的叶子节点，包含realVal的值，生成路径：realVal值映射
        Map<Byte, String> map = new HashMap<>();
        buildCode(root, new StringBuilder("1"), map);
        return map;
    }

    /**
     * @param root
     * @param sb
     * @param map
     * @return
     */
    private Map<Byte, String> buildCode(TreeNode root, StringBuilder sb, Map<Byte, String> map) {
        if (root == null) {
            return map;
        }
        if (root.realVal == null) {
            buildCode(root.left, sb.append("0"), map);
            buildCode(root.right, sb.append("1"), map);
        } else {
            map.put(root.realVal, sb.toString());
        }
        sb.deleteCharAt(sb.length() - 1);
        return map;
    }

    /**
     * 计数字节数组构建赫夫曼树，val为出现频次，realVal为byte值
     *
     * @param bytes
     * @return
     */
    private TreeNode buildHuffman(byte[] bytes) {
//        计数
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        //根据计数结果生成树节点
        TreeNode[] treeNodes = new TreeNode[map.size()];
        int i = 0;
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            treeNodes[i] = new TreeNode(entry.getValue());
            treeNodes[i++].realVal = entry.getKey();
        }
        //根据树节点数组，生成赫夫曼树
        return buildHuffman(treeNodes);

    }

    /**
     * 根据树节点构建赫夫曼树
     *
     * @param treeNodes
     * @return
     */
    private TreeNode buildHuffman(TreeNode[] treeNodes) {
        return buildHuffman(treeNodes, 0);
    }

    /**
     * 从i开始构建赫夫曼树
     *
     * @param node
     * @param i
     * @return
     */
    private TreeNode buildHuffman(TreeNode[] node, int i) {
        //只剩下一个节点直接返回
        if (node.length == i + 1) {
            return node[i];
        }

        //二合一
        Arrays.sort(node, Comparator.comparingInt(x -> x.val));
        TreeNode root = new TreeNode(node[i].val + node[i + 1].val);
        root.left = node[i];
        root.right = node[i + 1];
        node[++i] = root;
        return buildHuffman(node, i);
    }
}
