package com.practice.dsa.basic;

public class nAryTree {

    Node root;

    public nAryTree(Node root){
        this.root = root;
    }

    public static class Node {
        int data;
        Node sibling;
        Node child;

        Node(int data) {
            this.data = data;
        }
    }
}
