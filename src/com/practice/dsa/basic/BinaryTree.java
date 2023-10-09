package com.practice.dsa.basic;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root = null;

    BinaryTree(Node x) {
        this.root = x;
    }

    public void insertPreoder(Node x, Node z) {
        if (x != null && z != null) {
            java.util.Stack<Node> s = new java.util.Stack<>();
            s.push(x);
            while (!s.isEmpty()) {
                Node y = s.pop();
                if (y.right != null) s.push(y.right);
                else {
                    y.right = z;
                    return;
                }
                if (y.left != null) s.push(y.left);
                else {
                    y.left = z;
                    return;
                }
            }
        }

    }

    public void inorderRecurvive(Node x) {
        if (x != null) {
            inorderRecurvive(x.left);
            System.out.println(x.data);
            inorderRecurvive(x.right);
        }
    }

    public void preorderRecurvive(Node x) {
        if (x != null) {
            System.out.println(x.data);
            preorderRecurvive(x.left);
            preorderRecurvive(x.right);
        }
    }

    public void postorderRecurvive(Node x) {
        if (x != null) {
            postorderRecurvive(x.left);
            postorderRecurvive(x.right);
            System.out.println(x.data);
        }
    }

    public void levelOrderTraversal(Node x) {
        if (x != null) {
            Queue<Node> q = new LinkedList<>();
            q.offer(x);
            q.offer(null);
            while (!q.isEmpty()) {
                Node y = q.poll();
                if (y == null) {
                    if (!q.isEmpty()) {
                        q.offer(null);
                    }
                } else {
                    System.out.println(y.data);
                    if (y.left != null) q.offer(y.left);
                    if (y.right != null) q.offer(y.right);
                }
            }
        }
    }

    public void preorderIterative(Node x) {
        if (x != null) {
            java.util.Stack<Node> s = new java.util.Stack<>();
            s.push(x);
            while (!s.isEmpty()) {
                Node y = s.pop();
                System.out.println(y.data);
                if (y.right != null) s.push(y.right);
                if (y.left != null) s.push(y.left);
            }
        }
    }

    public static class Node {
        Node left;
        Node right;
        int data;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }

        Node(Node x) {
            this.data = x.data;
            this.left = x.left;
            this.right = x.right;
        }
    }

    public static void main(String[] args) {
        Node x = new BinaryTree.Node(1);
        BinaryTree b = new BinaryTree(x);
        b.insertPreoder(x, new BinaryTree.Node(2));
        b.insertPreoder(x, new BinaryTree.Node(3));
        b.insertPreoder(x, new BinaryTree.Node(4));
        b.preorderRecurvive(b.root);
        b.inorderRecurvive(b.root);
        b.postorderRecurvive(b.root);
        b.levelOrderTraversal(b.root);
        b.preorderIterative(b.root);

        //JAVA has Treeset and TreeMap
    }
}
