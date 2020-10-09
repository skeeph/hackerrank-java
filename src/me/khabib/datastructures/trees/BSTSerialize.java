package me.khabib.datastructures.trees;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class BSTSerialize {
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        makeString(root, sb);
        return sb.toString();
    }

    public void makeString(TreeNode root, StringBuffer sb) {
        if (root == null) return;
        sb.append(root.val);
        sb.append(" ");
        makeString(root.left, sb);
        makeString(root.right, sb);
    }


    public TreeNode deserialize(String data) {
        if ("".equals(data.trim())) return null;
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++) {
            TreeNode curr = root;
            int val = Integer.parseInt(str[i]);
            while (true) {
                if (curr.val > val) {
                    if (curr.left != null) {
                        curr = curr.left;
                    } else {
                        curr.left = new TreeNode(val);
                        break;
                    }
                } else {
                    if (curr.right != null) {
                        curr = curr.right;
                    } else {
                        curr.right = new TreeNode(val);
                        break;
                    }
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        BSTSerialize serializer = new BSTSerialize();
        String serialized = serializer.serialize(node);
        System.out.println(serializer.deserialize(serialized));
    }
}
