package com.practice.dsa.basic;

import java.util.Arrays;

public class AdjacencyListGraph implements Graph {
    Node[] nodeList;
    int vertexCount;

    //Space: O(V+E)
    public AdjacencyListGraph(int vertexCount) {
        nodeList = new Node[vertexCount];
        this.vertexCount = vertexCount;
    }

    //O(1) Time
    @Override
    public void addEdge(int i, int j) {
        Node x = nodeList[i];
        nodeList[i] = insertAtBeginning(x, new Node(j));
        x = nodeList[j];
        nodeList[j] = insertAtBeginning(x, new Node(i));
    }

    //O(V) time
    @Override
    public void removeEdge(int i, int j) {
        Node x = nodeList[i];
        nodeList[i] = removeAtBeginning(x, j);
        x = nodeList[j];
        nodeList[j] = removeAtBeginning(x, i);
    }

    //O(V) time
    @Override
    public boolean isEdgeExists(int i, int j) {
        return search(nodeList[i], j);
    }

    //O(V+E) time
    @Override
    public void display() {
        int i = 0;
        for (Node x : nodeList) {
            System.out.print(i++ + ":");
            Node cur = x;
            while (cur != null) {
                System.out.print(cur.i + "-->");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    private static class Node {
        int i;
        Node next;

        Node() {
        }

        Node(int j) {
            this.i = j;
        }
    }

    private static Node insertAtBeginning(Node x, Node y) {
        if (y != null) {
            y.next = x;
            return y;
        }
        return null;
    }

    private static Node removeAtBeginning(Node x, int i) {
        Node head = x, cur = x, prev = null;

        while (cur != null) {
            if (cur.i == i) {
                if (head == cur) {
                    head = head.next;
                    cur.next = null;
                    break;
                }
                prev.next = cur.next;
                cur.next = null;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    private static boolean search(Node x, int i) {
        if (x != null) {
            Node cur = x;
            while (cur != null) {
                if (cur.i == i) return true;
                cur = cur.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AdjacencyListGraph g = new AdjacencyListGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.display();
        System.out.println(g.isEdgeExists(1, 0));
        g.removeEdge(0, 3);
        g.display();
        System.out.println(g.isEdgeExists(0, 3));
    }
}
