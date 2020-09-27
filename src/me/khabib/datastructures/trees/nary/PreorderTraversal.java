package me.khabib.datastructures.trees.nary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class PreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> nodes = new ArrayList<>();
        preorder(root, nodes);
        return nodes;
    }

    private void preorder(Node root, List<Integer> nodes) {
        if (root == null) return;
        nodes.add(root.val);
        if (root.children != null)
            for (Node child : root.children) {
                preorder(child, nodes);
            }
    }

    public static void main(String[] args) {
        List<Node> a = Arrays.asList(new Node(5), new Node(6));
        List<Node> b = Arrays.asList(new Node(2, a), new Node(2), new Node(4));
        Node root = new Node(1, b);
        System.out.println(new PreorderTraversal().preorder(root));
    }
}
