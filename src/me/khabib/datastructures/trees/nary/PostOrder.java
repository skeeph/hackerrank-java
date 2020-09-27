package me.khabib.datastructures.trees.nary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class PostOrder {
    public List<Integer> postorder(Node root) {
        List<Integer> nodes = new ArrayList<>();
        postorder(root, nodes);
        return nodes;
    }

    private void postorder(Node root, List<Integer> nodes) {
        if (root == null) return;
        if (root.children != null)
            for (Node child : root.children) postorder(child, nodes);
        nodes.add(root.val);
    }

    public static void main(String[] args) {
        List<Node> a = Arrays.asList(new Node(5), new Node(6));
        List<Node> b = Arrays.asList(new Node(3, a), new Node(2), new Node(4));
        Node root = new Node(1, b);
        System.out.println(new PostOrder().postorder(root));
    }
}
