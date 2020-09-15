package me.khabib.datastructures.trees;

import java.util.*;
import java.util.stream.Collectors;

public class BSTSerialize {
    public String serialize(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.poll();
            if (current != null) {
                nodes.add(current.left);
                nodes.add(current.right);
                vals.add(current.val);
            } else {
                vals.add(null);
            }
        }
        return vals.stream().map(Objects::toString).collect(Collectors.joining(","));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> values = Arrays.stream(data.split(",")).map(x -> x.equals("null") ? null : Integer.valueOf(x)).collect(Collectors.toList());
        return build(values.toArray(Integer[]::new), 0);
    }

    private static TreeNode build(Integer[] values, int k){
        if (k>=values.length || values[k]==null) return null;
        TreeNode root = new TreeNode(values[k]);
        root.left=build(values,2*k+1);
        root.right=build(values,2*k+2);
        return root;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        BSTSerialize serializer = new BSTSerialize();
        String serialized = serializer.serialize(node);
        System.out.println(serializer.deserialize(serialized));
    }
}
