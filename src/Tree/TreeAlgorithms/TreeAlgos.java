package Tree.TreeAlgorithms;

import Tree.TreeImplementation.BTNode;

import java.util.ArrayList;
import java.util.Stack;

public class TreeAlgos {
    public void preOrderRecursive(BTNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public ArrayList<Integer> preOrderIterative(BTNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<BTNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BTNode temp = stack.pop();
            res.add(temp.data);

            // Pay more attention to this, we push the right subtree first and then
            // the left subtree into the stack, so that we can maintain the order of
            // Node -> Left Subtree -> Right Subtree, while popping from the stack.
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    public void inOrderRecursive(BTNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.println(root.data);
            inOrderRecursive(root.right);
        }
    }

    public ArrayList<Integer> inOrderIterative(BTNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<BTNode> stack = new Stack<>();
        stack.push(root);
        BTNode cur = root.left;
        while (!stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.data);
                cur = cur.right;
            }
        }
        return res;
    }
}
